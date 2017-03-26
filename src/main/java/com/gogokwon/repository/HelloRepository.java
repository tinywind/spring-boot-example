package com.gogokwon.repository;

import com.gogokwon.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author KJShin
 * @since 2017-03-03
 */
public interface HelloRepository extends JpaRepository<Hello, Long>{
}
