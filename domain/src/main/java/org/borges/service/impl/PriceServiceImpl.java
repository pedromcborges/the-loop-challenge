package org.borges.service.impl;

import org.borges.data.PriceDto;
import org.borges.persistence.PricePersistencePort;
import org.borges.service.PriceServicePort;

import java.time.Instant;
import java.util.Collections;
import java.util.Comparator;

public class PriceServiceImpl implements PriceServicePort {

    private final PricePersistencePort pricePersistencePort;

    public PriceServiceImpl(PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    @Override
    public PriceDto findByBrandAndProductAndDate(Long brandId, Long productId, Instant date) throws ClassNotFoundException {
        var prices = pricePersistencePort.findByBrandAndProductAndBetweenDate(brandId, productId, date);
        if (prices.isEmpty()) {
            throw new ClassNotFoundException("Couldn't find any price with this parameters");
        }

        return Collections.max(prices, Comparator.comparing(PriceDto::getPriority));
    }
}
