package com.springboot.data.reponsitory;

import com.springboot.data.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentReponsitory extends JpaRepository<Content,String> {
}
