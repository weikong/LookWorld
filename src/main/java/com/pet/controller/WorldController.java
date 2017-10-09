package com.pet.controller;

import com.pet.bean.Account;
import com.pet.bean.WorldMessage;
import com.pet.dao.WorldMessageMapper;
import com.pet.service.WorldMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/10/9.
 */
@Controller
@RequestMapping("world")
public class WorldController extends AbsController {
    private static final Logger log = LoggerFactory.getLogger(WorldController.class);

    @Autowired
    private WorldMessageService worldMessageService;

    /**
     * 查询图片分享列表
     * */
    @GetMapping("/list")
    @ResponseBody
    public Object selectWorldMessage(@RequestParam Map param) {
        try {
            List<WorldMessage> list = worldMessageService.getList(param);
            return ajax(list);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ajax(e);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ajax(e);
        }
    }

    /**
     * 查询图片分享列表
     * */
    @GetMapping("/add")
    @ResponseBody
    public Object addWorldMessage(@RequestParam Map param) {
        try {
            worldMessageService.addMessage(param);
            return ajax();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ajax(e);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ajax(e);
        }
    }
}
