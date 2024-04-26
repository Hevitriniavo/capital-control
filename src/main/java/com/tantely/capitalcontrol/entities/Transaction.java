package com.tantely.capitalcontrol.entities;

import com.tantely.capitalcontrol.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Double amount;

    private LocalDateTime transactionDate;

    @ManyToOne
    private Subcategory subcategory;

    @Column(columnDefinition = "TEXT")
    private String description;
}
