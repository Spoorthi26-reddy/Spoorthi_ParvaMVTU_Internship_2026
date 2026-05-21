package com.example.productmanager.service;

import com.example.productmanager.entity.Product;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final ImageStorageService imageStorage;

    public ProductService(
            ProductRepository repo,
            ImageStorageService imageStorage) {

        this.repo = repo;
        this.imageStorage = imageStorage;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    public List<Product> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    public Product save(
            Product product,
            MultipartFile imageFile) throws IOException {

        if (imageFile != null &&
                !imageFile.isEmpty()) {

            String path = imageStorage.save(imageFile);

            product.setImagePath(path);
        }

        return repo.save(product);
    }

    public Product update(
            Long id,
            Product updated,
            MultipartFile imageFile) throws IOException {

        Product existing = findById(id);

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());

        if (imageFile != null &&
                !imageFile.isEmpty()) {

            imageStorage.delete(existing.getImagePath());

            String newPath =
                    imageStorage.save(imageFile);

            existing.setImagePath(newPath);
        }

        return repo.save(existing);
    }

    public void delete(Long id) throws IOException {

        Product product = findById(id);

        imageStorage.delete(product.getImagePath());

        repo.deleteById(id);
    }
}