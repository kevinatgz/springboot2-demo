package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Select("<script>\n" +
            "select user_name,count(*) as cnt from users   " +
            "<where>"+
            "<if test=\"userSex != null and userSex != ''\">\n" +
            " and user_sex=#{userSex} " +
            "</if>\n"+
            "</where>"+
            " group by user_name  ${ew.customSqlSegment} " +
            "\n</script>")
    List<Map<String, Object>> selectUsersRecordPage(Page<Map> pageMap,  @Param(Constants.WRAPPER) QueryWrapper<Map> queryWrapper
        ,@Param("userSex") String userSex  ) throws Exception;

}