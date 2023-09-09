package anon.ddd.prorammer.controller;

import anon.ddd.prorammer.model.entity.Category;
import anon.ddd.prorammer.model.entity.FileStorage;
import anon.ddd.prorammer.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public Category getCategory() {
        Category category = categoryRepository.getReferenceById(3L);
        return category;
    }

    @PostMapping
    public void test() {
        Category category1 = new Category();
        category1.setName("Test");
        category1.setStatus("Test");

        FileStorage fileStorage = new FileStorage();
        fileStorage.setName("Test");
        //category1.setLogo(fileStorage);
        Category category2 = categoryRepository.save(category1);
    }
}
