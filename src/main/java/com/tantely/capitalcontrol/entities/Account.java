package com.tantely.capitalcontrol.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private Double balance;

    @Column(length = 20, unique = true)
    private String accountNumber;

    private Date openingDate;

    private Double loanLimit;

    private Boolean hasOverdraft;

    private Double netSalary;

    @ManyToOne
    private Currency currency;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();


    @OneToMany(mappedBy = "destinationAccount", cascade = CascadeType.ALL)
    private List<Transfer> destinationTransfers = new ArrayList<>();

    @OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL)
    private List<Transfer> sourceTransfers = new ArrayList<>();
}
