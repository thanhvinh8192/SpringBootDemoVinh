package model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter @Setter
public class BookModel {
    private  int idBook;
    private String title;
    private Time releaseTime;
    private String description;
    private String author;
    private long price;
    private String photoLink;
    private int idCategory;

    public BookModel(int idBook, String title, Time releaseTime, String description, String author, long price, String photoLink, int idCategory) {
        this.idBook = idBook;
        this.title = title;
        this.releaseTime = releaseTime;
        this.description = description;
        this.author = author;
        this.price = price;
        this.photoLink = photoLink;
        this.idCategory = idCategory;
    }
}
