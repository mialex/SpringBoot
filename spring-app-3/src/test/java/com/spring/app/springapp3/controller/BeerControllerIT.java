package com.spring.app.springapp3.controller;

import com.spring.app.springapp3.controller.exception.NotFoundException;
import com.spring.app.springapp3.entity.Beer;
import com.spring.app.springapp3.mapper.BeerMapper;
import com.spring.app.springapp3.model.BeerDTO;
import com.spring.app.springapp3.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {
    @Autowired
    BeerController beerController;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;
    
    @Test
    void testListBeer() {
        List<BeerDTO> listDTO = beerController.listBeer();

        assertThat(listDTO.size()).isEqualTo(3);
    }

    @Transactional
    @Rollback
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();

        List<BeerDTO> listDTO = beerController.listBeer();

        assertThat(listDTO.size()).isEqualTo(0);
        // OR
        assertThat(listDTO).isEmpty();
    }

    @Test
    void testBeerById() {
        Beer beer = beerRepository.findAll().get(0);

        BeerDTO beerDTO = beerController.getBeerById(beer.getId());

        assertThat(beerDTO).isNotNull();
    }

    @Test
    void testBeerByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.getBeerById(UUID.randomUUID());
        });
    }

    @Transactional
    @Rollback
    @Test
    void saveNewBeetTest() {
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("Test new beer name")
                .build();

        ResponseEntity responseEntity = beerController.postBeer(beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);

        Beer beer = beerRepository.findById(savedUUID).get();
        assertThat(beer).isNotNull();
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.putBeer(UUID.randomUUID(), BeerDTO.builder().build());
        });
    }

    @Transactional
    @Rollback
    @Test
    void updateExistingBeer() {
        Beer beer = beerRepository.findAll().get(0);
        BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);

        beerDTO.setId(null);
        beerDTO.setVersion(null);

        String updatedName = "Updated Beer name";
        beerDTO.setBeerName(updatedName);

        ResponseEntity responseEntity = beerController.putBeer(beer.getId(), beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.valueOf(204));

        Beer beerUpdated = beerRepository.findById(beer.getId()).get();

        assertThat(beerUpdated.getBeerName()).isEqualTo(updatedName);
    }


    @Test
    void testDeleteByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.deleteBeer(UUID.randomUUID());
        });
    }

    @Transactional
    @Rollback
    @Test
    void testDeleteById() {
        Beer beer = beerRepository.findAll().get(0);

        ResponseEntity responseEntity = beerController.deleteBeer(beer.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.valueOf(204));

        assertThat(beerRepository.findById(beer.getId())).isEmpty();
    }
}