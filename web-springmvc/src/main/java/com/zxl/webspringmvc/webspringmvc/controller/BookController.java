package com.zxl.webspringmvc.webspringmvc.controller;

import com.zxl.webspringmvc.webspringmvc.entity.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 测试转换器和格式化器
 */

@Controller
public class BookController {
    private static final Log logger = LogFactory.getLog("BookController.class");

    //在跳转到inputBook.jsp页面前，就为model添加一个book属性，值为Book的实例
    @RequestMapping (value = "/input-book")
    public String inputBook(@ModelAttribute("book") Book book, Model model){
        logger.info("inputBook called");
        model.addAttribute("book",new Book());
        return "inputBook";
    }

    //TODO:普通方法
    @RequestMapping(value="/save-book",method = RequestMethod.POST)
    public String saveBook(String isbn, String name, String author, String pubdate, String price,Model model) {
        logger.info("调用saveBook()方法");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate newdate = LocalDate.parse(pubdate, formatter);
            BigDecimal bprice = new BigDecimal(price);
            Book book = new Book(isbn, name, author, newdate, bprice);
            model.addAttribute("book", book);
            return "showBook";
        } catch (DateTimeParseException e) {
            System.out.println(e.toString());
            return "inputBook";
        }
    }
    //TODO:测试转换器
    @PostMapping(value="/save-book2")
    public String saveBook2(@ModelAttribute Book book, BindingResult bindingResult, Model model) {
        logger.info("调用saveBook()方法");
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return "inputBook";
        }
        return "showBook";
    }
}