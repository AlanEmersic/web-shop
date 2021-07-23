package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class BrandForm {
    @NotBlank(message = "name can't be blank")
    private String name;
}
