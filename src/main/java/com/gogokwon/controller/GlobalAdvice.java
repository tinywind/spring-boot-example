package com.gogokwon.controller;

import com.gogokwon.util.GlobalControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
//alt+enter import
//ctrl + alt + l 자동 정렬
//alt + insert 코드 자동 생성
//ctrl + shift + a 기능 도움말
//shift + shift 파일 이동
//shift + F6 전체 rename
/**
 * Created by KJShin on 2017-05-07.
 */
@ControllerAdvice
public class GlobalAdvice {
    @Autowired
    private HttpSession session;

    // Model model
    // model.addAttribute("session", session)
    @ModelAttribute("session")
    public HttpSession session(){
        return session;
    }

    @ModelAttribute("u")
    public GlobalControllerUtil globalControllerUtil() {
        return new GlobalControllerUtil();
    }

    @ModelAttribute("login")
    public Boolean login()
    {
        return session.getAttribute("user") != null;
    }
}
