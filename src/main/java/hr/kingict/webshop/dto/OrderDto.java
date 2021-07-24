package hr.kingict.webshop.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {
    private Long discountCodeId;
    private Long paymentMethodId;
    private LocalDate date;
    private Float totalPriceWithDiscount;
    private Float totalPriceWithoutDiscount;
    private String cardNumber;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;
    private String remark;
}
