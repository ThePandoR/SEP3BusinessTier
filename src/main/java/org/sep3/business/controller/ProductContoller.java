package org.sep3.business.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sep3.business.model.service.ProductService;
import org.sep3.business.model.service.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class ProductContoller {

    @NonNull
    private ProductService service;

    @GetMapping
    public List<ProductDTO> getMenu(){

        return service.getMenu();
    }

    @PostMapping
    public ProductDTO addToMenu(@RequestBody ProductDTO dto){

        System.out.println(dto);

        return service.addToMenu(dto);
    }

    @DeleteMapping("/{id}")
    public void removeFromMenu(@PathVariable Long id){

        service.removeFromMenu(id);
    }
}
