package com.softkali.buddha_suddha.product.controller;

import com.softkali.buddha_suddha.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "get_all_product")
    public Object getAllProoductSeller(@RequestParam("location") String location){
        return productService.getAllProduct(location);
    }
    @GetMapping(path = "getAllCategory")
    public Object getAllCategory(){
        return productService.getAllCategory();
    }
    @PostMapping(path = "findByProductCategory")
    public Object productCategory(@RequestParam("productCategory") String productCategory){
        return productService.productCategory(productCategory);
    }

    @PostMapping(path = "loadSearch")
    public Object loadSearch(@RequestParam("key") String key){
        return productService.loadSearch(key);
    }

}
