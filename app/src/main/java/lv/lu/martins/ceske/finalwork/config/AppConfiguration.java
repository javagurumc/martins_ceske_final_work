package lv.lu.martins.ceske.finalwork.config;

import lv.lu.martins.ceske.finalwork.model.Product;
import lv.lu.martins.ceske.finalwork.repository.ProductRepository;
import lv.lu.martins.ceske.finalwork.service.ProductService;
import lv.lu.martins.ceske.finalwork.ui.ConsulUi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Configuration
public class AppConfiguration {

    @Bean
    public Map<Long, Product> repository(){
        return new HashMap<>();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository(repository());
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean
    public ConsulUi consulUi(){
        return new ConsulUi(productService(), scanner());
    }

}
