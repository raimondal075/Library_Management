package dev.folio;
import jakarta.persistence.*;
@Entity public class Book {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String title,author,category,description; private boolean available=true;
protected Book(){} public Book(String t,String a,String c,String d){title=t;author=a;category=c;description=d;}
public Long getId(){return id;} public String getTitle(){return title;} public String getAuthor(){return author;} public String getCategory(){return category;} public String getDescription(){return description;} public boolean isAvailable(){return available;} public void setAvailable(boolean v){available=v;}
}