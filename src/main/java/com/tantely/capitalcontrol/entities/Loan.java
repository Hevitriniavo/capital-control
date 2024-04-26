package com.tantely.capitalcontrol.entities;

import com.tantely.capitalcontrol.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "loans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private Client borrower;

    private Double amount;

    private Date loanDate;

    private Date repaymentDate;

    private Double interestRate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

}
