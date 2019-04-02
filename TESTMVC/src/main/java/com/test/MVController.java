package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVController {
	@Autowired
	EmployeeDao dao;
	/*@RequestMapping(value="/go")
	public String add(Model m)
	{
		Employee emp=new Employee();
		m.addAttribute("emp", emp);  
		return "upload";
	}*/
	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public ModelAndView save(@ModelAttribute("emp")Employee emp)
	{
		System.out.println(emp.getId()+emp.getName()+emp.getSalary());
		int j=dao.save(emp);
		System.out.println(j);
		return new ModelAndView("welcome","command",emp);
		
	}
	@RequestMapping(value="/bye")
	public String redirection(Model model)
	{
		List<Employee> employees=dao.getallEmployees();
		/*System.out.println(employee.getName()+""+employee.getSalary());*/
		model.addAttribute("employees", employees);
		return ("view1/bye");
	}
	@RequestMapping(value="/lastone")
	public String lastone(Model model)
	{
		return "NewFile";
	}
	@RequestMapping(value="/datereciever")
	public void datereciever(@RequestParam("mydate") String mydate) {
		System.out.println(mydate);
	}

}
