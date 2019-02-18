package com.project.springboot.cache.service;

import com.project.springboot.bean.Employee;
import com.project.springboot.dao.DepartmentMapper;
import com.project.springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @program: spring-boot
 * @description: 所有走缓存的基类查询全部都要放置在这里面
 * @author: conlon
 * @create: 2018-08-20 10:42
 **/
@Service
@CacheConfig(cacheNames  = "cacheService")
public class CacheService implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5291747509289487657L;

	@Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Cacheable(key = "#key + #id")
    public Employee getEmployee(String key , Integer id) {
        return departmentMapper.selectById(id);
    }

    public Employee getRedisEmployee(Integer id) {
        Object obj =  redisUtil.get("dkzredis");
        if(StringUtils.isEmpty(obj)){
            Employee employee = departmentMapper.selectById(id);
            redisUtil.set("dkzredis",employee);
            return employee;
        }else {
            return (Employee)obj;
        }
    }

}
