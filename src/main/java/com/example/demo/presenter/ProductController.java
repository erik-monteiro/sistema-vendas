package com.example.demo.presenter;

import com.example.demo.application.AvailableProducts;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
    @Autowired
    private AvailableProducts availableProducts;

    @GetMapping
    @CrossOrigin("*")
    public List<Product> getAllAvailableProducts() {
        var list = availableProducts.run();
        return list;
    }


}
