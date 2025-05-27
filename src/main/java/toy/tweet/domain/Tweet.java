package toy.tweet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.global.BaseEntity;
import toy.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId") @NotNull
    private User user;

    // 내용
    @NotNull
    private String content;

    // user's nickname
    public String getNickname(){
        return user.getNickname();
    }

    // user's handle
    public String getHandle(){
        return user.getHandle();
    }

    @Builder Tweet(User user, String content){
        this.user = user;
        this.content = content;
    }

}
