package com.pet.util;

import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/10/9.
 */
public class PageUtil {
    public static void startPage(Map params) {
        Integer pageNum = MapUtils.getInteger(params, "pageNum", 0);
        Integer pageSize = MapUtils.getInteger(params, "pageSize", Const.DEFAULT_PAGE_SIZE);
        Boolean count = MapUtils.getBoolean(params, "count", true);
        PageHelper.startPage(pageNum, pageSize, count);
    }
}
