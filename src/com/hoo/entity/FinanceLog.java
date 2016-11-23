package com.hoo.entity;

import com.hoo.utils.CurrencyConstants;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务日志
 * Created by palagend@163.com on 2016/11/25.
 */
public class FinanceLog {
    private int id;
    private Date dateTime = new Date();
    private int from;
    private int to;
    private int type=FinanceLogType.CONSUMPTION;//财务日志类型
    private BigDecimal amount;
    private int currency= CurrencyConstants.CNY;
    private String description;
    private int user_id;

    public int getFromAccount() {
        return from;
    }

    public void setFromAccount(int from) {
        this.from = from;
    }

    public int getToAccount() {
        return to;
    }

    public void setToAccount(int to) {
        this.to = to;
    }
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getAmount(){
        return amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * 财务日志类型:消费,投资,工资,餐饮等
     */
    public static final class FinanceLogType {
        public static final int CONSUMPTION = 1;
        public static final int INVESTMENT = 2;
        public static final int SALARY = 3;
        public static final int MEAL = 4;
        public static final int TRANSFER = 5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}

