package lv.lu.martins.ceske.finalwork.repository;

import lv.lu.martins.ceske.finalwork.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {

    @InjectMocks
    private ProductRepository victim;

    @Mock
    private Map<Long, Product> repoMock;

    @Test
    public void shouldFindAllProducts() {
        Product orange = new Product();
        Product fish = new Product();

        when(repoMock.values()).thenReturn(Arrays.asList(orange, fish));

        List<Product> result = victim.findAll();
        assertNotNull(result);
        assertTrue(result.contains(orange));
        assertTrue(result.contains(fish));

        verify(repoMock).values();
        verifyNoMoreInteractions(repoMock);
    }

    @Test
    public void shouldFindProductById() {
        Product orange = new Product();
        when(repoMock.get(any())).thenReturn(orange);

        Product result = victim.findById(1L);
        assertEquals(orange, result);

        verify(repoMock).get(1L);
        verifyNoMoreInteractions(repoMock);
    }

    @Test
    public void shouldSaveProduct() {
        Product orange = new Product();

        final Long productId = victim.save(orange);

        assertEquals(productId, orange.getId());
        verify(repoMock).put(productId, orange);
        verifyNoMoreInteractions(repoMock);
    }

    @Test
    public void shouldRemoveProductById() {
        victim.delete(1L);

        verify(repoMock).remove(1L);
        verifyNoMoreInteractions(repoMock);
    }
}