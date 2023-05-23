package com.study.controller;

import com.study.dao.DepMapper;
import com.study.dao.EmpMapper;
import com.study.pojo.Department;
import com.study.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author yangz
 * @create 2021-11-05-8:36
 */
@Controller
public class EmployeeController {
    @Autowired
    EmpMapper empMapper;
    @Autowired
    DepMapper depMapper;

    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees = empMapper.queryAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/toadd")
    public String toAdd(Model model){
        List<Department> departments = depMapper.queryDeps();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        System.out.println(employee);
        empMapper.addEmp(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        empMapper.deleteEmp(id);
        return "redirect:/emps";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable int id,Model model){
        List<Department> departments = depMapper.queryDeps();
        model.addAttribute("departments",departments);

        Employee employee = empMapper.queryById(id);
        model.addAttribute("emp",employee);
        return "emp/update";
    }
    @PostMapping("/update")
    public String update(Employee employee){
      empMapper.updateEmp(employee);
        return "redirect:/emps";
    }

}
