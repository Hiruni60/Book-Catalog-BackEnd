package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;

public interface BookService {
    String saveBook(BookDto dto);
    String updateBook(BookDto dto);
    String deleteBook(int bookId);
    BookDto  searchBook(int bookId);
    List<BookDto> getAllBook(String bookName, String category);
}
