/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * AdminMapper.java
 */

package com.hoo.mapper;

import com.hoo.entity.Admin;
import com.hoo.utils.Page;

import java.util.List;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 下午2:15:05 
 */
public interface AdminMapper extends SqlMapper{

    /**
     * 添加用户
     * @param admin
     * @Adder by Administrator 2013-1-31 下午2:16:23
     */
    public void saveAdmin(Admin admin);
    
    /**
     * 根据id查找用户
     * @param id
     * @return
     * @Adder by Administrator 2013-1-31 下午2:17:23
     */
    public Admin getAdminById(int id);
    
    /**
     * 查询所有的用户
     * @return
     * @Adder by Administrator 2013-1-31 下午2:18:50
     */
    public List<Admin> getAdmins();
    
    public List<Admin> queryAllAdmin(Page page);
    
    /**
     * 更新用户
     * @param admin
     * @Adder by Administrator 2013-1-31 下午2:19:30
     */
    public void updateAdmin(Admin admin);
    
    /**
     * 根据id删除用户
     * @param i
     * @Adder by Administrator 2013-1-31 下午2:20:15
     */
    public void deleteAdmin(int i);
    
    /**
     * 根据用户名查找用户
     * @param name
     * @return Admin
     * @Adder by Administrator 2013-2-1 下午4:53:20
     */
    Admin getAdminByName(String name);
}
