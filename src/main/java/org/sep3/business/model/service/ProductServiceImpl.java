package org.sep3.business.model.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sep3.business.model.domain.Product;
import org.sep3.business.model.persistence.ProductRepository;
import org.sep3.business.model.service.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{

    @NonNull
    private ProductRepository repo;

    @Override
    public ProductDTO addToMenu(ProductDTO dto) {
        Product p = repo.save(new Product(dto.getName(), dto.getPrice()));
        dto.setId(p.getId());
        return dto;
    }

    @Override
    public void removeFromMenu(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ProductDTO> getMenu() {

        return repo.findAll()
                .stream()
                .map(this::dto)
                .collect(Collectors.toList());
    }

    private ProductDTO dto(Product product){

        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }
}

