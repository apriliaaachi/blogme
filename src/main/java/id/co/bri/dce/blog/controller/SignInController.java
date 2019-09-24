package id.co.bri.dce.blog.controller;

import id.co.bri.dce.blog.entity.User;
import id.co.bri.dce.blog.repository.PostDao;
import id.co.bri.dce.blog.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SignInController {
    @Autowired
    UserDao userDao;

    @GetMapping("/signin")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "sign_in";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/signup-action")
    public String signUpAction(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/sign_in";
    }

    @PostMapping("/signin-action")
    public String signInAction(@ModelAttribute User user) {
        String email = user.getEmail();
        User user1 = userDao.findByEmail(email);
        String url="";

        if(user1.getEmail().equals(user.getEmail())
            && user1.getPassword().equals(user.getPassword()) ) {
                url = "/blog_post";

        }

        return url;

    }

}
