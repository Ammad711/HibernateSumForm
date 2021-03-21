package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.NumbersDAO;
import com.entities.Numbers;


@Controller
public class FirstController {
	@Autowired
	NumbersDAO numbersDAO;
	
	@RequestMapping("/A")
	public String page1()
	{
		return "A";
	}
	
	@RequestMapping("/add")
	public String page2(HttpServletRequest req,Model m)
	{
		Numbers numbers=new Numbers();
		numbers.setNum1(Integer.valueOf(req.getParameter("t1")));
		numbers.setNum2(Integer.valueOf(req.getParameter("t2")));
//		System.out.println(numbers.getNum1());
//		System.out.println(numbers.getNum2());
		numbers.setSum(numbers.getNum1()+numbers.getNum2());
//		System.out.println(numbers.getSum());
		m.addAttribute("sum", numbers.getSum());
		int j=this.numbersDAO.save(numbers);
		System.out.println(j);
		return "add";
		
	}

}
