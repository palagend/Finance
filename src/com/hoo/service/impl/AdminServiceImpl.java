package com.hoo.service.impl;

import com.hoo.entity.Admin;
import com.hoo.mapper.AdminMapper;
import com.hoo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by palagend on 2016/11/25.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected AdminMapper adminMapper;
    @Override
    public boolean login(Admin admin) {
        Admin db_admin = adminMapper.getAdminByName(admin.getName());
        if(db_admin!=null && db_admin.getPassword().equals(admin.getPassword())) return true;
        return false;
    }

    @Override
    public boolean register(Admin admin) {
        if (adminMapper.getAdminByName(admin.getName())!=null) return false;
        try{
            adminMapper.saveAdmin(admin);
        }catch (RuntimeException re){
            return false;
        }
        return true;
    }
}
