package upcnews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import upcnews.bean.Article;
import upcnews.bean.ArticleStatus;
import upcnews.bean.Authority;
import upcnews.bean.User;
import upcnews.service.ArticleService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/articleSubmit")
    public ModelAndView addArticle(@RequestParam("title") String title, @RequestParam("context") String context, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Article article = new Article();
        article.setArticleName(title);
        article.setContext(context);
        article.setAuthor(((User)session.getAttribute("user")).getUserName());
        //article.setStatus(ArticleStatus.approvalling);
        mav.addObject("article",article);
        if(articleService.addArticle(article)){
            mav.addObject("errorMsg","提交成功");
        }else {
            mav.addObject("errorMsg","提交失败");
        }
        mav.setViewName("write");
        return mav;
    }


    @RequestMapping("/listApprovingArticle")
    public ModelAndView listApprovingArticle(HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.list(ArticleStatus.approvalling);
        mav.addObject("articles",articles);
        mav.setViewName("shenhe");
        return mav;
    }
    @RequestMapping("/listArticle")
    public ModelAndView listArticle(HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homepage");
        return mav;
    }
    @RequestMapping("/listApprovedArticle")
    public ModelAndView listApprovedArticle(HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Article> articles = articleService.list(ArticleStatus.approvaled);
        mav.addObject("articles",articles);
        mav.setViewName("homepage");
        return mav;
    }

    @RequestMapping("/homepage")
    public String homepage(){
        return "redirect:listApprovedArticle";
    }
    @RequestMapping("/approve")
    public String doApprove(){
        return "redirect:listApprovingArticle";
    }
    @RequestMapping("tongguo")
    public String tongguo(int articleId){
        articleService.approve(articleId);
        //System.out.println(article+":"+article.getArticleId());
        return "forward:listApprovingArticle";
    }
    @RequestMapping("/write")
    public ModelAndView write(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if(((User)session.getAttribute("user")).getAuthority() == Authority.visitor){
            mav.addObject("errorMsg","用户未登录");
            mav.setViewName("../index");
            return mav;
        }else{
            mav.setViewName("write");
            return mav;
        }
    }

}
