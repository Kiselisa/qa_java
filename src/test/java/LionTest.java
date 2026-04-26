import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldThrowExceptionWhenInvalidSex() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Небинарная личность", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(12);
        Lion lion = new Lion("Самец", feline);
        int kittens = lion.getKittens();
        assertEquals("У льва должно быть котят: 12",12, kittens);
    }
    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals("Ожидаемая еда для льва: должна соответствовать рациону Feline", expectedFood, actualFood);
    }

}
