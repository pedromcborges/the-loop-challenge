package org.borges.adapter;

import org.borges.data.PriceDto;
import org.borges.mapper.PriceMapper;
import org.borges.persistence.PricePersistencePort;
import org.borges.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceAdapter implements PricePersistencePort {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<PriceDto> findByBrandAndProductAndBetweenDate(Long brandId, Long productId, Instant date) {
        return priceRepository.findByBrandAndProductAndBetweenDate(brandId, productId, date).stream()
                .map(PriceMapper.INSTANCE::entityToPriceDto)
                .collect(Collectors.toList());
    }
}
