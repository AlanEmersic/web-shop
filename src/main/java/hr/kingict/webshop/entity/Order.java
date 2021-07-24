package hr.kingict.webshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "discountCodeId", referencedColumnName = "id")
    private DiscountCode discountCode;

    @ManyToOne(targetEntity = PaymentMethod.class)
    @JoinColumn(name = "paymentMethodId", updatable = false)
    private PaymentMethod paymentMethod;

    private LocalDate date;
    private Float totalPriceWithDiscount;
    private Float totalPriceWithoutDiscount;
    private String cardNumber;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;
    private String remark;
}
