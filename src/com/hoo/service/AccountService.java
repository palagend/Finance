package com.hoo.service;

import com.hoo.entity.Account;
import com.hoo.utils.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-25.
 */
public interface AccountService {

    List<Account> getMyAccounts(int userId);

    boolean openAccount(String code, String name, int userId, int type, BigDecimal value, int currency);

    boolean transfer(int from, int to, BigDecimal value, Date dateTime, String description, int type);

    boolean transfer(int from, int to, BigDecimal value, Date dateTime, int type);

    boolean transfer(int from, int to, BigDecimal value, int type);

    boolean transfer(int from, int to, int value, int type);


    boolean lend(int accountId, String to, BigDecimal value, Date dateTime, int magicAccount, int type);

    boolean expense(int accountId, String to, BigDecimal value, Date dateTime, int magicAccount, int type);

    boolean lend(int accountId, String to, BigDecimal value, int magicAccount, int type);

    boolean expense(int accountId, String to, BigDecimal value, int magicAccount, int type);

    boolean lend(int accountId, String to, int value, int magicAccount, int type);

    boolean expense(int accountId, String to, int value, int magicAccount, int type);


    boolean lend(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type);

    boolean expense(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type);

    boolean lend(int accountId, int peerAccountId, BigDecimal value, int type);

    boolean expense(int accountId, int peerAccountId, BigDecimal value, int type);

    boolean lend(int accountId, int peerAccountId, int value, int type);

    boolean expense(int accountId, int peerAccountId, int value, int type);


    boolean borrow(int accountId, String from, BigDecimal value, Date dateTime, int magicAccount, int type);

    boolean income(int accountId, String from, BigDecimal value, Date dateTime, int magicAccount, int type);

    boolean borrow(int accountId, String from, BigDecimal value, int magicAccount, int type);

    boolean income(int accountId, String from, BigDecimal value, int magicAccount, int type);

    boolean borrow(int accountId, String from, int value, int magicAccount, int type);

    boolean income(int accountId, String from, int value, int magicAccount, int type);

    boolean borrow(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type);

    boolean income(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type);

    boolean borrow(int accountId, int peerAccountId, BigDecimal value, int type);

    boolean income(int accountId, int peerAccountId, BigDecimal value, int type);

    boolean borrow(int accountId, int peerAccountId, int value, int type);

    boolean income(int accountId, int peerAccountId, int value, int type);

    boolean openMagicAccount(int userId);

    /**
     * 查询所有的账户信息，用分页显示
     *
     * @return
     * @Adder by Administrator 2013-2-19 上午11:49:22
     */
    List<Account> queryAllAccounts(Page page);

    /**
     * 查询userId的所有账户信息，用分页显示
     *
     * @param page
     * @param userId
     * @return
     */
    List<Account> queryMyAccounts(Page page,int userId);

    Account getById(int id);

    boolean update(Account account);

    boolean delAccount(int id);
}
