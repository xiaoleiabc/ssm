package com.service;

import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer empId);
    PageInfo<Employee> getAllEmployeePage(Integer pageNum);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer empId);
}
