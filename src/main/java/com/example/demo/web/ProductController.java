package com.example.demo.web;

import com.example.demo.models.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ManufacturerService manufacturerService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, ManufacturerService manufacturerService, CategoryService categoryService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("productsList",productService.getAllProducts());
        model.addAttribute("categoryList",categoryService.getAll());
        model.addAttribute("manList",manufacturerService.getAll());
        return "products";
    }

    @GetMapping("/{id}")
    public String productDetails(@PathVariable("id") Long id,Model model){
        Product p = productService.getById(id);

        model.addAttribute("name",p.name);
        model.addAttribute("desc",p.desc);
        model.addAttribute("imgUrl",p.imgUrl);
        model.addAttribute("price",p.price);
        model.addAttribute("category",p.categories.get(0).name);
        model.addAttribute("man",p.manufacturers.get(0).name);

        return "product.details";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("categoryList",categoryService.getAll());
        model.addAttribute("manList",manufacturerService.getAll());
        return "products.add";
    }

    @PostMapping("/add")
    public String addProduct(HttpServletRequest request, Model model){
        productService.addNewProduct(request.getParameter("name"),request.getParameter("desc"),
                request.getParameter("img"),Integer.parseInt(request.getParameter("price")),Long.parseLong(request.getParameter("manId")),
                Long.parseLong(request.getParameter("categoryId")));
        return "redirect:/products/";
    }

}
