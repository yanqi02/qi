package upcnews.bean;

public class Article {
    private String articleName;
    //private String path;
    private int articleId;
    private int status= 0;
    private String author;
    private String context;
    public String tran(String s)
    {

        sss.TraditionalSimplifiedWebService service = new sss.TraditionalSimplifiedWebService();
        //invoke business method
        sss.TraditionalSimplifiedWebServiceSoap sv =service.getTraditionalSimplifiedWebServiceSoap();
        return  sv.toTraditionalChinese(s);

    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleName='" + articleName + '\'' +
                ", path='" + articleName + '\'' +
                ", articleId=" + articleId +
                '}';
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Article() {

    }

    public Article(String articleName, int status, int articleId) {

        this.articleName = articleName;
        this.status = status;
        this.articleId = articleId;
    }
}
