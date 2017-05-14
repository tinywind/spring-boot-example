package com.gogokwon.repository;

import com.gogokwon.model.Post;
import com.gogokwon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author KJShin
 * @since 2017-03-03
 */
public interface UserRepository extends JpaRepository<User, String>{
    List<User> findByIdAndPassword(String id, String password);
    List<User> findById(String id);
}
