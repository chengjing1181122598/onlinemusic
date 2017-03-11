/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.usermgr.controller;

import com.vicky.common.controller.MyEntityController;
import com.vicky.common.finalpackage.Final;
import com.vicky.common.utils.DealFile.WebFileUtils;
import com.vicky.common.utils.encodepwd.EncodePassword;
import com.vicky.common.utils.service.BaseService;
import com.vicky.common.utils.statusmsg.StatusMsg;
import com.vicky.onlinemusic.modules.usermgr.entity.User;
import com.vicky.onlinemusic.modules.usermgr.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
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
@RequestMapping("user")
public class UserController extends MyEntityController<User, String> {

    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User, String> getBaseService() {
        return this.userService;
    }

    @RequestMapping("updateHead")
    @ResponseBody
    public StatusMsg updateHead() throws IOException, ServletException {
        Part headImage = request.getPart("headImage");
        User user = super.getUser();
        String[] strings = WebFileUtils.savePublicFileAtLocalServer(
                headImage, Final.WEB_ROOT_PATH, Final.IMAGE_PATH, user.getUsername());
        if (!user.getAbsolutePath().equals(User.DEFAULT_HEAD_ABSOLUTE_PATH)) {
            File frontHeadImage = new File(user.getAbsolutePath());
            frontHeadImage.delete();
        }
        user.setAbsolutePath(strings[0]);
        user.setRelativePath(Final.HOST_ADDRESS + strings[1]);
        this.userService.updateSelective(user);
        return super.simpleBuildSuccessMsg("修改头像成功!", user);
    }

    @RequestMapping("logout")
    @ResponseBody
    public StatusMsg logout() {
        super.request.getSession().invalidate();
        return super.simpleBuildSuccessMsg("用户退出成功");
    }

    @RequestMapping("updatePWD")
    @ResponseBody
    public StatusMsg updatePWD(String prePWD, String curPWD) {
        User user = super.getUser();
        if (!EncodePassword.checkPassword(prePWD, user.getPassword())) {
            return super.simpleBuildErrorMsg("密码错误");
        } else {
            user.setPassword(EncodePassword.encodePassword(curPWD));
            this.userService.updateSelective(user);
            return super.simpleBuildSuccessMsg("修改密码成功!", user);
        }
    }

    @RequestMapping("getUser")
    @ResponseBody
    public StatusMsg getUserMessage() {
        return super.simpleBuildSuccessMsg(super.getUser());
    }

    @RequestMapping("login")
    @ResponseBody
    public StatusMsg login(User paramUser) {
        User user = this.userService.selectByPrimaryKey(paramUser.getUsername());
        if (user == null) {
            return super.simpleBuildErrorMsg("找不到用户,请检查用户名是否正确");
        }
        if (!EncodePassword.checkPassword(paramUser.getPassword(), user.getPassword())) {
            return super.simpleBuildErrorMsg("密码错误");
        }
        super.request.getSession().setAttribute("user", user);
        return super.simpleBuildSuccessMsg(user);
    }

    @RequestMapping("register")
    @ResponseBody
    public StatusMsg register(User u) {
        super.request.getSession(true);
        String username = u.getUsername();
        if (this.userService.selectByPrimaryKey(username) != null) {
            return super.simpleBuildErrorMsg("该用户已存在");
        }
        u.setPassword(EncodePassword.encodePassword(u.getPassword()));
        u.setCreateTime(new Date());
        u.setRelativePath(User.DEFAULT_HEAD_RELATIVE_PATH);
        u.setAbsolutePath(User.DEFAULT_HEAD_ABSOLUTE_PATH);
        this.userService.save(u);
        super.request.getSession().setAttribute("user", u);
        return super.simpleBuildSuccessMsg("注册成功!", u);
    }

}
