package com.oj.controller;

import com.oj.bean.OrdinaryUser;
import com.oj.bean.User;
import com.oj.dao.OrdinaryUserRepository;
import com.oj.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TMXIAOPAI
 * @Package com.oj.controller
 * @Date 2019/11/22-上午12:15
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdinaryUserRepository ordinaryUserRepository;


    @RequestMapping("/")
    public String Login(HttpServletRequest request, ModelMap model) {
        //获取帐号密码
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        System.out.println(password);
        if (email!=null && password!=null) {
            List<User> users = userRepository.findByEmail(email);
            System.out.println("查询结果条数:" + users.size());
            if (users.size() != 0) {
                User user = users.get(0);
                System.out.println(user.getUNickname());
                if (password.equals(user.getUPassword())) {
                    OrdinaryUser ou = ordinaryUserRepository.findByUid(user.getUId());
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("ou", ou);
                    model.addAttribute("user", user);
                    model.addAttribute("ou", ou);
                    model.addAttribute("logflag", true);
                    if(user.getUIdentity()==0){
                        return "ordinaryMenu/home";
                    }else {
                        return "Admin/Home/home";
                    }
                } else {
                    model.addAttribute("logmes", "密码不正确,请重新输入！");
                    model.addAttribute("email", email);
                    model.addAttribute("logflag", false);
                }


            } else {
                model.addAttribute("logmes", "该帐号不存在，请重新输入！");
                model.addAttribute("logflag", false);
            }
        } else {
            model.addAttribute("logflag", false);
        }

        return "ordinaryMenu/home";
    }

    @RequestMapping("/logout")
    public String LogOut(HttpServletRequest request, ModelMap modelMap){
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("ou");
        modelMap.addAttribute("logflag",false);
        return "ordinaryMenu/home";
    }
}
