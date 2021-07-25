package hr.kingict.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "orderId")
    private Order order;
}
