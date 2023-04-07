package com.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    @Override
    public PageInfo<Employee> getAllEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Employee> list=employeeMapper.getAllEmployee();
        PageInfo<Employee> page=new PageInfo<>(list,5);
        return page;
    }


    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeeMapper.deleteEmployee(empId);
    }
}
