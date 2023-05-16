package com.geekster.Mapping.controller;

import com.geekster.Mapping.model.Book;
import com.geekster.Mapping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){

        return bookService.addBook(book);
    }

    @GetMapping("/getBook")
    public List<Book> getAllBook(@PathVariable Integer bookId){
        return bookService.getAllBook(bookId);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBookById(@PathVariable Integer bookId){
        return bookService.deleteBookById(bookId);
    }

    @PutMapping("/updateBook/{bookId}")
    public String updateBook(@PathVariable Integer bookId , @RequestBody Book book){
        return bookService.updateBook(bookId , book);
    }
}
