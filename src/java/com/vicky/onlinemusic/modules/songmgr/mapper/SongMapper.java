/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.mapper;

import com.vicky.onlinemusic.modules.songmgr.entity.Song;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Vicky
 */
public interface SongMapper extends Mapper<Song> {

    @Update("update song set play_count = #{playCount} , version = version + 1 where song_id = #{songId} and version = #{version}")
    public int increment(Song song);
}
