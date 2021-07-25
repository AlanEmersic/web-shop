package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.OrderProductsDto;
import hr.kingict.webshop.facade.OrderProductsFacade;
import hr.kingict.webshop.form.OrderProductsForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class OrderProductsController {
    private final OrderProductsFacade orderProductsFacade;

    public OrderProductsController(OrderProductsFacade orderProductsFacade) {
        this.orderProductsFacade = orderProductsFacade;
    }

    @GetMapping("/{id}")
    public OrderProductsDto get(@PathVariable Long id) {
        return orderProductsFacade.get(id);
    }

    @GetMapping("/order/{id}")
    public List<OrderProductsDto> getAll(@PathVariable Long id) {
        return orderProductsFacade.getAll(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody OrderProductsForm orderProductsForm) {
        orderProductsFacade.create(orderProductsForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderProductsFacade.delete(id);
    }
}
