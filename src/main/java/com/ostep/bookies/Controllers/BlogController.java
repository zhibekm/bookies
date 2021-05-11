package com.ostep.bookies.Controllers;

import com.ostep.bookies.Models.Blog;
import com.ostep.bookies.Repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/")
    public String blogMain(Model model){
        Iterable<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        return "home";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogNewAdd(@RequestParam String titleBlog, @RequestParam String anonsBlog,
                             @RequestParam String fullTextBlog, Model model){
        Blog blog = new Blog(titleBlog,anonsBlog,fullTextBlog);
        blogRepository.save(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!blogRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<Blog> blog = blogRepository.findById(id);
        ArrayList<Blog> res = new ArrayList<>();
        blog.ifPresent(res::add);
        model.addAttribute("blog",res);
        return "blog-detail";
    }

    @PostMapping("/blog/{id}/delete")
    public String blogDelete(@PathVariable(value = "id") long id, Model model){
        Blog blog = blogRepository.findById(id).orElseThrow();
        blogRepository.delete(blog);
        return "redirect:/";
    }
}

