package hr.kingict.webshop.controller;

import hr.kingict.webshop.dto.BrandDto;
import hr.kingict.webshop.facade.BrandFacade;
import hr.kingict.webshop.form.BrandForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandFacade brandFacade;

    public BrandController(BrandFacade brandFacade) {
        this.brandFacade = brandFacade;
    }

    @GetMapping("/{id}")
    public BrandDto get(@PathVariable Long id) {
        return brandFacade.get(id);
    }

    @GetMapping
    public List<BrandDto> getAll() {
        return brandFacade.getAll();
    }

    @PostMapping
    public void create(@RequestBody BrandForm brandForm) {
        brandFacade.create(brandForm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        brandFacade.delete(id);
    }
}
