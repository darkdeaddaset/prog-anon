package anon.ddd.prorammer.dto;

import anon.ddd.prorammer.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String name;
    private Status status;
    //private MultipartFile logo;
}
