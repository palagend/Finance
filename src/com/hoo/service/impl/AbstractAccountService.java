package com.hoo.service.impl;

import com.hoo.service.AccountService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pal on 16-11-25.
 */
public abstract class AbstractAccountService implements AccountService {


    @Override
    public boolean transfer(int from, int to, BigDecimal value, Date dateTime, int type) {
        return transfer(from, to, value, dateTime, null, type);
    }

    @Override
    public boolean transfer(int from, int to, BigDecimal value, int type) {
        return transfer(from, to, value, new Date(), type);
    }

    @Override
    public boolean transfer(int from, int to, int value, int type) {
        return transfer(from, to, new BigDecimal(value), type);
    }


    @Override
    public boolean income(int accountId, String description, BigDecimal value, Date dateTime, int magicAccount, int type) {
        return borrow(accountId, description, value, dateTime, magicAccount, type);
    }

    @Override
    public boolean borrow(int accountId, String from, BigDecimal value, int magicAccount, int type) {
        return borrow(accountId, from, value, new Date(), magicAccount, type);
    }

    @Override
    public boolean income(int accountId, String description, BigDecimal value, int magicAccount, int type) {
        return income(accountId, description, value, new Date(), magicAccount, type);
    }

    @Override
    public boolean borrow(int accountId, String from, int value, int magicAccount, int type) {
        return borrow(accountId, from, new BigDecimal(value), magicAccount, type);
    }

    @Override
    public boolean income(int accountId, String description, int value, int magicAccount, int type) {
        return income(accountId, description, new BigDecimal(value), magicAccount, type);
    }

    @Override
    public boolean borrow(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type) {
        return transfer(peerAccountId, accountId, value, dateTime, type);
    }

    @Override
    public boolean income(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type) {
        return borrow(accountId, peerAccountId, value, dateTime, type);
    }

    @Override
    public boolean borrow(int accountId, int peerAccountId, BigDecimal value, int type) {
        return borrow(accountId, peerAccountId, value, new Date(), type);
    }

    @Override
    public boolean income(int accountId, int peerAccountId, BigDecimal value, int type) {
        return income(accountId, peerAccountId, value, new Date(), type);
    }

    @Override
    public boolean borrow(int accountId, int peerAccountId, int value, int type) {
        return borrow(accountId, peerAccountId, new BigDecimal(value), type);
    }

    @Override
    public boolean income(int accountId, int peerAccountId, int value, int type) {
        return income(accountId, peerAccountId, new BigDecimal(value), type);
    }




    @Override
    public boolean expense(int accountId, String description, BigDecimal value, Date dateTime, int magicAccount, int type) {
        return lend(accountId, description, value, dateTime, magicAccount, type);
    }

    @Override
    public boolean lend(int accountId, String to, BigDecimal value, int magicAccount, int type) {
        return lend(accountId, to, value, new Date(), magicAccount, type);
    }

    @Override
    public boolean expense(int accountId, String description, BigDecimal value, int magicAccount, int type) {
        return expense(accountId, description, value, new Date(), magicAccount, type);
    }

    @Override
    public boolean lend(int accountId, String to, int value, int magicAccount, int type) {
        return lend(accountId, to, new BigDecimal(value), magicAccount, type);
    }

    @Override
    public boolean expense(int accountId, String description, int value, int magicAccount, int type) {
        return expense(accountId, description, new BigDecimal(value), magicAccount, type);
    }

    @Override
    public boolean lend(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type) {
        return transfer(accountId, peerAccountId, value, dateTime, type);
    }

    @Override
    public boolean expense(int accountId, int peerAccountId, BigDecimal value, Date dateTime, int type) {
        return lend(accountId, peerAccountId, value, dateTime, type);
    }

    @Override
    public boolean lend(int accountId, int peerAccountId, BigDecimal value, int type) {
        return lend(accountId, peerAccountId, value, new Date(), type);
    }

    @Override
    public boolean expense(int accountId, int peerAccountId, BigDecimal value, int type) {
        return expense(accountId, peerAccountId, value, new Date(), type);
    }

    @Override
    public boolean lend(int accountId, int peerAccountId, int value, int type) {
        return lend(accountId, peerAccountId, new BigDecimal(value), type);
    }

    @Override
    public boolean expense(int accountId, int peerAccountId, int value, int type) {
        return expense(accountId, peerAccountId, new BigDecimal(value), type);
    }

    public boolean borrow(int accountId, String from, BigDecimal value, Date dateTime, int magicAccount, int type) {
        return transfer(magicAccount, accountId, value, dateTime, from, type);
    }

    public boolean lend(int accountId, String to, BigDecimal value, Date dateTime, int magicAccount, int type) {
        return transfer(accountId, magicAccount, value, dateTime, to, type);
    }

}
