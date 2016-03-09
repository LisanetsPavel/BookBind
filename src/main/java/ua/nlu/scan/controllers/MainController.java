package ua.nlu.scan.controllers;

/**
 * Created by pc9 on 24.11.15.
 */

import ua.nlu.scan.entity.Book;
import ua.nlu.scan.service.BookService;
import ua.nlu.scan.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes(Constants.BOOK_LIST)
public class MainController {


    @Autowired
    private BookService bookService;

    /**
     * method returns index.html (main view)
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String getHome(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute(Constants.BOOK_LIST, bookList);

        return "static/index.html";
    }

    /**
     * method returns login page
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String getLogin() {
        return "static/login.html";
    }

    /**
     * method returns error page
     *
     * @return
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "static/error.html";
    }
}
