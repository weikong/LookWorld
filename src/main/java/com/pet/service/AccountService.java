package com.pet.service;

import com.pet.bean.Account;
import com.pet.bean.AccountExample;
import com.pet.bean.Auth;
import com.pet.dao.AccountMapper;
import com.pet.dao.AuthMapper;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/8/21.
 */

@Service
@Transactional
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AuthMapper authMapper;

    public Account addAccount(Map param){
        String accountName = MapUtils.getString(param,"account");
        String name = MapUtils.getString(param,"name");
        String type = MapUtils.getString(param,"type");
        String header = MapUtils.getString(param,"header");
        String sex = MapUtils.getString(param,"sex");
        float age = MapUtils.getFloat(param,"age");
        String desc = MapUtils.getString(param,"desc");
        Account account = new Account();
        if (StringUtils.isEmpty(accountName))
            throw new RuntimeException("emial/phone is null");
        account.setAccount(accountName);
        account.setName(name);
        account.setType(type);
        account.setHeader(header);
        account.setSex(sex);
        account.setAge(age);
        account.setDesc(desc);
        int insert = accountMapper.insertSelective(account);
        if (insert != 1)
            throw new RuntimeException("Account insert error");
        Auth auth = new Auth();
        auth.setAccount(accountName);
        auth.setPassword("123123");
        auth.setAccountId(account.getId());
        int insert2 = authMapper.insertSelective(auth);
        if (insert2 != 1)
            throw new RuntimeException("Auth insert error");
        return account;
    }

    public Account getAccountById(Map param){
        int id = MapUtils.getInteger(param,"id",-1);
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    public Account getAccountByAccountName(Map param){
        String accountName = MapUtils.getString(param,"account");
        AccountExample example = new AccountExample();
        example.createCriteria().andAccountEqualTo(accountName);
        List<Account> list = accountMapper.selectByExample(example);
        if (list != null && list.size() == 1){
            return list.get(0);
        }
        return null;
    }
}
