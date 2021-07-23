package hr.kingict.webshop.repository;

import hr.kingict.webshop.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    List<DiscountCode> findAllByCode(String code);
}
