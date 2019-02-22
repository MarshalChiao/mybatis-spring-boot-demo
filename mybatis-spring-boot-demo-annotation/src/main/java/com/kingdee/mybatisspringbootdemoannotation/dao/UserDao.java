package com.kingdee.mybatisspringbootdemoannotation.dao;

import com.kingdee.mybatisspringbootdemoannotation.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2019/2/13
 * @Time: Created at 17:16
 * @Description:
 */
@Mapper
public interface UserDao {

    /**
     * 通过名字查询用户信息
     * @param name
     * @return
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     * @param name
     * @param age
     * @param money
     */
    @Insert("INSERT INTO user(name, age, money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据id更新用户信息
     * @param name
     * @param age
     * @param money
     * @param id
     */
    @Update("UPDATE user SET name = #{name}, age = #{age}, money = #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money, @Param("id") int id);

    /**
     * 根据id删除用户信息
     * @param id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
