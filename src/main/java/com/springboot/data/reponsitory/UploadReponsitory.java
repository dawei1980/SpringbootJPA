package com.springboot.data.reponsitory;

import com.springboot.data.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UploadReponsitory extends JpaRepository<Upload, String> {
    Upload findByContentId(String contentId);
}
