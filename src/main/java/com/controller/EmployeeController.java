package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import com.service.EmployeeService;
import org.apache.ibatis.annotations.Many;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getAllEmployee(@PathVariable("pageNum") Integer pageNum, Model model){
        PageInfo<Employee> page=employeeService.getAllEmployeePage(pageNum);
        model.addAttribute("page",page);
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect://employee/page/1";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET)
    public String updateEmployee(@PathVariable("empId") Integer empId,Model model){
        Employee employee=employeeService.getEmployeeById(empId);
        //将员工信息共享到请求域中
        model.addAttribute("employee",employee);
        return "updateemployee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String toupdateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        //从定向到列表界面展示信息
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/page/1";
    }

}
