package trinh.vo.van.model.dto.response.data;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class Data {
    private String message;

    private Integer status;

    private Object data;


}
