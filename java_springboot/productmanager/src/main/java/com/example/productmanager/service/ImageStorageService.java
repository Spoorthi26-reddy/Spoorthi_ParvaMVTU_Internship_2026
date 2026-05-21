package com.example.productmanager.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class ImageStorageService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    public String save(MultipartFile file) throws IOException {

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFileName = file.getOriginalFilename();

        String filename =
                UUID.randomUUID() + "_" + originalFileName;

        Path targetPath = uploadPath.resolve(filename);

        Files.copy(
                file.getInputStream(),
                targetPath,
                StandardCopyOption.REPLACE_EXISTING
        );

        return "/" + uploadDir + "/" + filename;
    }

    public void delete(String imagePath) throws IOException {

        if (imagePath == null || imagePath.isBlank()) {
            return;
        }

        Path path = Paths.get(
                imagePath.startsWith("/")
                        ? imagePath.substring(1)
                        : imagePath
        );

        Files.deleteIfExists(path);
    }
}