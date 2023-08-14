package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Page<Book> getAllBook(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {

        int newPage = (page > 0) ? page - 1: 0;
        return bookService.getAllBooks(newPage, pageSize);

    }

    @PostMapping("/books")
    public void saveBook(@RequestBody List<Book> books) {

        for (Book book: books) {
            bookService.saveBook(book);
        }

    }

}
