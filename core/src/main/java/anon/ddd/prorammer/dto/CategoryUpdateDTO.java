package anon.ddd.prorammer.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryUpdateDTO {
    private String oldName;

    private String name;

    private String status;
}
