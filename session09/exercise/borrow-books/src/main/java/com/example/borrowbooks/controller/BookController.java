package com.example.borrowbooks.controller;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping("/")
    public ModelAndView showList(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<Book> bookPage = bookService.showPage(pageable);
        return new ModelAndView("list", "bookPage", bookPage);
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return new ModelAndView("view", "book", book);
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("create", "book", new Book());
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/borrow/{id}")
    public String borow(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        int quanlity = book.getQuantity() - 1;
        if (quanlity < 0) {
            model.addAttribute("message", "The book is out");
            model.addAttribute("book", book);
            return "view";
        }
        book.setQuantity(quanlity);
        String codeBorrow = String.format("%05d", new Random().nextInt(100000));
        List<String> list;
        if (book.getListCodeBorrow()  == null) {
            list = new ArrayList<>();
        }else {
            list = new ArrayList<>(book.getListCodeBorrow());
        }
        list.add(codeBorrow);
        book.setListCodeBorrow(list);

        bookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("code", codeBorrow);
        return "view";
    }

    @PostMapping("/return")
    public String returnBook(RedirectAttributes redirectAttributes, @RequestParam String codeBorrow) {
        List<Book> list = bookService.showList();
        for (Book b : list) {
            if (b.getListCodeBorrow().contains(codeBorrow)) {
                int quantity = b.getQuantity()+1;
                b.setQuantity(quantity);

                List<String> listCode = new ArrayList<>(b.getListCodeBorrow());
                listCode.remove(codeBorrow);
                b.setListCodeBorrow(listCode);

                bookService.save(b);
                redirectAttributes.addFlashAttribute("message", "You have successfully returned th book.     ");
                return "redirect:/";
            }
        }
        redirectAttributes.addFlashAttribute("message", "Code not found !");
        return "redirect:/";
    }
}
