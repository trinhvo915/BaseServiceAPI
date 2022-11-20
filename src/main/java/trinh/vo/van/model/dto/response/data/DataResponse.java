package trinh.vo.van.model.dto.response.data;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class DataResponse {

    private Boolean success;

    private Data data;
}
