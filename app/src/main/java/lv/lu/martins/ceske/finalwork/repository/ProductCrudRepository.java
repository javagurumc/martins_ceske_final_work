package lv.lu.martins.ceske.finalwork.repository;

import lv.lu.martins.ceske.finalwork.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Long> {
}
