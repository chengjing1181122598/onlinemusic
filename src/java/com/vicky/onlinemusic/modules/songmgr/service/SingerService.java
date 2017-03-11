/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.service;

import com.vicky.common.utils.service.MybatisBaseService;
import com.vicky.onlinemusic.modules.songmgr.entity.Singer;
import com.vicky.onlinemusic.modules.songmgr.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
@Service
public class SingerService extends MybatisBaseService<Singer, String> {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    protected Mapper<Singer> getMapper() {
        return this.singerMapper;
    }

}
