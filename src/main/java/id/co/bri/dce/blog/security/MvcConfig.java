package id.co.bri.dce.blog.security;

import id.co.bri.dce.blog.controller.HomeController;
import id.co.bri.dce.blog.controller.SignInController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    public  void addViewControllerr(SignInController signInController) {
//       signInController("/signInAction")
    }
}
