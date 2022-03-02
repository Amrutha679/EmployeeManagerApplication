package com.mondee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mondee.model.Employee;
import com.mondee.model.Manager;
import com.mondee.repository.ManagerRepository;
import com.mondee.service.LeaveService;
import com.mondee.service.ManagerService;


@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private LeaveService leaveService;
	
	 @RequestMapping(value="/save",method= RequestMethod.POST)
	    public String saveDetails(Model model, Manager manager)
	    {
		 managerRepository.save(manager);
	        model.addAttribute("manager",manager);
	        return "managerlogin";
	    }
	 
	  @RequestMapping(value="/managerlogin",method= RequestMethod.POST)
	    public String managerLogin(Model model,Manager manager)
	    {
		  Manager mng= managerService.loginByCredentials(manager.getEmail(),manager.getPassword());
	        model.addAttribute("manager",mng);
	        return "managerhome";
	    }
	  
	  @RequestMapping(value="/myprofile/{id}")
	    public String managerProfile(@PathVariable("id") int id,Model model)
	    {
		  Manager manager=  managerRepository.findById(id).get();
	    System.out.println(manager.getEmail());
	    model.addAttribute("manager",manager);
	    return "managerprofile";
	    }

	  @RequestMapping(value="/myapplicants/{id}")
	    public String myappointment(@PathVariable("id") int id, Model model)
	    {
		  Manager manager=  managerRepository.findById(id).get();
	        model.addAttribute("manager",manager);
	        model.addAttribute("list",leaveService.myApplicants(manager.getDepartment()));
	        return "managerapplications";
	    }
}
