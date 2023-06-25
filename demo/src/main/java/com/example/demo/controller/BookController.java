package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import com.example.demo.util.ResponsiveUtil;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
    @Autowired
    BookService booksService;

    @PostMapping
    public ResponseEntity<ResponsiveUtil> saveBook(@RequestBody BookDto dto){
        String s = booksService.saveBook(dto);
        return new ResponseEntity<>(
                new ResponsiveUtil(200,s,null),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<ResponsiveUtil> updateBook(@RequestBody BookDto dto){
        String s = booksService.saveBook(dto);
        return new ResponseEntity<>(
                new ResponsiveUtil(200,s,null),
                HttpStatus.OK
        );
    }

    @DeleteMapping(params = "bookId")
    public ResponseEntity<ResponsiveUtil> deleteBook(@RequestParam int bookId){
        String s = booksService.deleteBook(bookId);
        return new ResponseEntity<>(
                new ResponsiveUtil(200,s,null),
                HttpStatus.OK
        );
    }

    @GetMapping(params = "bookId")
    public ResponseEntity<ResponsiveUtil> getBook(@RequestParam int bookId){
        BookDto booksDto = booksService.searchBook(bookId);
        return new ResponseEntity<>(
                new ResponsiveUtil(200,"success",booksDto),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/all",params = {"bookName", "category"})
    public ResponseEntity<ResponsiveUtil> getAllBook(@RequestParam String bookName,
                                                       @RequestParam String category){
        List<BookDto> allBook = booksService.getAllBook(bookName, category);
        return new ResponseEntity<>(
                new ResponsiveUtil(200,"success",allBook),
                HttpStatus.OK
        );
    }
}
