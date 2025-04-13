import com.example.duanbanqaotest.Products;
import com.example.duanbanqaotest.ProductsService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsTest {
    private ProductsService productsService = new ProductsService();

    @Test
    void update() {
        Products product = new Products(1, "Laptop Dell XPS 13", "sieu May Tinh", 7.8f, 6, LocalDateTime.now());
        productsService.update(product);

        Products updatedProduct = productsService.findById(1);
        assertEquals("Laptop Dell XPS 13", updatedProduct.getName());
    }

    @Test
    void updateV1() {
        Products product = new Products(1, "MacBook Pro", "sieu May Tinh1", 5.5f, 7, LocalDateTime.now());
        productsService.update(product);

        Products updatedProduct = productsService.findById(1);
        assertEquals("MacBook Pro", updatedProduct.getName());
    }

    @Test
    void updateV2() {
        assertThrows(IllegalArgumentException.class, () ->
                productsService.update(new Products(2, "", "Laptop HP", 0.2f, 4, LocalDateTime.now()))
        );
    }

    @Test
    void updateV3() {
        assertThrows(IllegalArgumentException.class, () ->
                productsService.update(new Products(3, "", null, 7.8f, 5, null))
        );
    }

    @Test
    void updateV4() {
        assertThrows(IllegalArgumentException.class, () ->
                productsService.update(new Products(4, "", "Vua May Tinh", null, 9, LocalDateTime.now()))
        );
    }

    @Test
    void updateV5() {
        assertThrows(IllegalArgumentException.class, () ->
                productsService.update(new Products(5, "MacBook arie", "VUA Máy Sieu", null, null, LocalDateTime.now()))
        );
    }

    @Test
    void updateV6() {
        assertThrows(IllegalArgumentException.class, () ->
                productsService.update(new Products(6, "Cinaemar", null, 2.3f, 6, null))
        );
    }
}
