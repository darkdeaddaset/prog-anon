package anon.ddd.prorammer.controller;

import anon.ddd.prorammer.dto.CategoryDTO;
import anon.ddd.prorammer.dto.CategoryUpdateDTO;
import anon.ddd.prorammer.service.crud.CrudBasic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CrudBasic<CategoryUpdateDTO, CategoryDTO> crudBasic;

    @GetMapping("{id}")
    public CategoryDTO get(@PathVariable long id) {
        return crudBasic.get(id);
    }

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO dto) {
        return crudBasic.save(dto);
    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryUpdateDTO dto) {
        return crudBasic.update(dto);
    }

    @DeleteMapping("/close/{id}")
    public void closed(@PathVariable long id) {
        crudBasic.closed(id);
    }
}
