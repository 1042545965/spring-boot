package com.project.springboot.service;

import com.google.gson.Gson;
import com.project.springboot.bean.Department;
import com.project.springboot.bean.Employee;
import com.project.springboot.cache.service.CacheService;
import com.project.springboot.dao.DepartmentMapper;
import com.project.springboot.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-boot
 * @description:
 * @author: conlon
 * @create: 2018-08-18 14:21
 **/
@Service
public class DepService {
    @Autowired
    private DepartmentMapper departmentMapper; //注入mapper

    @Autowired
    private EmployeeMapper employeeMapper;

    //因为spring的缓存实际上是使用aop 动态代替的,所以需要单独抽取出来做进行调用这样才能起作用
    @Autowired
    private CacheService cacheService;
    @Cacheable(cacheNames = {"dept"})
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @CachePut(cacheNames = {"dkzept"} , key = "#employee.id")
    public Employee updateDept(Employee employee){
        departmentMapper.updateById(employee);
        return employee;
    }

    public Employee getEmployee(Integer id) {
        return cacheService.getEmployee("dkztest" ,id);
    }

    public Employee getRedis01(Integer id){
        Employee employee = cacheService.getRedisEmployee(id);
        return employee;
    }

    @Transactional
    public String testTransaction(Employee employee , Department department){
        employeeMapper.insert(department);
        employee.setdId(department.getId());
        Integer aa = Integer.parseInt("asadsadsa");
        departmentMapper.insert(employee);
        return "";
    }
}
