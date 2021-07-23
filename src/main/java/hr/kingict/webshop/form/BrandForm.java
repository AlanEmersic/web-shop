package hr.kingict.webshop.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BrandForm {
    @NotBlank
    private String name;
}
