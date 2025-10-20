package tony.splrean.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.state;

@Getter
@ToString
public class Member {
    private String email;

    private String nickname;

    private String passwordHash;

    private MemberStatus status;

    public Member(
            String email,
            String nickname,
            String passwordHash
    ) {
        this.email = requireNonNull(email);
        this.nickname = requireNonNull(nickname);
        this.passwordHash = requireNonNull(passwordHash);

        this.status = MemberStatus.PENDING;
    }

    public void activate() {
        state(this.status.isPending(), "가입대기 상태가 아닌 회원이 가입완료 상태로 변경을 시도했습니다");

        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        state(this.status.isActive(), "<UNK> <UNK> <UNK> <UNK> <UNK> <UNK>");

        this.status = MemberStatus.DEACTIVATED;
    }
}
