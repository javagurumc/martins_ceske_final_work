package lv.lu.martins.ceske.finalwork;

import lv.lu.martins.ceske.finalwork.model.Product;
import lv.lu.martins.ceske.finalwork.repository.ProductRepository;
import lv.lu.martins.ceske.finalwork.service.ProductService;
import lv.lu.martins.ceske.finalwork.ui.ConsulUi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Map<Long, Product> repository = new HashMap<>();
        ProductRepository productRepository = new ProductRepository(repository);
        ProductService productService = new ProductService(productRepository);
        Scanner scanner = new Scanner(System.in);

        new ConsulUi(productService, scanner).run();
    }

}
