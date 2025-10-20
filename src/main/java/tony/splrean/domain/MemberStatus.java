package tony.splrean.domain;

public enum MemberStatus {
    PENDING("가입 대기"),
    ACTIVE("가입 완료"),
    DEACTIVATED("탈퇴"),
    ;

    private final String desc;

    MemberStatus(String desc) {
        this.desc = desc;
    }

    public boolean isPending() {
        return MemberStatus.PENDING.equals(this);
    }

    public boolean isActive() {
        return MemberStatus.ACTIVE.equals(this);
    }
}
