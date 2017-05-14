package com.gogokwon.repository;

import com.gogokwon.model.Hello;
import com.gogokwon.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author KJShin
 * @since 2017-03-03
 */
public interface PostRepository extends JpaRepository<Post, Long>{
}
