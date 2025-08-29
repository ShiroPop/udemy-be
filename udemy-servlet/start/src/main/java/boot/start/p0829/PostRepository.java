package boot.start.p0829;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {
    private static final ConcurrentHashMap<Long, Post> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0);

    public Post save(Post post) {
        Long id = sequence.getAndIncrement();
        post.setPostIdx(id);
        store.put(id, post);
        return post;
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Post> search(String keyword) {
        List<Post> result = new ArrayList<>();
        for (Post post : store.values()) {
            if (post.getTitle().contains(keyword) || post.getContent().contains(keyword)) {
                result.add(post);
            }
        }
        return result;
    }
}
