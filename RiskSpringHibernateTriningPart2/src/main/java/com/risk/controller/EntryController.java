package com.risk.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.risk.model.Employee;
import com.risk.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EntryController {

	@Autowired
	EmployeeService service;

	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	/*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid  Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        service.saveEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
        return "success";
    }
    
    
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{aadharNo}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String aadharNo, ModelMap model) {
        Employee employee = service.findEmployeeByAdhar(aadharNo);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{aadharNo}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String aadharNo) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isEmployeeAdharUnique(employee.getId(), employee.getAadharNo())){
            FieldError aadharNoError =new FieldError("employee","aadharNo",messageSource.getMessage("non.unique.aadharNo", new String[]{employee.getAadharNo()}, Locale.getDefault()));
            result.addError(aadharNoError);
            return "registration";
        }
 
        service.updateEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an employee by it's aadhar no value.
     */
    @RequestMapping(value = { "/delete-{aadharNo}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String aadharNo) {
        service.deleteEmployeeByAdhar(aadharNo);
        return "redirect:/list";
    }
}
