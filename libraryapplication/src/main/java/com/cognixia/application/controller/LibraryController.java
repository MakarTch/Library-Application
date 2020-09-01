package com.cognixia.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cognixia.application.dao.AdminDAO;
import com.cognixia.application.dao.BookDAO;
import com.cognixia.application.dao.BorrowedDAO;
import com.cognixia.application.dao.OnHoldDAO;
import com.cognixia.application.dao.UserDAO;
import com.cognixia.application.model.Admin;
import com.cognixia.application.model.Book;
import com.cognixia.application.model.Borrowed;
import com.cognixia.application.model.OnHold;
import com.cognixia.application.model.User;

@Controller
//@RequestMapping("/home")
public class LibraryController {
	
	@Autowired
	UserDAO userRepo;
	@Autowired
	AdminDAO adminRepo;
	@Autowired
	BookDAO bookRepo;
	@Autowired
	OnHoldDAO onHoldRepo;
	@Autowired
	BorrowedDAO borrowedRepo;
	
	@GetMapping("/")
	public ModelAndView home(HttpSession session) {		
		ModelAndView mv = new ModelAndView("index.jsp");
		String pageHeader = User.nonUserHeaderString();
		String pageFooter = User.footerString();
		session.setAttribute("pageHeader", pageHeader);
		session.setAttribute("pageFooter", pageFooter);
		if (session.getAttribute("userId") != null) {
			pageHeader = User.headerString();
			session.setAttribute("pageHeader", pageHeader);
		}
		if (session.getAttribute("adminId") !=null) {
			pageHeader = Admin.headerString();
			session.setAttribute("pageHeader", pageHeader);
		}
		return mv;
	}
	
	@GetMapping("/userAccount")
	public String userAccount(@RequestParam int userId, @RequestParam String userPassword, HttpSession session) {
		if(userRepo.existsByUserIdAndUserPassword(userId, userPassword)){
			session.setAttribute("userId", userId);
			session.setAttribute("adminId", null);
			session.setAttribute("pageHeader", User.headerString());
		}else {
			return "errorlogin.jsp";
		}
		return ("/");
	}
	
	@GetMapping("/adminAccount")
	public String adminAccount(@RequestParam int adminId, @RequestParam String adminPassword, HttpSession session) {
		if (adminRepo.existsByAdminIdAndAdminPassword(adminId, adminPassword)) {
			session.setAttribute("adminId", adminId);
			session.setAttribute("userId", null);
			session.setAttribute("pageHeader", Admin.headerString());
		}else {
			return "errorlogin.jsp";
		}
		return "/";
	}
	@GetMapping("/createaccount")
	public ModelAndView createaccount(User user) {
		ModelAndView mv = new ModelAndView("/login.jsp");
		userRepo.save(user);
		mv.addObject("newAccount", "New account has been created with User ID:" + user.getUserId() + " and Password:" + user.getUserPassword() + ", dont forget these!");
		return mv;
	}

