package anon.ddd.prorammer.mapper;

import anon.ddd.prorammer.dto.CategoryDTO;
import anon.ddd.prorammer.dto.CategoryUpdateDTO;
import anon.ddd.prorammer.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Маппер для 'Категория'.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * Маппинг в сущность.
     *
     * @param dto - ДТО.
     * @return {@link Category}
     */
    Category mapToEntity(CategoryDTO dto);

    /**
     * Маппинг в ДТО.
     * @param category - сущность.
     * @return {@link CategoryDTO}
     */
    CategoryDTO mapToDTO(Category category);

    void update(CategoryUpdateDTO updateDTO, @MappingTarget Category category);

    Category mapToEntity(CategoryUpdateDTO dtoUpdate);

    CategoryUpdateDTO mapToEntity(Category category);
}
