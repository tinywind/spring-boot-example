package com.gogokwon.controller.blog;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by KJShin on 2017-05-07.
 */
@Data
public class PostForm {
    //getter setter는 lombok에 의해 자동 생성
    private String title;
    private String subtitle;
    private String content;

    private MultipartFile file;

    //validation 정의
    //return 성공하면 true
    public boolean validate(BindingResult bindingResult){
        if(title == null || title.length() == 0)
        {
            bindingResult.addError(new FieldError("form","title","제목이 없습니다"));
        }
        return !bindingResult.hasErrors();
    }
//    public  String getTiltle()
//    {
//        return "TITLE: " + title;
//    }

}
