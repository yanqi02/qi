package upcnews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upcnews.bean.Article;
import upcnews.dao.ArticleDao;

import java.util.List;


@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    public boolean addArticle(Article article){
        return articleDao.addArticle(article)==1;
    }
    public List<Article> list(int status){return articleDao.listArticle(status);}
    public List<Article> listByAuthor(String author,int s){
        return articleDao.listArticleByAuthor(author,s);
    }
    public int approve(int articleId){return articleDao.approve(articleId);}
}
