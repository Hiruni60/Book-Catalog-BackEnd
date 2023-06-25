package com.example.demo.service.impl;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveBook(BookDto dto) {
        Book books = bookRepo.findByBookName(dto.getBookName());
        if (Objects.equals(books, null)){
            bookRepo.save(modelMapper.map(dto, Book.class));
            return "success";
        }
        throw new RuntimeException("Book Name Already Exist!");
    }

    @Override
    public String updateBook(BookDto dto) {
        Book books = bookRepo.findById(dto.getBookId());
        if (!Objects.equals(books,null)){
            bookRepo.save(modelMapper.map(dto, Book.class));
            return "success";
        }
        throw new RuntimeException("Book not Exist!");
    }

    @Override
    public String deleteBook(int bookId) {
        Book books = bookRepo.findById(bookId);
        if (!Objects.equals(books,null)){
            bookRepo.delete(books);
            return "success";
        }
        throw new RuntimeException("Book not Exist!");
    }

    @Override
    public BookDto searchBook(int bookId) {
        Book books = bookRepo.findById(bookId);
        if (!Objects.equals(books,null)){
            return modelMapper.map(books, BookDto.class);
        }
        throw new RuntimeException("Book not Exist!");
    }

    @Override
    public List<BookDto> getAllBook(String bookName, String category) {
        return modelMapper.map(bookRepo.booksFilter(bookName, category), new TypeToken<List<BookDto>>(){}.getType());
    }
}
