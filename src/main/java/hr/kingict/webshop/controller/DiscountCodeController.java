package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.DiscountCodeDto;
import hr.kingict.webshop.facade.DiscountCodeFacade;
import hr.kingict.webshop.form.DiscountCodeForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/discount-codes")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class DiscountCodeController {

    private final DiscountCodeFacade discountCodeFacade;

    public DiscountCodeController(DiscountCodeFacade discountCodeFacade) {
        this.discountCodeFacade = discountCodeFacade;
    }

    @GetMapping("/{id}")
    public DiscountCodeDto get(@PathVariable Long id) {
        return discountCodeFacade.get(id);
    }

    @GetMapping
    public List<DiscountCodeDto> getAll() {
        return discountCodeFacade.getAll();
    }

    @PostMapping
    public void create(@Valid @RequestBody DiscountCodeForm discountCodeForm) {
        discountCodeFacade.create(discountCodeForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        discountCodeFacade.delete(id);
    }
}
