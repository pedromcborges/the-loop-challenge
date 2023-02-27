package org.borges.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {
    private Long id;
    private BrandDto brand;
    private Instant startDate;
    private Instant endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BrandDto {
        private Long id;
        private String name;
    }
}
