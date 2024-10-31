package tn.homejek.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;


public interface AttachmentService {
    public void init();

    public String uploadImage(MultipartFile file);

    public void deleteAll();

    public void deleteFile(String name);

}
