package com.ostep.bookies.Controllers;

import com.ostep.bookies.Models.Post;
import com.ostep.bookies.Repo.PostRepository;
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
public class BookController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/book")
    public String bookMain(Model model){
        Iterable<Post> books = postRepository.findAll();
        model.addAttribute("books",books);
        return "book-main";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model){
        return "book-add";
    }

    @PostMapping("/book/add")
    public String bookNewAdd(@RequestParam String title,@RequestParam String url,
                             @RequestParam String fullText, Model model){
        Post post = new Post(title,url,fullText);
        postRepository.save(post);
        return "redirect:/book";
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/book";
        }
            Optional<Post> book = postRepository.findById(id);
            ArrayList<Post> res = new ArrayList<>();
            book.ifPresent(res::add);
            model.addAttribute("book",res);
            return "book-details";
    }

    @PostMapping("/book/{id}/delete")
    public String bookDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/book";
    }
}
