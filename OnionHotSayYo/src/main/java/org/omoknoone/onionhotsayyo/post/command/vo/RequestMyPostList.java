package org.omoknoone.onionhotsayyo.post.command.vo;

public class RequestMyPostList {

    private final String memberId;

    public RequestMyPostList(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "RequestMyPosts{" +
                "memberId='" + memberId + '\'' +
                '}';
    }
}
