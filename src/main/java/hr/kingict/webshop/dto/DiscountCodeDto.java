package hr.kingict.webshop.dto;

import lombok.Data;

@Data
public class DiscountCodeDto {
    private Long id;
    private String code;
    private Float discount;
    private Boolean used;
}
