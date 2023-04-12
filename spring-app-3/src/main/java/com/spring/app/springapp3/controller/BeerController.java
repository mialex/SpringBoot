package com.spring.app.springapp3.controller;

import com.spring.app.springapp3.controller.exception.NotFoundException;
import com.spring.app.springapp3.model.BeerDTO;
import com.spring.app.springapp3.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
//@RequestMapping("/api/v1/beers")
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beers";
    public static final String BEER_PATH_ID = "/api/v1/beers/{beerId}";

    private final BeerService beerService;

    @RequestMapping(value = BEER_PATH, method = RequestMethod.GET)
    public List<BeerDTO> listBeer() {
        return beerService.listBeer();
    }

    @RequestMapping(value = BEER_PATH_ID, method = RequestMethod.GET)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug(" # [DEBUG] # BeerController::BeerService was called - 657");

        return beerService.getBeerId(beerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(BEER_PATH)
//    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postBeer(@RequestBody BeerDTO beer) {

        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity putBeer(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {

        if (beerService.updateBeer(beerId, beer).isEmpty()) {
            throw new NotFoundException();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + beerId.toString());

        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteBeer(@PathVariable UUID beerId) {
        if (!beerService.deleteBeerById(beerId)) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity patchBeer(@PathVariable UUID beerId, @RequestBody BeerDTO beer) {

        if (beerService.patchBeer(beerId, beer).isEmpty()) {
            throw new NotFoundException();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + beerId.toString());

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * This makes an effect for this controller only!
     * To use this, uncomment @ExceptionHandler
     */
//    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
