package com.gogokwon.controller.blog;

import com.gogokwon.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KJShin on 2017-04-09.
 */
@Controller
@RequestMapping("")
public class BlogController {

    @RequestMapping("")
    public String indexPage(Model model){
        String authorString = "gogokwon";
        String TitleString = "이태원 스포츠";
        model.addAttribute("title", authorString +" blog");
        model.addAttribute("author", authorString);
        model.addAttribute("intro", "테스트용 블로그입니다.");

        List<Post> posts= new ArrayList<>();
        model.addAttribute("posts", posts);
/*
        Post post1 = new Post();
        post1.setHref("http://www.google.com");
        post1.setTitle("Google");
        post1.setSubtitle("검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 검색 ");
        post1.setDate(new Date());


        Post post2 = new Post();
        post2.setHref("http://www.yahoo.com");
        post2.setTitle("Yahoo");
        post2.setSubtitle("yahoo 검색");
        post2.setDate(new Date());


*/
        //Post post1 = new Post("http://www.google.com", "google 검색", "잘검색");
        Post post2 = new Post("http://www.yahoo.com", "yahoo 검색", "잘검색");

        posts.add(new Post("http://www.google.com", "google 검색", "잘검색"));
        posts.add(post2);

        return "index";
    }
}
