/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.controller;

import com.vicky.common.controller.MyEntityController;
import com.vicky.common.finalpackage.Final;
import com.vicky.common.utils.DealFile.WebFileUtils;
import com.vicky.common.utils.service.BaseService;
import com.vicky.common.utils.statusmsg.StatusMsg;
import com.vicky.onlinemusic.modules.songmgr.entity.Song;
import com.vicky.onlinemusic.modules.songmgr.service.SongService;
import com.vicky.onlinemusic.modules.songmgr.utils.Manager;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vicky
 */
@Controller
@RequestMapping("song")
public class SongController extends MyEntityController<Song, String> {

    @Autowired
    private SongService songService;

    @Override
    protected BaseService<Song, String> getBaseService() {
        return this.songService;
    }

    @Override
    @RequestMapping("getPageData")
    @ResponseBody
    public Map<String, Object> getPageData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.getPageData(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public StatusMsg saveOrUpdate(Song t) throws Exception {
        Manager manager = super.getManager();
        Part audio = request.getPart("audio");
        if (audio != null && audio.getSize() > 0) {
            String[] strings = WebFileUtils.savePublicFileAtLocalServer(
                    audio, Final.WEB_ROOT_PATH, Final.AUDIO_PATH, manager.getUsername());
            t.setAudioAbsolutePath(strings[0]);
            t.setAudioRelativePath(Final.HOST_ADDRESS + strings[1]);
        }
        t.setCreateTime(new Date());
        if (t.getSongId() != null) {
            this.songService.updateSelective(t);
        } else {
            this.songService.save(t);
        }
        return super.simpleBuildSuccessMsg("保存歌曲成功!", t);
    }

    @Override
    @RequestMapping("deleteById")
    @ResponseBody
    public StatusMsg deleteById(HttpServletRequest request, HttpServletResponse response, String primaryKey) throws Exception {
        Song song = this.songService.selectByPrimaryKey(primaryKey);
        WebFileUtils.deleteFile(song.getAudioAbsolutePath());
        return super.deleteById(request, response, primaryKey); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping("getById")
    @ResponseBody
    public StatusMsg getById(HttpServletRequest request, HttpServletResponse response, String primaryKey) {
        return super.getById(request, response, primaryKey); //To change body of generated methods, choose Tools | Templates.
    }

}
