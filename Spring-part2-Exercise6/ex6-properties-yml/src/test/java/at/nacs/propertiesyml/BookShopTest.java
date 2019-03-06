package at.nacs.propertiesyml;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookShopTest {

    @Autowired
    BookShop bookShop;

    @Test
    void getBookQuantity() {
        Map<String, Integer> actual = bookShop.getQuantity();
        assertEquals(3, actual.size());
    }

    @ParameterizedTest
    @CsvSource({
            "Harry Potter, 3",
            "The Foundation,2",
            "The Lord Of The Rings, 2",

    })
    void TestValueExist(String bookName, Integer amount) {
        Map<String, Integer> actual = bookShop.getQuantity();
        assertTrue(actual.containsKey(bookName) && actual.containsValue(amount)); //either this
        assertThat(actual, IsMapContaining.hasEntry(bookName, amount));                   //or this
    }

}