package hr.kingict.webshop.facade;

import hr.kingict.webshop.dto.BrandDto;
import hr.kingict.webshop.form.BrandForm;

import java.util.List;

public interface BrandFacade {
    void create(BrandForm brandForm);

    BrandDto get(Long id);

    List<BrandDto> getAll();

    void delete(Long id);
}
