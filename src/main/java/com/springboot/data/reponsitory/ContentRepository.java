package com.springboot.data.reponsitory;

import com.springboot.data.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, String> {
    List<Content> findAll();
}
