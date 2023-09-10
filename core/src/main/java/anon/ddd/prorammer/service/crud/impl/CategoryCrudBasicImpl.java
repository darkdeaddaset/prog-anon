package anon.ddd.prorammer.service.crud.impl;

import anon.ddd.prorammer.dto.CategoryDTO;
import anon.ddd.prorammer.dto.CategoryUpdateDTO;
import anon.ddd.prorammer.enums.Status;
import anon.ddd.prorammer.mapper.CategoryMapper;
import anon.ddd.prorammer.model.entity.Category;
import anon.ddd.prorammer.model.repository.CategoryRepository;
import anon.ddd.prorammer.service.crud.CrudBasic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CategoryCrudBasicImpl implements CrudBasic<CategoryUpdateDTO, CategoryDTO> {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO get(long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::mapToDTO)
                .orElseThrow(()-> new RuntimeException(
                        String.format("Не удалось найти категорию по идентификатору %s", id)));
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category category = categoryMapper.mapToEntity(dto);
        category = categoryRepository.save(category);
        return categoryMapper.mapToDTO(category);
    }

    @Override
    public CategoryDTO update(CategoryUpdateDTO dtoUpdate) {
        String name = dtoUpdate.getOldName();
        Category category = categoryRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(
                        String.format("Не удалось найти категорию с названием %s", name)));

        categoryMapper.update(dtoUpdate, category);
        category = categoryRepository.save(category);
        return categoryMapper.mapToDTO(category);
    }

    @Override
    public void closed(long id) {
        categoryRepository.findById(id)
                .stream()
                .peek(close -> close.setCreateDttm(OffsetDateTime.now()))
                .peek(close -> close.setStatus(Status.CLOSE))
                .map(categoryRepository::save)
                .findFirst()
                .orElseThrow(()-> new RuntimeException(
                        String.format("Не удалось найти категорию по идентификатору %s", id)));
    }
}
