package com.cognixia.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
		if (session.getAttribute("userId") != null) {
			System.out.println("setting userid attribute");
			User user = new User();
			int userId = (int) session.getAttribute("userId");
			user.setUserId(userId);
			mv.addObject(user);
		}
		if (session.getAttribute("adminId") !=null) {
			System.out.println("setting adminid attribute");
			Admin admin = new Admin();
			int adminId = (int) session.getAttribute("adminId");
			admin.setAdminId(adminId);
			mv.addObject(admin);
		}
		return mv;
	}
	@GetMapping("/userAccount")
	public String userAccount(@RequestParam int userId, @RequestParam String userPassword, HttpSession session) {
		if(userRepo.existsByUserIdAndUserPassword(userId, userPassword)){
			System.out.println("This combination of userid and password exists");
			session.setAttribute("userId", userId);
			session.setAttribute("adminId", null);
		}else {
			//return the login page, yeah shit it would be dope if js could just be like oh na do that shit again. I would need node for that
			//so I can do the same thing I did last time, just return the same page just with an error messge, call it error login
		}
		return ("/");
	}
	
	@GetMapping("/adminAccount")
	public String adminAccount(@RequestParam int adminId, @RequestParam String adminPassword, HttpSession session) {
		if (adminRepo.existsByAdminIdAndAdminPassword(adminId, adminPassword)) {
			System.out.println("This combination of adminid and password exists");
			session.setAttribute("adminId", adminId);
			session.setAttribute("userId", null);
		}
		return "/";
	}
	@GetMapping("/createaccount")
	public String createaccount(User user) {
		userRepo.save(user);
		return "login.html";
	}
	@GetMapping("/catalog")
	public ModelAndView catalog() {
		ModelAndView mv = new ModelAndView("catalog.jsp");
		//creating table
		List <Book> bookList = bookRepo.findAll();
		String displayText = Book.tableHeader();
		for (Book book : bookList) {
			displayText+= book.toString();
		}
		displayText += Book.tableFooter();
		mv.addObject("displayText", displayText);
		return mv;//I gotta make this so that the books with a stock of 0 font display
	}
	@GetMapping("/putonhold")
	public ModelAndView putOnHold(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("putonhold.jsp");
		Date date = new Date();
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
			displayText+= onHold.toString();
		}
		displayText += OnHold.tableFooter();
		mv.addObject("displayText", displayText);
		return mv;
	}/*ok my thoughts are a little blurry with this, only admin can come here, yes, ill input a session id attribute later, yeah.
	its gonna be a list of all books that are on hold, then the admin is going to check when the user is physically in store to pick the books up, 
	then the thangs are going to be moved from onhold to borrowed with a time stamp on it, similar to catalog.
	might end up adding book title to this table, its not too user friendly with just the usbn like it is now.
	*/
	
	@GetMapping("/putonborrow")
	public ModelAndView putOnBorrow(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("putonborrow.jsp");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm z");
		String strDate = formatter.format(date);
		String[] values = request.getParameterValues("book");
		for (String value : values) {
			OnHold onHold = onHoldRepo.findByTransactionId(Integer.parseInt(value));
			onHoldRepo.delete(onHold);
			//onHold.setTransactionTime(strDate);
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
			displayText+= borrowed.toString();
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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		session.setAttribute("adminId", null);
		System.out.println("userid and adminid are null");
		return "index.jsp";
	}
}
