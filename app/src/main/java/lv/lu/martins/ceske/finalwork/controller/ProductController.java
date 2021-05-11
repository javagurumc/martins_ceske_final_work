package lv.lu.martins.ceske.finalwork.controller;

import lv.lu.martins.ceske.finalwork.model.ProductData;
import lv.lu.martins.ceske.finalwork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductData>> retrieveAll() {
        List<ProductData> result = this.productService.findAll();
        return ResponseEntity.ok(result);
    }
}
