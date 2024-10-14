package com.example.onlineExam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Entity.Questions;

@Controller
public class QuestionManagementController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("addQuestion")
	public ModelAndView addQuestion(Questions questions)
	{
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
			session.save(questions);
			
			tx.commit();
	
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questionmanagement");
		
		modelAndView.addObject("message", "Questions Added successfully.");
		
		return modelAndView;
		
	}
}
