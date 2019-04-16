package upcnews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import upcnews.bean.User;
import upcnews.service.UserService;

import javax.servlet.http.HttpSession;



@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public ModelAndView findUserById(@RequestParam("id") int id){
        ModelAndView mav = new ModelAndView();
        User user = userService.findUserById(id);
        mav.addObject("user",user);
        mav.setViewName("show");
        return mav;
    }
    @RequestMapping("/register")
    public ModelAndView addUser(User user){
        ModelAndView mav = new ModelAndView();
        if(userService.getUserByUserName(user.getUserName()) != null){
            mav.addObject("errorMsg","用户名已存在");
        }else{
            if(userService.addUser(user)){
                mav.setViewName("zhuce");
            }else {
                mav.addObject("errorMsg","注册失败");
            }
        }
        return mav;
    }
    @RequestMapping("/login")
    public ModelAndView loginCheck(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session){
        ModelAndView mav = new ModelAndView();
        User user = userService.loginCheck(userName,password);
        String view=null;
        if(user != null){
            view="redirect:listApprovedArticle";
            session.setAttribute("user",user);
        }
        else {
            view="../index";
            mav.addObject("errorMsg","用户名/密码错误");
        }
        mav.setViewName(view);
        return mav;
    }
    @RequestMapping("/visitorLogin")
    public ModelAndView visitorLogin(HttpSession session){
        User user = new User();
        user.setAuthority(upcnews.bean.Authority.visitor);
        session.setAttribute("user",user);
        //ArticleController articleController = new ArticleController();
        //ModelAndView mav = articleController.listApprovedArticle(session);
        return new ModelAndView("redirect:listApprovedArticle");
    }
    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView mav,HttpSession session){
        session.setAttribute("user",null);
        mav.setViewName("../index");
        return mav;
    }

}
