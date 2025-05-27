package toy.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import toy.global.BaseEntity;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // 닉네임
    @NotNull
    private String nickname;

    // 비밀번호
    @NotNull
    private String password;

    // 핸들 (중복 없어야함)
    @Column(unique = true)
    @NotNull
    private String handle;

    // 이메일 (중복 없어야함)
    @Column(unique = true)
    @NotNull
    private String email;

    // 자기소개
    private String explanation;

    @Builder
    public User(String nickname, String password, String handle, String email, String explanation){
        this.nickname = nickname;
        this.password = password;
        this.handle = handle;
        this.email = email;
        this.explanation = explanation;
    }


}
