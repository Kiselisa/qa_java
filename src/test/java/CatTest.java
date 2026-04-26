import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsCorrectString() {
        Cat cat = new Cat(feline);
        assertEquals("Кошка должна говорить: Мяу","Мяу", cat.getSound());

    }
    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals("Ожидаемая еда для кота: должна соответствовать рациону Feline", expectedFood, actualFood);
    }
}
