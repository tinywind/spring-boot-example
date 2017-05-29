package com.gogokwon.controller.blog;

import com.gogokwon.interceptor.LoginRequired;
import com.gogokwon.model.JoinForm;
import com.gogokwon.model.Post;
import com.gogokwon.model.User;
import com.gogokwon.repository.PostRepository;
import com.gogokwon.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
//alt+enter import
//ctrl + alt + l 자동 정렬
//alt + insert 코드 자동 생성
//ctrl + shift + a 기능 도움말
//shift + shift 파일 이동

/**
 * Created by KJShin on 2017-04-09.
 */
@Controller
@RequestMapping("")
public class BlogController {
    Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String indexPage(Model model, @PageableDefault(value = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        String authorString = "gogokwon";
        String TitleString = "이태원 스포츠";
        model.addAttribute("title", authorString + " blog");
        model.addAttribute("author", authorString);
        model.addAttribute("intro", "테스트용 블로그입니다.");
        Page<Post> posts = postRepository.findAll(pageable);
        model.addAttribute("posts", posts);
        return "index";
    }

    @RequestMapping("about.abc")
    public String aboutPage(Model model) {
        return "about";
    }

    @RequestMapping(value = "post/{id}", method = RequestMethod.GET)
    public String postPage(Model model, @PathVariable Long id) {
        if (!(Boolean) model.asMap().get("login")) {
            return "redirect:/login?to=/post/" + id;
        }

        Post post = postRepository.findOne(id);
        model.addAttribute("post", post);
        return "post";
    }

    @LoginRequired
    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String post(Model model, @Valid PostForm form, BindingResult bindingResult, HttpSession session) {
        if (!form.validate(bindingResult)) {
            model.addAttribute("bindingResult", bindingResult);
            return "write";
        }

        Long id = form.getId();
        Post post = id != null ? postRepository.findOne(id) : new Post();

        if (post == null)
            post = new Post();

        post.setTitle(form.getTitle());
        post.setSubtitle(form.getSubtitle());
        post.setContent(form.getContent());

        MultipartFile file = form.getFile();
        if (file != null) {
            String filepath = session.getId() + "/"
                    + System.currentTimeMillis() + "/"
                    + file.getOriginalFilename();
            try {
                File saveFile = new File(System.getProperty("user.dir") + "/files/" + filepath);

                try {
                    File dir = saveFile.getParentFile();
                    dir.mkdirs();
                } catch (Exception e) {
                }

                file.transferTo(saveFile);
                post.setFileUrl(filepath);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }

        postRepository.saveAndFlush(post);
        return "redirect:/";
    }

    @RequestMapping("contact")
    public String contactPage(Model model) {
        return "contact";
    }

    @LoginRequired
    @RequestMapping("write/{id}")
    public String modifyPage(Model model, @PathVariable Long id) {
        Post post = postRepository.findOne(id);
        if (post == null) {
            return "redirect:/";
        }
        model.addAttribute("post", post);

        return "write";
    }

    @LoginRequired
    @RequestMapping("write")
    public String writePage(Model model, @ModelAttribute("post") Post post) {
        model.addAttribute("post", new Post());
        return "write";
    }

    @LoginRequired
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        postRepository.delete(id);
        postRepository.flush();
        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(HttpSession session, String to) {
        if (to != null && to.trim().length() > 0)
            session.setAttribute("to", to);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, User user, HttpSession session) {

        if (userRepository.findByIdAndPassword(user.getId(), user.getPassword()).isEmpty()) {
            model.addAttribute("fail", true);
            return "login";
        }
        session.setAttribute("user", user);

        Object to = session.getAttribute("to");
        if (to != null) {
            session.removeAttribute("to");
            return "redirect:" + to;
        }
        return "redirect:/";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String joinPage(Model model) {

        if (userRepository.findAll().size() != 0) {
            return "redirect:/";
        }
        return "join";
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public String join(JoinForm form, Model model, HttpSession session) {

        if (userRepository.findAll().size() != 0) {
            return "redirect:/";
        }

        if (!userRepository.findById(form.getId()).isEmpty()) {
            model.addAttribute("message", "동일 아이디가 이미 존재합니다...");
            return "join";
        }
        User user = new User();
        user.setId(form.getId());
        user.setPassword(form.getPassword());
        userRepository.saveAndFlush(user);

        session.setAttribute("user", user);
        return "redirect:/";
    }

}
