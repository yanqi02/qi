package upcnews.dao;

import upcnews.bean.Article;

import java.util.List;


public interface ArticleDao {
    List<Article> listArticle(int s);
    List<Article> listArticleByAuthor(String author,int s);
    int addArticle(Article article);

    int approve(int articleId);
    void add(String username, String password);
}
