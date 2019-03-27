package at.nacs.shop;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByName(String name);
    List<Item> findByPriceBetween(Double prise1, Double prise2);

}
