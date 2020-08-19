package com.cognixia.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognixia.application.dao.AdminDAO;
import com.cognixia.application.dao.BookDAO;
import com.cognixia.application.dao.BorrowedDAO;
import com.cognixia.application.dao.OnHoldDAO;
import com.cognixia.application.dao.UserDAO;
import com.cognixia.application.model.Admin;
import com.cognixia.application.model.Book;
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
		return mv;
	}
	@GetMapping("/putonhold")
	public ModelAndView putOnHold(HttpSession session) {
		ModelAndView mv = new ModelAndView("putonhold.jsp");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm z");  
	    String strDate = formatter.format(date);  
	    int userId = (int) session.getAttribute("userId");
	    //looks like imma have to loop through the params, then add them one by one. 
		//onHoldRepo.save(//params here); I just need the user id, easy, book isbn, easy, transacation time,easy
		
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
