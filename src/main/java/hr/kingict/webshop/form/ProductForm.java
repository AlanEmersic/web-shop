package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ProductForm {
    @NotBlank
    @NotEmpty
    private String name;

    @NotEmpty
    @NotBlank
    private String description;

    @Positive
    private Float price;

    @PositiveOrZero
    private Integer quantity;

    @PositiveOrZero
    private Long brandId;
}
