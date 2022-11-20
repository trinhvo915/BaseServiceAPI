package trinh.vo.van.model.dto.response.user;

import lombok.*;
import trinh.vo.van.model.entity.user.User;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserResponses {
    private String id;

    private String fullName;

    private String userName;

    private String email;

    private Date creationDate;

    public static UserResponses fromUser(User user) {
        return UserResponses.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .creationDate(user.getCreationTime())
                .build();
    }
}
