package com.se.sample;

public class Book {
    public int rating;
    public String title;

    public Book (int rating, String title) {
        this.rating = rating;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "rating=" + rating +
                ", title='" + title + '\'' +
                '}';
    }
}
