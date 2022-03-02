package com.mondee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mondee.model.Employee;
import com.mondee.model.Leave;
import com.mondee.repository.EmployeeRepository;
import com.mondee.repository.LeaveRepository;
import com.mondee.service.LeaveService;

import ch.qos.logback.core.util.Duration;


@Controller
public class LeaveController {

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LeaveService leaveService;
	
	@RequestMapping(value="/employee/{id}/leave")
    public String applyLeaves(Model model, @PathVariable int id)
    {
        model.addAttribute("id",id);
        model.addAttribute("employee",employeeRepository.findById(id).get());
        model.addAttribute("leave", new Leave());
        return "applyleave";
    }
	@RequestMapping(value="/employee/{id}/leave/save",method= RequestMethod.POST)
    public String saveLeave(Leave leave,@PathVariable int id,Model model)
    {
		Employee employee=employeeRepository.findById(id).get();
        leave.setEid(employee.eid);
        leaveRepository.save(leave);
        model.addAttribute("employee",employee);
        return "employeehome";
        
    }

    @RequestMapping(value="/employee/{id}/myapplications",method= RequestMethod.GET)
    public String myLeave(Leave leave, @PathVariable int id, Model model)
    {
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getApplicants(employee));
        model.addAttribute("employee",employee);
        return "employeeapplications";
    }
	
 
    @RequestMapping(value="/accept/{id}",method= RequestMethod.GET)
    public String acceptAppointment(Leave leave, @PathVariable int id, Model model) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
    	leaveService.acceptApplication(id);
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getApplicants(employee));
        model.addAttribute("employee",employee);
        return "employeeapplications";
    }

    @RequestMapping(value="/reject/{id}",method= RequestMethod.GET)
    public String rejectAppointment(Leave leave, @PathVariable int id, Model model) throws HeuristicRollbackException, SystemException, HeuristicMixedException, RollbackException {
    	leaveService.rejectApplication(id);
    	Employee employee=employeeRepository.findById(id).get();
        model.addAttribute("leaves",leaveService.getApplicants(employee));
        model.addAttribute("employee",employee);
        return "employeeapplications";      
    }

}
