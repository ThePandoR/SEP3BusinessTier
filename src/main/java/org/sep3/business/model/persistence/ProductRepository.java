package org.sep3.business.model.persistence;

import org.sep3.business.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
