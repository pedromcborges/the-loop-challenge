package org.borges.controller;

import org.borges.data.PriceDto;
import org.borges.service.PriceServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceServicePort priceServicePort;

    @GetMapping
    PriceDto findByBrandAndProductAndDate(
            @RequestParam("brand") Long brandId,
            @RequestParam("product") Long productId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant date
    ) throws ClassNotFoundException {
        return priceServicePort.findByBrandAndProductAndDate(brandId, productId, date);
    }
}
