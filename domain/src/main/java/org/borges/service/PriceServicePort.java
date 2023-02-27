package org.borges.service;

import org.borges.data.PriceDto;

import java.time.Instant;

public interface PriceServicePort {
    PriceDto findByBrandAndProductAndDate(Long brandId, Long productId, Instant date) throws ClassNotFoundException;
}
