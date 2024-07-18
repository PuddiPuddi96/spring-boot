package it.davide.course.mainproject.controller;

import it.davide.course.mainproject.entity.Employee;
import it.davide.course.mainproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee-controller")
public class EmployeeController {

    private static final String ATTRIBUTE_NAME_EMPLOYEE = "employee";

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list-employees";
    }

    @GetMapping("/add-employee-form")
    public String addEmployeeForm(Model model) {
        model.addAttribute(ATTRIBUTE_NAME_EMPLOYEE, new Employee());
        return "employee/employee-form";
    }

    @GetMapping("/update-employee-form")
    public String updateEmployeeForm(
            @RequestParam("id") int id,
            Model model) {
        model.addAttribute(ATTRIBUTE_NAME_EMPLOYEE, employeeService.findById(id));
        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute(ATTRIBUTE_NAME_EMPLOYEE) Employee employee,
            Model model) {
        employeeService.save(employee);
        return "redirect:/employee-controller/list";
    }

    @GetMapping("/delete")
    public String saveEmployee(@RequestParam("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employee-controller/list";
    }
}
