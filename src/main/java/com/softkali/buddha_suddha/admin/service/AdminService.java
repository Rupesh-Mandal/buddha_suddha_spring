package com.softkali.buddha_suddha.admin.service;

import com.softkali.buddha_suddha.admin.model.*;
import com.softkali.buddha_suddha.admin.repository.AdminRepository;
import com.softkali.buddha_suddha.product.repository.CategoryRepository;
import com.softkali.buddha_suddha.admin.repository.LocationRepository;
import com.softkali.buddha_suddha.product.repository.ProductRepository;
import com.softkali.buddha_suddha.product.model.Category;
import com.softkali.buddha_suddha.product.model.Product;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminService {
    private final ProductRepository productRepository;
    private final LocationRepository locationRepository;
    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;

    public Object deletProduct(Product product) {
        JSONObject jsonObject = new JSONObject();
        productRepository.delete(product);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Deleted");
        return jsonObject;
    }

    public Object getAllProduct(String location) {
        List<Product> productList=productRepository.findByLocation(location).get();
        return productList;
    }

    public Object updateProduct(Product product) {
        JSONObject jsonObject = new JSONObject();
        productRepository.save(product);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Updated");
        return jsonObject;
    }

    public Object addProduct(AddProductModel addProductModel) {
        JSONObject jsonObject = new JSONObject();

            String productId= UUID.randomUUID().toString();
            Product product=new Product(productId, addProductModel.getProductName(), addProductModel.getProductDescription(), addProductModel.getProductRate(), addProductModel.getProductDeliverCharge(),
                    addProductModel.getProductImageLink(), LocalDateTime.now(), addProductModel.getProductType(), addProductModel.getCategory(), addProductModel.getLocation());

            productRepository.save(product);

            jsonObject.put("status", true);
            jsonObject.put("messag", "Successfully Uploaded");
            return jsonObject;

    }

    public Object addLocation(String name) {
        JSONObject jsonObject = new JSONObject();

        boolean isPresent=locationRepository.findByName(name).isPresent();
        if (isPresent){
            jsonObject.put("status", false);
            jsonObject.put("messag", "Location aleady exist");
            return jsonObject;
        }
        Location location=locationRepository.save(new Location(name));
        jsonObject.put("status", true);
        jsonObject.put("messag", "successfull");
        jsonObject.put("data",location);
        return jsonObject;

    }

    public Object deletLocation(Location location) {
        JSONObject jsonObject = new JSONObject();
        locationRepository.delete(location);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Deleted");
        return jsonObject;
    }

    public Object signInAdmin(String mobileNumber, String password) {
        JSONObject jsonObject = new JSONObject();

        Optional<Admin> adminOptional=adminRepository.findByMobileNumber(mobileNumber);
        if (adminOptional.isPresent()){
            if (adminOptional.get().getPassword().equals(password)){
                jsonObject.put("status", true);
                jsonObject.put("messag", "Successfully");
                return jsonObject;
            }else {
                jsonObject.put("status", false);
                jsonObject.put("messag", "invalid password");
                return jsonObject;
            }
        }
        jsonObject.put("status", false);
        jsonObject.put("messag", "Unsuccessfully");
        return jsonObject;
    }

    public Object getAllCategory() {
        return categoryRepository.findAll();
    }

    public Object addCategory(String name) {
        JSONObject jsonObject=new JSONObject();
        if (categoryRepository.findByName(name).isPresent()){
            jsonObject.put("status",false);
            jsonObject.put("message","Category already present");
            return jsonObject;
        }
        return categoryRepository.save(new Category(name));
    }

    public Object getAllLocation() {
        return locationRepository.findAll();
    }
}
