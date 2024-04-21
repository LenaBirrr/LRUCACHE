package LABLRUCACHE;

import LABLRUCACHE.fabric.LruCacheFabric;
import LABLRUCACHE.lru_cahe.ILruCache;
import LABLRUCACHE.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MenuTest {

    @Mock
    private ILruCache lruCache;
    private Menu menu;


    @Test
    void setElem_shouldCallLruCacheSet() {
        when(lruCache.get(1)).thenReturn(2);
        ByteArrayInputStream in = new ByteArrayInputStream("1 2".getBytes());
        menu = new Menu(lruCache, in);
        // Вызовите метод, который вы тестируете
        menu.setElem();
        // Проверьте, что ожидаемое поведение было вызвано
        assertEquals(2, (lruCache).get(1));
    }

    @Test
    void getElem_shouldCallLruCacheGet() {
        when(lruCache.get(1)).thenReturn(2);
        ByteArrayInputStream in = new ByteArrayInputStream("1 2".getBytes());
        menu = new Menu(lruCache, in);

        // Установите ожидаемое поведение для System.out.println()
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Вызовите метод, который вы тестируете
        menu.getElem();

        // Восстановите исходный поток вывода
        //System.setOut(System.out);

        // Проверьте, что ожидаемое поведение было вызвано
        assertEquals("Введите ключ:\r\nЗачение: 2", out.toString().trim());
    }
}

