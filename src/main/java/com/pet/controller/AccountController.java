package com.pet.controller;

import com.pet.bean.Account;
import com.pet.dao.AccountMapper;
import com.pet.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/8/21.
 * 用户相关操作
 */
@Controller
@RequestMapping("")
public class AccountController extends AbsController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login(@RequestParam Map param) {
        try {
            return "login";
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return "RuntimeException";
        } catch (Exception e) {
            log.error(e.getMessage());
            return "Exception";
        }
    }

    /**
     * 添加新用户
     * */
    @PostMapping("add/account")
    @ResponseBody
    public Object addAccount(@RequestParam Map param) {
        try {
            accountService.addAccount(param);
            return ajax();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ajax(e);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ajax(e);
        }
    }

    /**
     * 通过id查询用户
     * */
    @GetMapping("select/account")
    @ResponseBody
    public Object selectAccountById(@RequestParam Map param) {
        try {
            Account account = accountService.getAccountById(param);
            return ajax(account);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ajax(e);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ajax(e);
        }
    }
}
