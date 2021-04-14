package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.entity.BasicObject;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void createBusinessObj(BasicObject basicObject, Map parameterMap) throws Exception {

    }

    @Override
    public void getOne() {
        UserEntity user = userMapper.selectById(19);
        log.info(user.toString());
    }

    @Override
    public void getUsers() throws Exception {
        Page<Map> pageMap = new Page(1, 5);
        QueryWrapper<Map> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("user_sex","WOMAN");
        List<Map<String,Object>> users = userMapper.selectUsersRecordPage(pageMap,queryWrapper,"WOMAN" );
        for (Map<String,Object> user:users
             ) {
            System.out.println(user);

        }
        log.info(""+pageMap.getPages());
    }
}
