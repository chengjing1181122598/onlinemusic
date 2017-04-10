/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.service;

import com.vicky.common.utils.service.MybatisBaseService;
import com.vicky.onlinemusic.modules.songmgr.entity.Song;
import com.vicky.onlinemusic.modules.songmgr.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
@Service
public class SongService extends MybatisBaseService<Song, String> {

    @Autowired
    private SongMapper songMapper;

    @Override
    protected Mapper<Song> getMapper() {
        return this.songMapper;
    }

    public int increment(Song song) {
        return this.songMapper.increment(song);
    }

}
