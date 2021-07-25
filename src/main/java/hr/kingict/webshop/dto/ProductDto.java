package hr.kingict.webshop.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;
    private Long brandId;
}
