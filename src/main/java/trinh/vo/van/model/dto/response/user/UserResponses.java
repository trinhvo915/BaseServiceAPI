package trinh.vo.van.model.dto.response.user;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponses {
    private String id;

    private String fullName;

    private String username;

    private String email;

    private Date creationDate;
}
