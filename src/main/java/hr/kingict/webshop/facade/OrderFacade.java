package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.form.OrderForm;

import java.util.List;

public interface OrderFacade {
    void create(OrderForm orderForm);

    OrderDto get(Long id);

    List<OrderDto> getAll();

    void delete(Long id);
}
