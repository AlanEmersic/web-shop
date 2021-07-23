package hr.kingict.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Float price;
    private Integer quantity;

    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brandId", updatable = false)
    private Brand brand;
}
