package boot.start.p0829;

import lombok.Setter;

import java.time.LocalDateTime;

public class Post {
    @Setter
    private Long postIdx;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Post() {}

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public Long getPostIdx() {
        return postIdx;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}



