package com.qi.web.controller;

import com.qi.web.mapper.DepartmentMapper;
import com.qi.web.mapper.EmployeeMapper;
import com.qi.web.pojo.Department;
import com.qi.web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/employees")
    public String list(Model model)
    {
        Collection<Employee>  employees = employeeMapper.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model)
    {
        model.addAttribute("dpt",departmentMapper.getDepartments());
        return "emp/toAdd";
    }

    @PostMapping("/toAdd")
    public String AddEmp(Employee employee)
    {
        employeeMapper.save(employee);
        return "redirect:/employees";
    }

    // 员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        // 查找出数据来源
        Employee employeeById = employeeMapper.getEmployeeById(id);
        System.out.println(employeeById);
        model.addAttribute("emp",employeeById);
        model.addAttribute("dpt",departmentMapper.getDepartments());
        return "emp/modify";
    }

    @PostMapping("/emp/{id}")
    public String toUpdateEmp(Employee employee)
    {
        employeeMapper.delete(employee.getId());
        employeeMapper.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delemp/{id}")
    public String toDeleteEmp(@PathVariable("id") Integer id)
    {
        employeeMapper.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping("/logout")
    public String toLogout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/employees";
    }
}
