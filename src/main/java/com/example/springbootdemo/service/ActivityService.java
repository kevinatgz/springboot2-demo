package com.example.springbootdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.entity.BasicObject;

import java.util.Map;

/**
 * @author admin
 */
public interface ActivityService<T extends BasicObject> {
    public void createBusinessObj(T t, Map<String, Object> parameterMap)  throws Exception;
    public void getOne();

    public void getUsers() throws Exception;
}
