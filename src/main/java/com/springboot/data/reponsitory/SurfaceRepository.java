package com.springboot.data.reponsitory;

import com.springboot.data.entity.Surface;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SurfaceRepository extends JpaRepository<Surface, String> {
    List<Surface> findAll();

    Surface findBySurfaceId(String surfaceId);
}
