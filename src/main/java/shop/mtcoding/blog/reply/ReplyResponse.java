package shop.mtcoding.blog.reply;


import lombok.Data;

public class ReplyResponse {
    @Data
    public static class DetailDTO {
        private Integer id;
        private String comment;
        private Integer userId;
        private String username;
        private Boolean owner;

        public DetailDTO(Reply reply,int sessionUserId) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId(); //lazy loading 안됨
            this.username = reply.getUser().getUsername(); // lazy loading 안됨(user가 영속화 되어있음)
            this.owner = reply.getUser().getId() == sessionUserId;
        }
    }

    @Data
    public static class DTO {
        private Integer replyId;
        private Integer userId;
        private Integer boardId;
        private String comment;

        public DTO(Reply reply) {
            this.boardId = reply.getBoard().getId();
            this.comment = reply.getComment();
            this.replyId = reply.getId();
            this.userId = reply.getUser().getId();

        }
    }
}
