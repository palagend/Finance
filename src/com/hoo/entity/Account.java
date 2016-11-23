package com.hoo.entity;

import com.hoo.utils.CurrencyConstants;

import java.math.BigDecimal;

/**
 * 借贷记账法中"账户",是会计学的核心概念
 * Created by palagend@163.com on 2016/11/25.
 */
public class Account {
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private int id;
    private int userId;
    private int type;
    private int currency = CurrencyConstants.CNY;//币种
    private String code;
    private String name;
    private BigDecimal value;

    public void borrow(BigDecimal value) {
        this.value = this.value.add(value);
    }

    public void lend(BigDecimal value) {
        this.value = this.value.subtract(value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setValue(int value) {
        setValue(new BigDecimal(value));
    }


    public static  final class AccountTypeConstants {

        public static final int MAGIC_ACCOUNT = 0;
        public static final int BANK_ACCOUNT = 1;
        public static final int INVESTMENT_ACCOUNT = 2;
        public static final int PERSON_ACCOUNT = 3;

    }
}
