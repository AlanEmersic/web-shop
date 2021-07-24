package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.OrderDto;
import hr.kingict.webshop.facade.OrderFacade;
import hr.kingict.webshop.form.OrderForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class OrderController {
    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) {
        return orderFacade.get(id);
    }

    @GetMapping
    public List<OrderDto> getAll() {
        return orderFacade.getAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody OrderForm orderForm) {
        orderFacade.create(orderForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderFacade.delete(id);
    }
}
