package com.mapper;


import com.pojo.Employee;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface EmployeeMapper {
    @Results(
            id = "EmployeeMap",
            value =  {
                    @Result(id = true,column = "emp_id",property = "empId"),
                    @Result(column = "emp_name",property = "empName"),
                    @Result(column = "age",property = "age"),
                    @Result(column = "gender",property = "gender"),
                    @Result(column = "email",property = "email")
            }
    )
    @Select("select * from t_emp")
    List<Employee> getAllEmployee();

    @Select("select * from t_emp where emp_id=#{empId}")
    @ResultMap(value = {"EmployeeMap"})
    Employee getEmployeeById(Integer empId);

    @Insert("insert into t_emp(emp_name,age,gender,email)values (#{empName},#{age},#{gender},#{email})")
    @ResultMap(value = {"EmployeeMap"})
    void addEmployee(Employee employee);

    @Update("update t_emp set emp_name=#{empName},age=#{age},gender=#{gender},email=#{email} where emp_id=#{empId}")
    @ResultMap(value = {"EmployeeMap"})
    void updateEmployee(Employee employee);

    @Delete("delete from t_emp where emp_id=#{empId}")
    @ResultMap(value = {"EmployeeMap"})
    void deleteEmployee(Integer empId);

}
