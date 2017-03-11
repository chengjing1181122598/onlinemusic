/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.collectmgr.service;

import com.vicky.common.utils.service.MybatisBaseService;
import com.vicky.onlinemusic.modules.collectmgr.entity.CollectSinger;
import com.vicky.onlinemusic.modules.collectmgr.mapper.CollectSingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
@Service
public class CollectSingerService extends MybatisBaseService<CollectSinger, String> {

    @Autowired
    private CollectSingerMapper mapper;

    @Override
    protected Mapper<CollectSinger> getMapper() {
        return this.mapper;
    }

}
