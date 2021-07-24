package hr.kingict.webshop.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class OrderForm {
    private Long discountCodeId;

    @PositiveOrZero
    private Long paymentMethodId;

    @NotNull
    @JsonFormat(pattern = "d.M.yyyy.")
    private LocalDate date;

    @Positive
    private Float totalPriceWithoutDiscount;

    private String cardNumber;

    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    private String phoneNumber;

    @NotBlank
    @NotEmpty
    private String deliveryAddress;

    private String remark;
}
