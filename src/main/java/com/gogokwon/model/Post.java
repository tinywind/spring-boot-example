package com.gogokwon.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by KJShin on 2017-04-09.
 */
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String subtitle;
    private String content;
    private Date date = new Date();

    private String fileUrl;


}
