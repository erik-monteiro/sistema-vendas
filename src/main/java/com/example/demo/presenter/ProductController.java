package com.example.demo.presenter;

import com.example.demo.application.AvailableProducts_UC;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
    @Autowired
    private AvailableProducts_UC availableProductsUC;

    @GetMapping
    @CrossOrigin("*")
    public List<Product> getAllAvailableProducts() {
        var list = availableProductsUC.run();
        return list;
    }


}
