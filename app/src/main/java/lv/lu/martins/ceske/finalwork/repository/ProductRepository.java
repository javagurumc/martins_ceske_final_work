package lv.lu.martins.ceske.finalwork.repository;

import lv.lu.martins.ceske.finalwork.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;
    private final Map<Long, Product> repository = new HashMap<>();

    @Override
    public Long save(Product product) {
        idCounter++;
        product.setId(idCounter);
        repository.put(idCounter, product);
        return idCounter;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Product findById(Long id) {
        return repository.get(id);
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
