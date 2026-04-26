import com.example.AlexLion;
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    @Test
    public void getFriendsReturnsCorrectList() throws Exception {
        AlexLion alex = new AlexLion(feline);
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        assertEquals("Список друзей Алекса должен быть: зебра Марти, бегемотиха Глория, жираф Мелман", expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals("Алекс живёт в Нью-Йоркском зоопарке","Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsAlwaysZero() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals("У Алекса нет львят",0, alex.getKittens());
    }

    @Test
    public void alexHasMane() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertTrue("У Алекса должна быть грива", alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        AlexLion alex = new AlexLion(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = alex.getFood();
        assertEquals("Ожидаемая еда для Алекса: должна соответствовать рациону Feline", expectedFood, actualFood);
    }
}
