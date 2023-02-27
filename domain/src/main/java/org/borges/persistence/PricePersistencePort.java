package org.borges.persistence;

import org.borges.data.PriceDto;

import java.time.Instant;
import java.util.List;

public interface PricePersistencePort {
    List<PriceDto> findByBrandAndProductAndBetweenDate(Long brandId, Long productId, Instant date);
}
