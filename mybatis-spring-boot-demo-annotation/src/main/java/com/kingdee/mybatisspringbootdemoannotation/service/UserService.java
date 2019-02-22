package com.kingdee.mybatisspringbootdemoannotation.service;

import com.kingdee.mybatisspringbootdemoannotation.bean.User;
import com.kingdee.mybatisspringbootdemoannotation.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2019/2/14
 * @Time: Created at 9:08
 * @Description:
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    /**
     * 根据名字查找用户
     * @param name
     * @return
     */
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     * 查找所有用户
     * @return
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入两个用户
     */
    public void insertService() {
        userDao.insertUser("Marshal", 22, 3000.0);
        userDao.insertUser("Chiao", 19, 3000.0);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了@Transactional注解，如果转账中途出现意外，两人的钱都不会改变
     */
    @Transactional
    public void changeMoney() {
        userDao.updateUser("Marshal", 22, 2000.0, 1);
        //模拟转账过程中可能遇到的意外状况
        int temp = 1 / 0;
        userDao.updateUser("Chiao", 19, 4000.0, 2);
    }

}
