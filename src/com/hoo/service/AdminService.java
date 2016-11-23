package com.hoo.service;

import com.hoo.entity.Admin;

/**
 * Created by palagend on 2016/11/25.
 */
public interface AdminService {

    public boolean login(Admin admin);

    boolean register(Admin admin);
}
