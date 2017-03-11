/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.collectmgr.controller;

import com.vicky.common.controller.MyEntityController;
import com.vicky.common.utils.service.BaseService;
import com.vicky.common.utils.statusmsg.StatusMsg;
import com.vicky.onlinemusic.modules.collectmgr.entity.CollectSong;
import com.vicky.onlinemusic.modules.collectmgr.service.CollectSongService;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vicky
 */
@Controller
@RequestMapping("collectSong")
public class CollectSongController extends MyEntityController<CollectSong, String> {

    @Autowired
    private CollectSongService service;

    @Override
    protected BaseService<CollectSong, String> getBaseService() {
        return this.service;
    }

    @RequestMapping("isCollected")
    @ResponseBody
    public StatusMsg isCollected(String songId) {
        CollectSong querySong = new CollectSong();
        querySong.setCollectUsername(super.getUser().getUsername());
        querySong.setCollectSongId(songId);
        CollectSong c = this.service.selectOne(querySong);
        if (c == null) {
            return super.simpleBuildSuccessMsg("no");
        } else {
            return super.simpleBuildSuccessMsg("yes");
        }
    }

    @Override
    @RequestMapping("getPageData")
    @ResponseBody
    public Map<String, Object> getPageData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.getPageData(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping("save")
    @ResponseBody
    public StatusMsg save(HttpServletRequest request, HttpServletResponse response, CollectSong t) throws Exception {
        t.setCollectUsername(super.getUser().getUsername());
        t.setCreateTime(new Date());
        return super.save(request, response, t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping("deleteById")
    @ResponseBody
    public StatusMsg deleteById(HttpServletRequest request, HttpServletResponse response, String primaryKey) throws Exception {
        return super.deleteById(request, response, primaryKey); //To change body of generated methods, choose Tools | Templates.
    }

}
