package com.tantely.capitalcontrol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String currencyCode;

    @Column(length = 100)
    private String countryName;

    @OneToMany(mappedBy = "sourceCurrency")
    private List<CurrencyConversionRate> sourceConversionRates = new ArrayList<>();

    @OneToMany(mappedBy = "targetCurrency")
    private List<CurrencyConversionRate> targetConversionRates = new ArrayList<>();

    @OneToMany(mappedBy = "currency")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "sourceCurrency")
    private List<Transfer> sourceCurrencies = new ArrayList<>();

    @OneToMany(mappedBy = "targetCurrency")
    private List<Transfer> targetCurrencies = new ArrayList<>();
}
