package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;
    private String author;
    private String imgUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;
    @Enumerated(EnumType.STRING)
    private Category category;

    @Transient
    private List<Integer> quantityList = new LinkedList<>();

    public Book(String title, double price, String author, String imgUrl, LocalDate publishedDate, Category category) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.imgUrl = imgUrl;
        this.publishedDate = publishedDate;
        this.category = category;
    }
}
