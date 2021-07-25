package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.OrderProductsDto;
import hr.kingict.webshop.form.OrderProductsForm;

import java.util.List;

public interface OrderProductsFacade {
    void create(OrderProductsForm orderProductsForm);

    OrderProductsDto get(Long id);

    List<OrderProductsDto> getAll();

    void delete(Long id);
}
