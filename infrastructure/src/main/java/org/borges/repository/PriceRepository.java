package org.borges.repository;

import org.borges.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "select * from price p where p.brand_id = ?1 and p.product_id = ?2 and p.start_date <= ?3 and p.end_date >= ?3", nativeQuery = true)
    List<Price> findByBrandAndProductAndBetweenDate(Long brandId, Long productId, Instant date);
}
