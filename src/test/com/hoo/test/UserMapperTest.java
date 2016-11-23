/**
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * <p>
 * userMapperTest.java
 */

package com.hoo.test;

import java.util.List;

import com.hoo.utils.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.hoo.entity.User;
import com.hoo.mapper.UserMapper;

/**
 *
 * @author Administrator
 * @date 2013-1-31 上午10:44:38 
 */
@SuppressWarnings("deprecation")
@ContextConfiguration({"classpath:applicationContext-common.xml","classpath:applicationContext-view.xml","classpath:dispatcher.xml",})
public class UserMapperTest extends AbstractJUnit38SpringContextTests {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("huanghai");
        user.setPassword("041086");
        userMapper.saveUser(user);
        System.out.println("添加用户成功！");
    }

    @Test
    public void testGetUserById() {
        User user = userMapper.getUserById(2);
        System.out.println(user.getName());
    }

    @Test
    public void testGetUsers() {
        List<User> users = userMapper.getUsers();
        for (User u : users) {
            System.out.println(u.getId() + ":" + u.getName() + ":" + u.getPassword());
        }
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(3);
        user.setName("huanghaibin");
        userMapper.updateUser(user);
        System.out.println("修改用户成功！");
    }

    @Test
    public void testDeleteUser() {
        userMapper.deleteUser(2);
        System.out.println("删除成功！");
    }

    @Test
    public void testGetUserByName() {
        User user = userMapper.getUserByName("huanghaibin");
        System.out.println(user.getId() + ":" + user.getName());
    }

    @Test
    public void testGetAllUsers() {
        Page page=new Page();
        page.setPageSize(10);
        page.setCurrentPage(2);
        List<User> users = userMapper.queryAllUser(page);
        for (User u : users) {
            System.out.println(u.getId()+":"+u.getName());
        }
    }
}
