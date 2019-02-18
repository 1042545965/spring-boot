package com.project.springboot.controller;



import com.project.springboot.bean.Department;
import com.project.springboot.bean.Employee;
import com.project.springboot.dao.DepartmentMapper;
import com.project.springboot.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeptController {

    @Autowired
   private DepartmentMapper departmentMapper;
    @Autowired
    private DepService depService;

    @GetMapping("/getmap/{id}")
    public Employee getDepartmentMap(@PathVariable("id") Integer id){
    	Employee empById = departmentMapper.getEmpById(id);
        return empById;
    }

    @GetMapping("/dkzemp/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return depService.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
       return departmentMapper.getEmpById(id);
    }

    @PostMapping("/emp")
    public Employee addEmployee(Employee employee) {
        departmentMapper.insert(employee);
        System.out.print(employee.getId());
        return employee;
    }

    @PutMapping("/emp")
    public Employee updateDept(Employee employee){
        Employee employee1 = depService.updateDept(employee);
        return employee1;
    }

    @GetMapping("/dkzemptt")
    public Employee getEmployee(Employee employee) {

        return depService.getEmployee(employee.getId());
    }

    @GetMapping("/getRedis01")
    public Employee getRedis01(Integer id){
        return depService.getRedis01(id);
    }

    @GetMapping("/testTransaction")
    public String testTransaction(Employee employee , Department department){
        return depService.testTransaction(employee , department);
    }
}