	@GetMapping("/catalog")
	public ModelAndView catalog(HttpSession session) {
		ModelAndView mv = new ModelAndView("catalog.jsp");
		//creating table
		List <Book> bookList = bookRepo.findAll();
		String displayText = (session.getAttribute("userId")!=null)?Book.tableHeader():Book.withoutChecksTableHeader();
		for (Book book : bookList) {
			if (session.getAttribute("userId")!=null) {
				displayText+= book.toString();
			}else {
				displayText+= book.withoutChecksToString();
			}
		}
		displayText += Book.tableFooter();
		if (session.getAttribute("userId")!=null) {
			displayText+= Book.submitButton();
		}
		mv.addObject("displayText", displayText);
		return mv;
	}
	@GetMapping("/putonhold")
	public ModelAndView putOnHold(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("putonhold.jsp");
		Date date = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("US/Eastern"));
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm z");
		String strDate = formatter.format(date);
		int userId = (int) session.getAttribute("userId");
		String[] values = request.getParameterValues("book");
		for (String value : values) {
			OnHold book = new OnHold(userId,Long.parseLong(value),strDate);
			onHoldRepo.save(book);
			Book book2 =bookRepo.findByBookISBN(Long.parseLong(value));
			book2.setInStock(book2.getInStock()-1);
			bookRepo.save(book2);
		}
		String books =values.length>1?"books have":"book has";
		mv.addObject("books",books);
		return mv;
	}
	
	@GetMapping("/currentlyonhold")
	public ModelAndView currentlyOnHold(){
		ModelAndView mv = new ModelAndView("currentlyonhold.jsp");
		List <OnHold> onHoldList = onHoldRepo.findAll();
		String displayText = OnHold.tableHeader();
		for (OnHold onHold : onHoldList) {
			String bookName = bookRepo.findByBookISBN(onHold.getBookISBN()).getBookTitle();
			displayText+= onHold.toString(bookName);
		}
		displayText += OnHold.tableFooter();
		mv.addObject("displayText", displayText);
		return mv;
	}
	
	@GetMapping("/putonborrow")
	public ModelAndView putOnBorrow(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("putonborrow.jsp");
		Date date = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("US/Eastern"));
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm z");
		String strDate = formatter.format(date);
		String[] values = request.getParameterValues("book");
		for (String value : values) {
			OnHold onHold = onHoldRepo.findByTransactionId(Integer.parseInt(value));
			onHoldRepo.delete(onHold);
			Borrowed newBorrowedBook = new Borrowed(onHold.getUserId(), onHold.getBookISBN(),strDate);
			borrowedRepo.save(newBorrowedBook);
		}
		String displayText = (values.length>1)?"books":"book";
		mv.addObject("displayText", displayText);
		return mv;
	}
	@GetMapping("/currentlyborrowed")
	public ModelAndView currentlyBorrowed() {
		ModelAndView mv = new ModelAndView("currentlyborrowed.jsp");
		List <Borrowed> borrowedList = borrowedRepo.findAll();
		String displayText = Borrowed.tableHeader();
		for (Borrowed borrowed : borrowedList) {
			String bookName = bookRepo.findByBookISBN(borrowed.getBookISBN()).getBookTitle();
			displayText+= borrowed.toString(bookName);
		}
		displayText += Borrowed.tableFooter();
		mv.addObject("displayText", displayText);
		return mv;
	}
	@GetMapping("/putoffborrow")
	public ModelAndView putOffBorrow(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("putoffborrow.jsp");
		String[] values = request.getParameterValues("book");
		for (String value : values) {
			Borrowed borrowedBook = borrowedRepo.findByTransactionId(Integer.parseInt(value));
			borrowedRepo.delete(borrowedBook);
			Book updatedBook = bookRepo.findByBookISBN(borrowedBook.getBookISBN());
			updatedBook.setInStock(updatedBook.getInStock()+1);
			bookRepo.save(updatedBook);
			
		}
		String displayText = (values.length>1)?"books":"book";
		mv.addObject("displayText", displayText);
		return mv;
	}
	@GetMapping("/userinfo")
	public ModelAndView userInfo(HttpSession session) {
		ModelAndView mv = new ModelAndView("userinfo.jsp");
		String accountInfo= userRepo.findByUserId((int)session.getAttribute("userId")).toString();
		mv.addObject("accountInfo", accountInfo);
		String onHoldDisplayText = OnHold.withoutChecksTableHeader();
		List <OnHold> onHoldList = onHoldRepo.findAllByUserId((int)session.getAttribute("userId"));
		for (OnHold onHold : onHoldList) {
			String bookName = bookRepo.findByBookISBN(onHold.getBookISBN()).getBookTitle();
			onHoldDisplayText+= onHold.withoutChecksToString(bookName);
		}
		onHoldDisplayText += OnHold.tableFooter();
		mv.addObject("OnHoldDisplayText", onHoldDisplayText);
		
		String borrowDisplayText = Borrowed.withoutChecksTableHeader();
		List <Borrowed> borrowList = borrowedRepo.findAllByUserId((int)session.getAttribute("userId"));
		for (Borrowed borrow : borrowList) {
			String bookName = bookRepo.findByBookISBN(borrow.getBookISBN()).getBookTitle();
			borrowDisplayText+= borrow.withoutChecksToString(bookName);
		}
		borrowDisplayText += Borrowed.tableFooter();
		mv.addObject("BorrowedDisplayText", borrowDisplayText);
		mv.addObject("userName", userRepo.findByUserId((int)session.getAttribute("userId")).getFirstName());
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		session.setAttribute("adminId", null);
		System.out.println("userid and adminid are null");
		return "/";
	}
}
