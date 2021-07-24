package hr.kingict.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DiscountCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private Float discount;
    private Boolean used;
}
