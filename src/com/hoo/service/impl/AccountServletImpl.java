package com.hoo.service.impl;

import com.hoo.entity.Account;
import com.hoo.entity.FinanceLog;
import com.hoo.mapper.AccountMapper;
import com.hoo.mapper.FinanceLogMapper;
import com.hoo.utils.CurrencyConstants;
import com.hoo.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by pal on 16-11-25.
 */
@Service
public class AccountServletImpl extends AbstractAccountService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    AccountMapper accountMapper;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private FinanceLogMapper logMapper;
//    @Autowired
//    private DataSourceTransactionManager txManager;

    @Override
    public List<Account> getMyAccounts(int userId) {
        return accountMapper.queryByUserId(userId);
    }

    @Override
    @Transactional
    public boolean openAccount(String code, String name, int userId, int type, BigDecimal value, int currency) {
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        TransactionStatus status = txManager.getTransaction(def);

        Account acc = new Account();
        acc.setCode(code);
        acc.setName(name);
        acc.setUserId(userId);
        acc.setType(type);
        acc.setValue(value);
        acc.setCurrency(currency);
        accountMapper.save(acc);
//        txManager.commit(status);

        return true;
    }

    @Override
    public boolean openMagicAccount(int userId) {
        openAccount("000000000000000000", "魔幻账号", userId, Account.AccountTypeConstants.MAGIC_ACCOUNT, new BigDecimal(0), CurrencyConstants.CNY);
        return true;
    }

    @Override
    public List<Account> queryAllAccounts(Page page) {
        return accountMapper.queryAllAccounts(page);
    }

    @Override
    public List<Account> queryMyAccounts(Page page, int userId) {
        return accountMapper.queryMyAccounts(page,userId);
    }

    @Override
    public Account getById(int id) {
        return accountMapper.getById(id);
    }

    @Override
    public boolean update(Account account) {
        accountMapper.update(account);
        return true;
    }

    @Override
    public boolean delAccount(int id) {
        accountMapper.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public boolean transfer(int from, int to, BigDecimal value, Date dateTime, String description, int type) {

        Account whiteHole = accountMapper.getById(from);
        Account blackHole = accountMapper.getById(to);
        whiteHole.lend(value);
        blackHole.borrow(value);

        FinanceLog log = new FinanceLog();
        log.setType(type);
        log.setDateTime(dateTime);
        log.setFromAccount(from);
        log.setToAccount(to);
        log.setDescription(description);
        log.setAmount(value);
        log.setCurrency(CurrencyConstants.CNY);

        accountMapper.update(whiteHole);
        accountMapper.update(blackHole);
        logMapper.save(log);


        return true;
    }
}

