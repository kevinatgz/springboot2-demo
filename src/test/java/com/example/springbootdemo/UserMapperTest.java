package com.example.springbootdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.enums.UserSexEnum;
import com.example.springbootdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Assert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private com.example.springbootdemo.mapper.UserMapper userMapper;

    @Test
//    @Transactional
    public void testInsert() throws Exception {
        userMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

//        Assert.assertEquals(3, userMapper.getAll().size());


        UserEntity user = userMapper.getOne(1L);
        Assert.isTrue(!"asf".equals(user.getUserName()),"fail");
        log.info(user.toString());
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserEntity::getUserName,"aaee");
        UserEntity userSel = userMapper.selectOne(wrapper);
        log.info(userSel.toString());

        userSel.setNickName("kevin3");
        userMapper.updateById(userSel);
    }
}