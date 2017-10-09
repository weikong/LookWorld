package com.pet.service;

import com.pet.bean.Account;
import com.pet.bean.Contacts;
import com.pet.bean.ContactsExample;
import com.pet.dao.AccountMapper;
import com.pet.dao.ContactsMapper;
import com.pet.dao.CustAccountMapper;
import org.apache.commons.collections4.MapUtils;
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
public class ContactsService {
    private static final Logger log = LoggerFactory.getLogger(ContactsService.class);
    @Autowired
    private ContactsMapper contactsMapper;
    @Autowired
    private CustAccountMapper custAccountMapper;

    public List<Account> getMyContacts(Map param) {
        int id = MapUtils.getInteger(param, "id", -1);
        List<Account> list = custAccountMapper.selectMyContacts(id);
        return list;
    }

    public void addContact(Map param) {
        int my_id = MapUtils.getInteger(param, "my_id", -1);
        int friend_id = MapUtils.getInteger(param, "friend_id", -1);
        if (my_id <= 0 || friend_id <= 0) {
            throw new RuntimeException("参数异常，数据不正确");
        }
        ContactsExample example1 = new ContactsExample();
        example1.createCriteria().andUserAIdEqualTo(my_id).andUserBIdEqualTo(friend_id);
        List<Contacts> list1 = contactsMapper.selectByExample(example1);
        ContactsExample example2 = new ContactsExample();
        example2.createCriteria().andUserAIdEqualTo(friend_id).andUserBIdEqualTo(my_id);
        List<Contacts> list2 = contactsMapper.selectByExample(example2);
        if ((list1 != null && !list1.isEmpty()) || (list2 != null && !list2.isEmpty())) {
            delContacts(list1);
            delContacts(list2);
        }
        insertContacts(my_id, friend_id);
    }

    private void delContacts(List<Contacts> list) {
        if (list != null) {
            for (Contacts contacts : list) {
                int del = contactsMapper.deleteByPrimaryKey(contacts.getId());
                if (del != 1)
                    throw new RuntimeException("Contacts del error");
            }
        }
    }

    private void insertContacts(int my_id, int friend_id) {
        Contacts contacts1 = new Contacts();
        contacts1.setUserAId(my_id);
        contacts1.setUserBId(friend_id);
        int insert1 = contactsMapper.insert(contacts1);
        if (insert1 != 1)
            throw new RuntimeException("Contacts insert error");
        Contacts contacts2 = new Contacts();
        contacts2.setUserAId(friend_id);
        contacts2.setUserBId(my_id);
        int insert2 = contactsMapper.insert(contacts2);
        if (insert2 != 1)
            throw new RuntimeException("Contacts insert error");
    }
}
