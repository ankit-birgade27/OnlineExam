package com.example.onlineExam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Entity.Questions;

@Controller
public class QuestionController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("getQuestion")
	public ModelAndView getQuestion(String subject, HttpServletRequest request) {
		
		Session session = factory.openSession();

//		Criteria criteria = session.createCriteria(Questions.class);
//		criteria.add(Restrictions.eq("subject", subject));
//		List<Questions> qlist = criteria.list();
		
	
		Query query = session.createQuery("from Questions where subject= :subject");
		
		query.setParameter("subject", subject);
		
		List<Questions> ListofQuestions =query.list();
		
		System.out.println(ListofQuestions);
		
		HttpSession httpsession = request.getSession();
		
		httpsession.setAttribute("ListofQuestions", ListofQuestions);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questions");
	
		
		return modelAndView;

}
	
	
	@RequestMapping("startExam")
	public ModelAndView startExam(String subject, HttpServletRequest request) {
		
		HttpSession httpsession = request.getSession();
		
		List<Questions> listofQuestions =(List<Questions>)httpsession.getAttribute("ListofQuestions");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questionnavigation");
		modelAndView.addObject("questions", listofQuestions.get(0));
		
		return modelAndView;

	}
	
	
}