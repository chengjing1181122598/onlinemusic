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
import com.vicky.onlinemusic.modules.songmgr.entity.Singer;
import com.vicky.onlinemusic.modules.songmgr.service.SingerService;
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
@RequestMapping("singer")
public class SingerController extends MyEntityController<Singer, String> {

    @Autowired
    private SingerService singerService;

    @Override
    protected BaseService<Singer, String> getBaseService() {
        return this.singerService;
    }

    @RequestMapping("login")
    @ResponseBody
    public StatusMsg login(Manager manager) {
        if (manager.getUsername().equals(Manager.DEFAULT_MANAGER_USERNAME)
                && manager.getPassword().equals(Manager.DEFAULT_MANAGER_PASSWORD)) {
            super.request.getSession().setAttribute("manager", manager);
            return super.simpleBuildSuccessMsg("管理员登录成功");
        } else {
            return super.simpleBuildErrorMsg("管理员账号或者密码错误");
        }
    }

    @Override
    @RequestMapping("getPageData")
    @ResponseBody
    public Map<String, Object> getPageData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return super.getPageData(request, response); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping("getById")
    @ResponseBody
    public StatusMsg getById(HttpServletRequest request, HttpServletResponse response, String primaryKey) {
        return super.getById(request, response, primaryKey); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping("deleteById")
    @ResponseBody
    public StatusMsg deleteById(HttpServletRequest request, HttpServletResponse response, String primaryKey) throws Exception {
        Singer singer = this.singerService.selectByPrimaryKey(primaryKey);
        WebFileUtils.deleteFile(singer.getPhotoAbsolutePath());
        return super.deleteById(request, response, primaryKey); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public StatusMsg saveOrUpdate(Singer t) throws Exception {
        Manager manager = super.getManager();
        Part photo = request.getPart("photo");
        if (photo != null && photo.getSize() > 0) {
            String[] strings = WebFileUtils.savePublicFileAtLocalServer(
                    photo, Final.WEB_ROOT_PATH, Final.IMAGE_PATH, manager.getUsername());
            t.setPhotoAbsolutePath(strings[0]);
            t.setPhotoRelativePath(Final.HOST_ADDRESS + strings[1]);
        }
        t.setCreateTime(new Date());
        if (t.getSingerId() != null) {
            this.singerService.updateSelective(t);
        } else {
            this.singerService.save(t);
        }
        return super.simpleBuildSuccessMsg("保存艺人成功!", t);
    }

}
