package com.blog.myblog.controller.admin;

import com.blog.myblog.entity.AdminUser;
import com.blog.myblog.service.AdminUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月01日 9:33
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminUserService adminUserService;

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session){
        if(StringUtils.isEmpty(verifyCode)){
            session.setAttribute("error","验证码不能为空");
            return "admin/login";
        }
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
            session.setAttribute("error","用户名或密码不能为空");
            return "admin/login";
        }
        String Code = session.getAttribute("verifyCode")+"";
        if(StringUtils.isEmpty(verifyCode)||!Code.equals(verifyCode)){
            session.setAttribute("error","验证码错误");
            return "admin/login";
        }
        AdminUser adminUser = adminUserService.login(userName,password);
        if(adminUser != null){
            session.setAttribute("loginUser",adminUser.getNickName());
            session.setAttribute("loginUserId",adminUser.getAdminUserId());
            session.setMaxInactiveInterval(60*60*2);
            return "redirect:/admin/index";
        }else{
            session.setAttribute("error","登陆失败");
            return "admin/login";
        }
    }
    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "admin/index";
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request){
        Integer loginUserId = (Integer) request.getSession().getAttribute("loginUserId");
        AdminUser adminUser = adminUserService.getUserDetailById(loginUserId);
        if(adminUser == null){
            return "admin/login";
        }
        request.setAttribute("path","profile");
        request.setAttribute("loginUserName",adminUser.getLoginUserName());
        request.setAttribute("nickName",adminUser.getNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request,@RequestParam("originalPassword") String originalPassword,
                                @RequestParam("newPassword") String newPassword){
        if(StringUtils.isEmpty(originalPassword)||StringUtils.isEmpty(newPassword)){
            return "参数不能为空";
        }
        Integer loginUserId = (Integer) request.getSession().getAttribute("loginUserId");
        if(adminUserService.updatePassword(loginUserId,originalPassword,newPassword)){
            request.getSession().removeAttribute("loginUserId");
            request.getSession().removeAttribute("loginUser");
            request.getSession().removeAttribute("errorMsg");
            return "success";
        }else{
            return "修改失败";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request,@RequestParam("loginUserName") String loginUserName,
                            @RequestParam("nickName") String nickName ){
        if(StringUtils.isEmpty((loginUserName)) || StringUtils.isEmpty(nickName)){
            return "参数不能为空";
        }
        Integer loginUserId = (Integer) request.getSession().getAttribute("loginUserId");
        if(adminUserService.updateName(loginUserId,loginUserName,nickName)){
            return "success";
        }else{
            return "修改失败";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(("loginUserId"));
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}
