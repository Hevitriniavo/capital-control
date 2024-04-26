package com.tantely.capitalcontrol.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "currency_conversion_rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    private Double exchangeRate;
}
