package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class PaymentMethodForm {
    @NotBlank
    @NotEmpty
    private String name;
}
