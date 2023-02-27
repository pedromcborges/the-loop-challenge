package org.borges.mapper;

import org.borges.data.PriceDto;
import org.borges.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDto entityToPriceDto(Price entity);
}
