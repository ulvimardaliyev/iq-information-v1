package az.iq.information.v1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryRequestDto {
    @Size(max = 40)
    private String subCategoryName;
}
