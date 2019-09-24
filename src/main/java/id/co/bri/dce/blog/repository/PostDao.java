package id.co.bri.dce.blog.repository;

import id.co.bri.dce.blog.entity.Post;
import id.co.bri.dce.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends CrudRepository<Post, Integer> {
    public List<Post> findByStatus(String status);
    public Page<Post> findByStatus(String status, Pageable pageable);
}
