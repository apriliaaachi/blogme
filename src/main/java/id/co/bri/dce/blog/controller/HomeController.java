package id.co.bri.dce.blog.controller;

import id.co.bri.dce.blog.entity.Post;
import id.co.bri.dce.blog.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    PostDao postDao;

    @GetMapping("/homepage")
    public ModelAndView homepage(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Pageable paging = PageRequest.of(currentPage - 1, pageSize, Sort.by("date"));
        ModelAndView mv = new ModelAndView("home");
        Page<Post> posts = postDao.findByStatus("ACTIVE", paging);
        mv.addObject("page", posts);
        mv.addObject("posts", posts.getContent());
        return mv;
    }

}
