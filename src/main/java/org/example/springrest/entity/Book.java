package org.example.springrest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books", schema = "public")
@NoArgsConstructor
@Data
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "author")
    private String author;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "year_of_publishing")
    private Integer yearOfPublishing;

    @Column(name = "deposit_price")
    private Integer depositPrise;

    @ManyToMany()
    @JoinTable(name = "readers_books",
            joinColumns = @JoinColumn(name = "fk_book_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_reader_id"))
    private List<Reader> readerList;

    @OneToMany(mappedBy = "book")
    private List<Subscription> subscriptionList;
}