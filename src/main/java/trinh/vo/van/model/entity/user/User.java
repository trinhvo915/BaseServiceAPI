package trinh.vo.van.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import trinh.vo.van.model.entity.AuditedEntity;
import trinh.vo.van.model.entity.enums.GenderUser;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "Users")
public class User extends AuditedEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    private String email;

    @Size(max = 50)
    private String fullName;

    private LocalDate birthday;

    private GenderUser genderUser;

    private String address;

    @Size(max = 20)
    private String mobile;

    @Column(columnDefinition="TEXT")
    private String about;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "UserInRole",
            joinColumns = {@JoinColumn(name = "UserId")},
            inverseJoinColumns = {@JoinColumn(name = "RoleId")}
    )
    Set<Role> roles = new HashSet<>();

}
