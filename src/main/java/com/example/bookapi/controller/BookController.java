package com.example.bookapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BookController {

    @GetMapping("/books")
    public void getAllBook(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {



    }

}
