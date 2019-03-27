package at.nacs.shop;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ShopRunner {

    @Bean
    ApplicationRunner runner(List<Item> items, ItemRepository repository) {
        return args -> {

            repository.deleteAll();

            List<Item> itemsInShop = repository.saveAll(items);
            itemsInShop.forEach(System.out::println);

            List<Item> sofa = repository.findByName("sofa");
            sofa.forEach(System.out::println);


            List<Item> byPriceBetween = repository.findByPriceBetween(50.0, 100.0);
            byPriceBetween.forEach(System.out::println);

            System.out.println("--- BY ID ---");
            List<Item> all = repository.findAll();
            String id = all.get(0).getId();
            Optional<Item> byId = repository.findById(id);
            System.out.println(byId.get());

        };
    }
}
