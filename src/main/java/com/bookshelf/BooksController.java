package com.bookshelf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class BooksController {
    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("booksList", BooksService.getRepository().findAll());
        List<Book> books = (List<Book>) model.getAttribute("booksList");
        books.forEach(i -> System.out.println(i.getName()));
        log.info("Home page was configured, page passing");
        return "home";
    }

    @PostMapping("/add")
    public ModelAndView addBook(
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            ModelMap model) {
        BooksService.addBook(new Book(name, author));
        model.addAttribute("booksList", BooksService.getRepository().findAll());
        return new ModelAndView("redirect:/", model);
    }

    @DeleteMapping ("/delete")
    public ModelAndView deleteBookByIndex(
            @RequestParam("index") int index,
            ModelMap model) {
        BooksService.deleteBookByIndex(index);
        model.addAttribute("booksList", BooksService.getRepository().findAll());
        return new ModelAndView("redirect:/", model);
    }
}
