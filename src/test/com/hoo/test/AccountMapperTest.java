package com.hoo.test;

import com.hoo.entity.Account;
import com.hoo.entity.FinanceLog;
import com.hoo.mapper.AccountMapper;
import com.hoo.service.AccountService;
import com.hoo.utils.CurrencyConstants;
import com.hoo.utils.Page;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * Created by pal on 16-11-26.
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
//ContextConfiguration的locations不能使用通配符的路径,否则不生效,原因不明
@ContextConfiguration(locations = {"classpath:applicationContext-common.xml", "classpath:applicationContext-view.xml", "classpath:dispatcher.xml"})
@TransactionConfiguration
public class AccountMapperTest {
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AccountMapper accountMapper;
    private static Account account;
    @Autowired
    private AccountService accountService;

    @BeforeClass
    public static void init() {
        Account acc = new Account();
        acc.setCode("00000000000000000");
        acc.setCurrency(CurrencyConstants.CNY);
        acc.setName("Magic Account");
        acc.setType(Account.AccountTypeConstants.MAGIC_ACCOUNT);
        acc.setValue(0);
        account = acc;
    }

    @Test
    @Transactional
    public void testDeclarativeTransaction() {
        for (int i = 1; i <= 10; i++) {
            account.setUserId(i);
//            account.setId(i + 1);
            accountMapper.save(account);
        }
    }

    @Test
    public void testProgrammaticTransaction() throws Exception {


        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        for (int i = 1; i <= 10; i++) {
            account.setType(Account.AccountTypeConstants.BANK_ACCOUNT);
            account.setCode("621700240810384" + (i - 1));
            account.setValue(100);
            account.setCurrency(CurrencyConstants.CNY);
            account.setName("银行卡");
//            account.setId(i);
            accountMapper.save(account);
        }
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            throw e;
        }
        transactionManager.commit(status);
    }

    @Test
    @Transactional
    public void testTransfer() {
        accountService.transfer(10, 21, 99, FinanceLog.FinanceLogType.TRANSFER);
    }

    @Test
    public void testGetMyAccounts() {
        Page page=new Page();
        page.setPageSize(5);
        page.setCurrentPage(2);
        List<Account> accounts = accountMapper.queryMyAccounts(page,10);
        for (Account u : accounts) {
            System.out.println(u.getId()+":"+u.getName());
        }

    }
}