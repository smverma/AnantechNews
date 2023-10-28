package com.anantech.News.vo;



import java.io.Serializable;
import java.util.List;

public class NewsVO implements Serializable {


    String status;

    int  totalResults;

    List<ArticleVO> articles;

    public List<ArticleVO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleVO> articles) {
        this.articles = articles;
    }





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }




}
