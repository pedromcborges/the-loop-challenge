package org.borges.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.borges.data.PriceDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class PriceControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Stream<Arguments> provideUrlAndResultsForGet() {
        return Stream.of(
                Arguments.of(
                        "/prices?brand=1&date=2020-06-14T10:00:00Z&product=35455",
                        PriceDto.builder()
                                .id(1L)
                                .brand(PriceDto.BrandDto.builder()
                                        .id(1L)
                                        .name("LOJA")
                                        .build())
                                .startDate(Instant.parse("2020-06-13T23:00:00Z"))
                                .endDate(Instant.parse("2020-12-31T23:59:59Z"))
                                .priceList(1L)
                                .productId(35455L)
                                .priority(0)
                                .price(35.5)
                                .currency("EUR")
                                .build()),
                Arguments.of(
                        "/prices?brand=1&date=2020-06-14T16:00:00Z&product=35455",
                        PriceDto.builder()
                                .id(2L)
                                .brand(PriceDto.BrandDto.builder()
                                        .id(1L)
                                        .name("LOJA")
                                        .build())
                                .startDate(Instant.parse("2020-06-14T14:00:00Z"))
                                .endDate(Instant.parse("2020-06-14T17:30:00Z"))
                                .priceList(2L)
                                .productId(35455L)
                                .priority(1)
                                .price(25.45)
                                .currency("EUR")
                                .build()),
                Arguments.of(
                        "/prices?brand=1&date=2020-06-14T21:00:00Z&product=35455",
                        PriceDto.builder()
                                .id(1L)
                                .brand(PriceDto.BrandDto.builder()
                                        .id(1L)
                                        .name("LOJA")
                                        .build())
                                .startDate(Instant.parse("2020-06-13T23:00:00Z"))
                                .endDate(Instant.parse("2020-12-31T23:59:59Z"))
                                .priceList(1L)
                                .productId(35455L)
                                .priority(0)
                                .price(35.5)
                                .currency("EUR")
                                .build()),
                Arguments.of(
                        "/prices?brand=1&date=2020-06-15T10:00:00Z&product=35455",
                        PriceDto.builder()
                                .id(3L)
                                .brand(PriceDto.BrandDto.builder()
                                        .id(1L)
                                        .name("LOJA")
                                        .build())
                                .startDate(Instant.parse("2020-06-14T23:00:00Z"))
                                .endDate(Instant.parse("2020-06-15T10:00:00Z"))
                                .priceList(3L)
                                .productId(35455L)
                                .priority(1)
                                .price(30.5)
                                .currency("EUR")
                                .build()),
                Arguments.of(
                        "/prices?brand=1&date=2020-06-16T21:00:00Z&product=35455",
                        PriceDto.builder()
                                .id(4L)
                                .brand(PriceDto.BrandDto.builder()
                                        .id(1L)
                                        .name("LOJA")
                                        .build())
                                .startDate(Instant.parse("2020-06-15T15:00:00Z"))
                                .endDate(Instant.parse("2020-12-31T23:59:59Z"))
                                .priceList(4L)
                                .productId(35455L)
                                .priority(1)
                                .price(38.95)
                                .currency("EUR")
                                .build())
        );
    }

    @ParameterizedTest
    @MethodSource("provideUrlAndResultsForGet")
    public void shouldReturnCorrectPriorityPriceForParameters(String url, PriceDto dto) throws Exception {
        this.mockMvc.perform(get(url))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(dto)));
    }
}
