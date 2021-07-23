package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DiscountCodeForm {
    @NotBlank
    @NotEmpty
    private String code;

    @Positive
    private Float discount;

    @NotNull
    private Boolean used;
}
