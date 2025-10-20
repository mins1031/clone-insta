package tony.splrean.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberTest {

    @Test
    void 회원객체_생성시_가입대기상태로_생성할_수_있다() {
        //given && when
        Member member = new Member("urisegea@naver.com", "Dratini", "mins");

        //then
        assertEquals(MemberStatus.PENDING, member.getStatus()) ;
    }

    @Test
    void 회원객체를_생성자로_생성시_이메일값이_없다면_예외처리를_할_수_있다() {
        //given && when && then
        assertThrows(
                NullPointerException.class,
                () -> new Member(null, "Dratini", "mins")
        );
    }

    @Test
    void 회원객체를_가입완료상태로_변경할_수_있다() {
        //given
        Member member = new Member("urisegea@naver.com", "Dratini", "mins");

        //when
        member.activate();

        //then
        assertEquals(MemberStatus.ACTIVE, member.getStatus()) ;
    }

    @Test
    void 회원객체가_가입대기상태가_아니라면_가입완료상태로_변경할_수_없다() {
        //given && when
        Member member = new Member("urisegea@naver.com", "Dratini", "mins");
        member.activate();

        //then
        assertThrows(
                IllegalStateException.class,
                member::activate
        );
    }

    @Test
    void 회원객체를_탈퇴상태로_변경할_수_있다() {
        Member member = new Member("urisegea@naver.com", "Dratini", "mins");
        member.activate();

        member.deactivate();

        assertEquals(MemberStatus.DEACTIVATED, member.getStatus()) ;
    }

    @Test
    void 회원객체가_가입완료_상태가_아니라면_탈퇴상태로_변경할_수_있다() {
        Member member = new Member("urisegea@naver.com", "Dratini", "mins");

        assertThrows(
                IllegalStateException.class,
                member::deactivate
        );

        member.activate();
        member.deactivate();

        assertThrows(
                IllegalStateException.class,
                member::deactivate
        );
    }
}