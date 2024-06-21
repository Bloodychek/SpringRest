package org.example.springrest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subscriptions", schema = "public")
public class Subscription {
    @Id
    @Column(name = "subscription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne()
    @JoinColumn(name = "fk_book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "fk_reader_id")
    private Reader reader;
}