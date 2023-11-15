package com.example.demo.infra;

import com.example.demo.domain.IRepProducts;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class RepProductsJPA implements IRepProducts
{
    private IRepProductsJPA iRepProductsJPA;

    @Autowired
    public RepProductsJPA(IRepProductsJPA iRepProductsJPA) {
        this.iRepProductsJPA = iRepProductsJPA;
    }

    @Override
    public void save(Product p) {
        iRepProductsJPA.save(p);
    }

    @Override
    public List<Product> all() {
        return iRepProductsJPA.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return iRepProductsJPA.findById(productId).orElse(null);
    }

}
