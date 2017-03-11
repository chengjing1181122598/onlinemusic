/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.service;

import com.vicky.common.utils.service.MybatisBaseService;
import com.vicky.onlinemusic.modules.songmgr.entity.Album;
import com.vicky.onlinemusic.modules.songmgr.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
@Service
public class AlbumService extends MybatisBaseService<Album, String> {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    protected Mapper<Album> getMapper() {
        return this.albumMapper;
    }

}
