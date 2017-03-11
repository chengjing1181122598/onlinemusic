/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.collectmgr.service;

import com.vicky.common.utils.service.MybatisBaseService;
import com.vicky.onlinemusic.modules.collectmgr.entity.CollectAlbum;
import com.vicky.onlinemusic.modules.collectmgr.mapper.CollectAlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
@Service
public class CollectAlbumService extends MybatisBaseService<CollectAlbum, String> {

    @Autowired
    private CollectAlbumMapper mapper;

    @Override
    protected Mapper<CollectAlbum> getMapper() {
        return this.mapper;
    }

}
