package com.pet.service;

import com.pet.bean.WorldMessage;
import com.pet.bean.WorldMessageExample;
import com.pet.dao.WorldMessageMapper;
import com.pet.util.Const;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/10/9.
 */
@Service
@Transactional
public class WorldMessageService {
    private static final Logger log = LoggerFactory.getLogger(WorldMessageService.class);

    @Autowired
    private WorldMessageMapper worldMessageMapper;

    public List<WorldMessage> getList(Map param){
        int pageCount = MapUtils.getInteger(param,"pageNum",1);
        int pageSize = MapUtils.getInteger(param,"pageSize", Const.DEFAULT_PAGE_SIZE);
        WorldMessageExample example = new WorldMessageExample();
        example.createCriteria();
        example.setOrderByClause("time desc");
        List<WorldMessage> list = worldMessageMapper.selectByExample(example);
        return list;
    }

    public List<WorldMessage> addMessage(Map param){
        WorldMessageExample example = new WorldMessageExample();
        example.createCriteria();
        example.setOrderByClause("time desc");
        List<WorldMessage> list = worldMessageMapper.selectByExample(example);
        return list;
    }
}
