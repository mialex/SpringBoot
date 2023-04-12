package com.spring.app.springapp3.mapper;

import com.spring.app.springapp3.entity.Beer;
import com.spring.app.springapp3.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
