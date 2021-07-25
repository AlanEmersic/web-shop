package hr.kingict.webshop.facade.impl;

import hr.kingict.webshop.dto.OrderProductsDto;
import hr.kingict.webshop.entity.Order;
import hr.kingict.webshop.entity.OrderProducts;
import hr.kingict.webshop.entity.Product;
import hr.kingict.webshop.facade.OrderProductsFacade;
import hr.kingict.webshop.form.OrderProductsForm;
import hr.kingict.webshop.service.OrderProductsService;
import hr.kingict.webshop.service.OrderService;
import hr.kingict.webshop.service.PaymentMethodService;
import hr.kingict.webshop.service.ProductService;
import hr.kingict.webshop.validator.OrderProductsFormValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderProductsFacadeImpl implements OrderProductsFacade {
    private final OrderProductsService orderProductsService;
    private final OrderProductsFormValidator orderProductsFormValidator;
    private final ProductService productService;
    private final OrderService orderService;
    private final PaymentMethodService paymentMethodService;

    public OrderProductsFacadeImpl(OrderProductsService orderProductsService,
                                   OrderProductsFormValidator orderProductsFormValidator,
                                   ProductService productService, OrderService orderService,
                                   PaymentMethodService paymentMethodService) {
        this.orderProductsService = orderProductsService;
        this.orderProductsFormValidator = orderProductsFormValidator;
        this.productService = productService;
        this.orderService = orderService;
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public void create(OrderProductsForm orderProductsForm) {
        orderProductsFormValidator.validateCreate(orderProductsForm);
        OrderProducts orderProducts = new OrderProducts();
        Product product = productService.get(orderProductsForm.getProductId());
        product.setQuantity(product.getQuantity() - 1);
        Order order = new Order();
        orderDefaultValues(order, 1L);
        orderService.save(order);
        orderProducts.setOrder(order);
        orderProducts.setProduct(product);

        productService.save(product);
        orderProductsService.save(orderProducts);
    }

    @Override
    public OrderProductsDto get(Long id) {
        return Optional.of(orderProductsService.get(id)).map(orderProducts -> {
            OrderProductsDto dto = new OrderProductsDto();
            mapOrderProductsToDto(orderProducts, dto);

            return dto;
        }).orElse(null);
    }

    @Override
    public List<OrderProductsDto> getAll(Long id) {
        return orderProductsService.getAll().stream()
                .filter(orderProducts -> orderProducts.getOrder().getId().equals(id))
                .map(orderProducts -> {
                    OrderProductsDto dto = new OrderProductsDto();
                    mapOrderProductsToDto(orderProducts, dto);

                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        OrderProducts orderProducts = orderProductsService.get(id);
        Product product = productService.get(orderProducts.getProduct().getId());
        product.setQuantity(product.getQuantity() + 1);
        productService.save(product);
        orderProductsService.delete(orderProducts);
    }

    private void mapOrderProductsToDto(OrderProducts orderProducts, OrderProductsDto dto) {
        dto.setId(orderProducts.getId());
        dto.setOrderId(orderProducts.getOrder().getId());
        dto.setProductId(orderProducts.getProduct().getId());
    }

    private void orderDefaultValues(Order order, Long id) {
        order.setId(id);
        order.setDate(LocalDate.now());
        order.setTotalPriceWithoutDiscount(0f);
        order.setTotalPriceWithDiscount(0f);
        order.setPaymentMethod(paymentMethodService.get(1L));
        order.setEmail("");
        order.setPhoneNumber("0");
        order.setDeliveryAddress("");
    }
}
