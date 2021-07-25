package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class OrderProductsForm {
    @PositiveOrZero
    @NotNull
    private Long productId;
    @PositiveOrZero
    @NotNull
    private Long orderId;
}
