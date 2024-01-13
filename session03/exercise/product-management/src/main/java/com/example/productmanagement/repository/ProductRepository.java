package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static final List<Product> PRODUCT_LIST = new ArrayList<>();
    static {
        PRODUCT_LIST.add(new Product(1,"condom", 50, "Used to prevent unwanted pregnancy", "Durex"));
        PRODUCT_LIST.add(new Product(2,"car", 5000, "Audi Q7 luxury", "Audi"));
        PRODUCT_LIST.add(new Product(3,"Iphone 15 pro max", 1200, "Full box", "Iphone"));
        PRODUCT_LIST.add(new Product(4,"condom", 50, "Samsung galaxy note 5 like new", "Samsung"));
        PRODUCT_LIST.add(new Product(5,"MB S500", 50, "May bach S500 luxury", "Mercedes"));
    }
    @Override
    public List<Product> findAll() {
        return PRODUCT_LIST;
    }

    @Override
    public void add(Product product) {
        PRODUCT_LIST.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p :PRODUCT_LIST) {
            if (p.getId() == product.getId()) {
                p.setId(product.getId());
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setProducer(product.getProducer());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product p :PRODUCT_LIST) {
            if (p.getId() == id) {
                PRODUCT_LIST.remove(p);
                return;
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product p :PRODUCT_LIST) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String keyWord) {
        List<Product> productList = new ArrayList<>();
        for (Product p :PRODUCT_LIST) {
            if (p.getName().toLowerCase().contains(keyWord.toLowerCase())) {
                productList.add(p);
            }
        }
        return productList;
    }
}
