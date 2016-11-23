/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * adminMapperTest.java
 */

package com.hoo.test;

import com.hoo.entity.Admin;
import com.hoo.mapper.AdminMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import java.util.List;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 上午10:44:38 
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("classpath:applicationContext-*.xml")
public class AdminMapperTest extends AbstractJUnit38SpringContextTests{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AdminMapper adminMapper;
    
    @Test
    public void testSaveAdmin(){}
    
    @Test
    public void testGetAdminById(){}
    
    @Test
    public void testGetAdmins(){}
    
    @Test
    public void testUpdateAdmin(){}
   
    @Test
    public void testDeleteAdmin(){}
    
    @Test
    public void testGetAminByName(){
        Admin admin= adminMapper.getAdminByName("huanghaibin");
        System.out.println(admin.getId()+":"+admin.getName());
    }
    
    @Test
    public void testGetAllAdmins(){
        List<Admin> admins= adminMapper.getAdmins();
        for(Admin admin : admins){
            System.out.println(admin.getName()+"\n");
        }
    }
    
}
