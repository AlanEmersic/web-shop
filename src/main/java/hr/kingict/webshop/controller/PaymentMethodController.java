package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.PaymentMethodDto;
import hr.kingict.webshop.facade.PaymentMethodFacade;
import hr.kingict.webshop.form.PaymentMethodForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class PaymentMethodController {
    private final PaymentMethodFacade paymentMethodFacade;

    public PaymentMethodController(PaymentMethodFacade paymentMethodFacade) {
        this.paymentMethodFacade = paymentMethodFacade;
    }

    @GetMapping("/{id}")
    public PaymentMethodDto get(@PathVariable Long id) {
        return paymentMethodFacade.get(id);
    }

    @GetMapping
    public List<PaymentMethodDto> getAll() {
        return paymentMethodFacade.getAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody PaymentMethodForm paymentMethodForm) {
        paymentMethodFacade.create(paymentMethodForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentMethodFacade.delete(id);
    }
}
