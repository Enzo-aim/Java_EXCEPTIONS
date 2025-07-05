import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();
    Product product = new Product(5, "Хлеб", 45);


    @Test
    public void testPassRemoveProduct() throws AlreadyExistsException {
        shopRepository.add(product);
        Product[] expected = {};
        Product[] actual = shopRepository.removeById(5);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(4);
        });
    }

    @Test
    public void testPassAddProduct() throws AlreadyExistsException {
        Product[] expected = {product};
        Product[] actual = shopRepository.add(product);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testAlreadyAddProduct() throws AlreadyExistsException {
        shopRepository.add(product);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product);
        });
    }


}
