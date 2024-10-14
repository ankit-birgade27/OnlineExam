package com.example.onlineExam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Entity.User;
import com.example.Entity.Users;

@Controller
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	
	@RequestMapping("login")
	public ModelAndView login(User user) {
		

		
		Session session = factory.openSession();
		
		ModelAndView modelAndView = new ModelAndView();
		
		try {
		Users users = session.load(Users.class, user.getUsername());
		
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin@123")){
			
			modelAndView.setViewName("questionmanagement");
			return modelAndView;
		}
		else if (user.getPassword().equals(users.getPassword())) {

			modelAndView.setViewName("questions");
			modelAndView.addObject("message","registration successful.");
			return modelAndView;
		}  
		else {
			modelAndView.setViewName("login");
			modelAndView.addObject("errormsg","wrong password");
			return modelAndView;
		}
		}
		catch(Exception e){
			modelAndView.setViewName("login");
			modelAndView.addObject("errormsg","Invalid username");
			return modelAndView;
		}
		
		
	}
}
