package hr.kingict.webshop.dto;

import lombok.Data;

@Data
public class OrderProductsDto {
    private Long productId;
    private Long orderId;
}
