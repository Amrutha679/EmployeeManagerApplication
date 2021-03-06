package com.mondee.controller;


import com.mondee.model.Employee;
import com.mondee.repository.EmployeeRepository;
import com.mondee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String saveDetails(Model model, Employee employee)
    {
        employeeRepository.save(employee);
        model.addAttribute("employee",employee);
        return "employeelogin";
    }

    @RequestMapping(value="/employeelogin",method = {RequestMethod.POST,RequestMethod.GET})
    public String employeeLogin(Model model,Employee employee)
    {
       Employee ee= employeeService.loginByCredentials(employee.getEmail(),employee.getPassword());
        model.addAttribute("employee",ee);
        return "employeehome";
    }

    @RequestMapping(value="/myprofile/{id}")
    public String employeeProfile(@PathVariable("id") int id,Model model)
    {
    Employee employee =  employeeRepository.findById(id).get();
    System.out.println(employee.getEmail());
    model.addAttribute("employee",employee);
    return "employeeprofile";
    }

}

