package org.example.springrest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "readers", schema = "public")
@NoArgsConstructor
@Data
public class Reader {
    @Id
    @Column(name = "reader_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "readerList")
    private List<Book> bookList;

    @OneToMany(mappedBy = "reader")
    private List<Subscription> subscriptionList;
}
