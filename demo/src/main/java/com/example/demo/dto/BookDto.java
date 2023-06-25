package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int bookId;
    private String  bookName;
    private String  description;
    private String  category;
    private String  author;
    private double price;
}
