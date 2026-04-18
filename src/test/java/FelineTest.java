import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {


    @Test
    public void getKittensWithParamReturnsSameValue() {
        Feline feline = new Feline();
        int actualCount = feline.getKittens(21);
        assertEquals("Ожидаемое количество котят: 21",21, actualCount);
    }

    @Test
    public void getKittensNoParamReturnsOne() {
        Feline feline = new Feline();
        int actualCount = feline.getKittens();
        assertEquals("Ожидаемое количество котят: 1",1, actualCount);
    }

    @Test
    public void getFamilyReturnsCorrectString() {
        Feline feline = new Feline();
        String actualString = feline.getFamily();
        assertEquals("Ожидаемое значение семейства: Кошачьи","Кошачьи", actualString);
    }

    @Test
    public void eatMeatReturnsCorrectList() throws Exception{
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Ожидаемая еда хищника: Животные, Птицы, Рыба", expectedFood, actualFood);
    }
}
