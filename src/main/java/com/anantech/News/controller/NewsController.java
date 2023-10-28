package com.anantech.News.controller;



import com.anantech.News.notification.WhatsAppNotification;
import com.anantech.News.vo.ArticleVO;
import com.anantech.News.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

//Controller
@RestController

public class NewsController {
//https://newsapi.org/
    String key="890a2acda7a1486a8b83876c9c8514fe";

    @Autowired
    WhatsAppNotification notfier;
    //using get method and hello-world as URI
    @RequestMapping(method=RequestMethod.GET, path="/getNews")

    public List<String> getNews()


    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://newsapi.org/v2/top-headlines?country=in&apiKey=890a2acda7a1486a8b83876c9c8514fe";
              //  = "https://newsapi.org/v2/top-headlines?country=in&language=he&category=business&apiKey=890a2acda7a1486a8b83876c9c8514fe";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl , String.class);

        NewsVO newsVO = restTemplate
                .getForObject(fooResourceUrl , NewsVO.class);




        List<String> ls = new ArrayList<String>();
        for(ArticleVO article:newsVO.getArticles()){
           // ls.add(article.getContent());
            ls.add(article.printArticle());
        }
        notfier.notify(ls.subList(0, 4));
        return ls;
    }
}
