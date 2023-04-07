package com.mapper;

import com.pojo.Admin;
import com.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {

    @Results(id = "adminMap",
            value ={
            @Result(column = "admin_name",property = "adminName"),
            @Result(column = "admin_password",property = "adminPassword")
            }
    )
    @Select("select * from admin")
    List<Admin> getAdmin();

    @Insert("insert into admin(admin_name,admin_password) values (#{adminName},#{adminPassword})")
    @ResultMap(value = {"adminMap"})
    void addAdmin(Admin admin);
}
