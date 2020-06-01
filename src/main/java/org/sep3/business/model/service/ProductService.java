package org.sep3.business.model.service;

import org.sep3.business.model.domain.Product;
import org.sep3.business.model.service.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO addToMenu(ProductDTO dto);
    void removeFromMenu(Long id);
    List<ProductDTO> getMenu();
}
