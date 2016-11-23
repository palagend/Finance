package com.hoo.control;

import com.hoo.entity.Account;
import com.hoo.entity.User;
import com.hoo.service.AccountService;
import com.hoo.utils.Page;
import com.hoo.utils.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-26.
 */
@Controller
public class AccountControl {


    @Autowired
    private AccountService accountService;

    @RequestMapping("/to-openAccount")
    public String toOpenAccount() {
        return UrlHelper.OPEN_ACCOUNT;
    }

    @RequestMapping(value = "/openAccount", method = RequestMethod.POST)
    public String openAccount(String code, String name, int userId, int currency, int type, BigDecimal value) {
        accountService.openAccount(code, name, userId, type, value, currency);
        return "redirect:/mainMenu";
    }


    @RequestMapping("/accounts")
    public String getMyAccounts(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Page page = new Page();
        List<Account> accounts = accountService.queryMyAccounts(page, user.getId());
        request.setAttribute("pageInfo", page);
        request.setAttribute("accounts", accounts);
        return UrlHelper.MY_ACCOUNTS;
    }

    @RequestMapping(value = "/viewAccount")
    public String viewAccounts(@RequestParam int id, HttpServletRequest request) {
        Account account = accountService.getById(id);
        request.setAttribute("account", account);
        return UrlHelper.VIEW_ACCOUNT;
    }

    @RequestMapping("getUpdateAccount")
    public String toUpdateAccount(HttpServletRequest request, int id) {
        Account account = accountService.getById(id);
        request.setAttribute("account", account);
        return UrlHelper.GET_UPDATE_ACCOUNT;
    }

    @RequestMapping("updateAccount")
    public String updateAccount(int id, String code, String name) {
        Account account = accountService.getById(id);
        account.setCode(code);
        account.setName(name);
        System.out.println("palagend:" + account);
        accountService.update(account);
        return "redirect:/accounts";
    }

    @RequestMapping("delAccount")
    public String delAccount(int id) {
        accountService.delAccount(id);
        return "redirect:/accounts";
    }

    @RequestMapping(value = "/accounts/{pageNo}")
    public String index(HttpServletRequest request, @PathVariable Integer pageNo) {
        Page page = new Page();
        page.setCurrentPage(pageNo);
        User user = (User) request.getSession().getAttribute("user");
        List<Account> accounts = accountService.queryMyAccounts(page, user.getId());
        request.setAttribute("pageInfo", page);
        request.setAttribute("accounts", accounts);
        return UrlHelper.MY_ACCOUNTS;
    }

    @RequestMapping("/to-write")
    public String toWrite(HttpServletRequest requset) {
        int userId = ((User) requset.getSession().getAttribute("user")).getId();
        requset.setAttribute("accounts", accountService.getMyAccounts(userId));
        return UrlHelper.WRITE;
    }

    @RequestMapping(value = "/write",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String write(HttpServletRequest request, HttpServletResponse response, int from, int to, BigDecimal value, int type, String description) {
        switch (type) {
            case 1: {
                accountService.income(to, description, value, from, type);
                return "收入" + value.toPlainString() + "元";
            }
            case 2: {
                accountService.expense(from, description, value, to, type);
                return "支出" + value.toPlainString() + "元";
            }
            case 3: {
                accountService.transfer(from, to, value, new Date(), description, type);
                return from + "->" + to + ":" + value.toPlainString() + "元";
            }
        }
        return "操作失败";
    }
}
