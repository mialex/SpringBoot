package com.spring.app.springapp3.bootstrap;

import com.spring.app.springapp3.entity.Beer;
import com.spring.app.springapp3.entity.Customer;
import com.spring.app.springapp3.model.BeerStyle;
import com.spring.app.springapp3.repository.BeerRepository;
import com.spring.app.springapp3.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeerData();
        }

        if (customerRepository.count() == 0) {
            loadCustomerData();
        }
    }

    public void loadBeerData() {
        Beer beer1 = Beer.builder()
                .beerName("Beer One")
                .beerStyle(BeerStyle.ALE)
                .upc("12345")
                .price(new BigDecimal("12.9"))
                .quantityOnHand(100)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .beerName("Beer Two")
                .beerStyle(BeerStyle.IPA)
                .upc("2345")
                .price(new BigDecimal("11.5"))
                .quantityOnHand(200)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .beerName("Beer Three")
                .beerStyle(BeerStyle.LAGER)
                .upc("12345")
                .price(new BigDecimal("15.1"))
                .quantityOnHand(300)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        beerRepository.save(beer1);
        beerRepository.save(beer2);
        beerRepository.save(beer3);
    }

    public void loadCustomerData() {
        Customer customer1 = Customer.builder()
                .name("Customer 1")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("Customer 2")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .name("Customer 3")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
    }
}
