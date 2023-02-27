package org.borges.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;
    private Instant startDate;
    private Instant endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;
}
