package com.pet.dao;

import com.pet.bean.Account;

import java.util.List;
import java.util.Map;

/**
 */
public interface CustAccountMapper {

    List<Map> selectAccountItem(int accountId);

    List<Account> selectMyContacts(int accountId);
}
