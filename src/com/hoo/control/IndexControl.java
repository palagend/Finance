/**
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * <p>
 * IndexControl.java
 */

package com.hoo.control;

import com.alibaba.fastjson.JSONObject;
import com.hoo.entity.Admin;
import com.hoo.entity.User;
import com.hoo.service.AccountService;
import com.hoo.service.AdminService;
import com.hoo.service.UserService;
import com.hoo.utils.Page;
import com.hoo.utils.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 * @date 2013-2-1 下午4:38:40 
 */
@Controller
public class IndexControl {

    @Autowired
    protected UserService userService;
    @Autowired
    protected AdminService adminService;
    @Autowired
    private AccountService accountService;

    /**
     * 所有默认的请求处理
     * @return
     * @Adder by Administrator 2013-2-5 上午10:06:38
     */
    @RequestMapping(value = "/*")
    public String index() {
        return UrlHelper.USER_LOGIN;
    }

    /**
     * 管理员登陆
     * @return
     */
    @RequestMapping(value = "admin_login")
    public String admin_login() {
        return UrlHelper.ADMIN_LOGIN;
    }

    /**
     * 跳转到注册页面
     * @return
     * @Adder by Administrator 2013-2-5 下午1:51:42
     */
    @RequestMapping(value = "user_register")
    public String userRegister() {
        return UrlHelper.USER_REGISTER;
    }

    @RequestMapping(value = "admin_register")
    public String adminRegister() {
        return UrlHelper.ADMIN_REGISTER;
    }

    /**
     * 用户注册
     * @param name
     * @param password
     * @return
     * @Adder by Administrator 2013-2-5 上午11:59:30
     */
    @RequestMapping(value = "register")
    public String userRegister(@RequestParam String name, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        if (userService.register(user)) {
            accountService.openMagicAccount(user.getId());
            return "redirect:/";
        }
        return UrlHelper.USER_REGISTER;
    }

    @RequestMapping(value = "aregister")
    public String adminRegister(@RequestParam String name, @RequestParam String password) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        if (adminService.register(admin)) {
            return "redirect:/admin_login";
        }
        return UrlHelper.ADMIN_REGISTER;
    }

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     * @Adder by Administrator 2013-2-5 下午12:02:19
     */
    @RequestMapping(value = "login")
    public String userLogin(@RequestParam String name, @RequestParam String password, HttpSession session) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        if (userService.login(user)) {
            session.setAttribute("user", userService.getUserByName(name));
            return "redirect:/mainMenu";
        }
        return UrlHelper.USER_LOGIN;
    }
    @RequestMapping(value="mainMenu")
    public String  showMainMenu(){
        return UrlHelper.MAIN_MENU;
    }

    @RequestMapping(value = "alogin")
    public String adminLogin(@RequestParam String name, @RequestParam String password, HttpSession session) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(password);
        if (adminService.login(admin)) {
            session.setAttribute("admin", admin);
            return "redirect:/userList";
        }
        return UrlHelper.ADMIN_LOGIN;
    }


    /**
     * 用户分页列表
     * @param model
     * @return
     * @Adder by Administrator 2013-2-20 上午9:32:20
     */
    @RequestMapping(value = "userList")
    public String UserList(Model model) {
        Page page = new Page();
        page = userService.queryAllUser(page);
        page.setToUrl("/");
        model.addAttribute("pageInfo", page);
        model.addAttribute("users", page.getResult());
        return UrlHelper.USER_LIST;
    }

    @RequestMapping(value = "/{pageNo}")
    public String index(Model model, @PathVariable Integer pageNo) {
        Page page = new Page();
        page.setCurrentPage(pageNo);
        page = userService.queryAllUser(page);
        page.setToUrl("/");
        model.addAttribute("pageInfo", page);
        model.addAttribute("users", page.getResult());
        return UrlHelper.USER_LIST;
    }

    //json请求和处理方式
    @RequestMapping(value = "findUserByName")
    public
    @ResponseBody
    String findUsersByName(@RequestParam String name) {
        JSONObject J = new JSONObject();
        if (!userService.exists(name)) {
            J.put("boolean", true);
        } else {
            J.put("boolean", false);
        }
        return J.toString();
    }

}
