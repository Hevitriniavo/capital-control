package com.tantely.capitalcontrol.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account_id", referencedColumnName = "id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id")
    private Account destinationAccount;

    private Double amount;

    @Column(unique = true)
    private String reference;

    private LocalDateTime transferDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Subcategory subcategory;

    @ManyToOne
    private Currency targetCurrency;
}
