package com.hoo.mapper;

import com.hoo.entity.Account;
import com.hoo.utils.Page;

import java.util.List;

/**
 * Created by pal on 16-11-25.
 */
public interface AccountMapper extends SqlMapper{
    void save(Account account);
    void deleteById(int id);
    void update(Account account);

    List<Account> queryAllAccounts(Page page);
    List<Account> queryByUserId(int userId);

    Account getById(int id);

    void deleteByUserId(int userId);

    List<Account> queryMyAccounts(Page page, int userId);
}
