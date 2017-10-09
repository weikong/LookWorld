package com.pet.service;

import com.pet.bean.Account;
import com.pet.dao.AccountMapper;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Account addAccount(Map param){
        String name = MapUtils.getString(param,"name");
        String type = MapUtils.getString(param,"type");
        String typeName = MapUtils.getString(param,"typeName");
        String header = MapUtils.getString(param,"header");
        String sex = MapUtils.getString(param,"sex");
        float age = MapUtils.getFloat(param,"age");
        String partner = MapUtils.getString(param,"partner");
        String partnerheader = MapUtils.getString(param,"partnerheader");
        String relationship = MapUtils.getString(param,"relationship");
        String desc = MapUtils.getString(param,"desc");
        Account account = new Account();
        account.setName(name);
        account.setType(type);
        account.setTypename(typeName);
        account.setHeader(header);
        account.setSex(sex);
        account.setAge(age);
        account.setPartner(partner);
        account.setPartnerheader(partnerheader);
        account.setRelationship(relationship);
        account.setDesc(desc);
        int insert = accountMapper.insertSelective(account);
        if (insert != 1)
            throw new RuntimeException("Account insert error");
        return account;
    }

    public Account getAccountById(Map param){
        int id = MapUtils.getInteger(param,"id",-1);
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }
}
