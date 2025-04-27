package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

@Test
public void shouldHaveTwoEnumValues() {
    // Проверяем количество элементов в перечислении
    IngredientType[] values = IngredientType.values();
    assertEquals("Должно быть 2 значения в перечислении", 2, values.length);
}

@Test
public void shouldContainSauceValue() {
    // Проверяем наличие значения SAUCE
    assertNotNull("Перечисление должно содержать SAUCE", IngredientType.valueOf("SAUCE"));
    assertEquals("Значение SAUCE должно быть корректным",
            IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
}

@Test
public void shouldContainFillingValue() {
    // Проверяем наличие значения FILLING
    assertNotNull("Перечисление должно содержать FILLING", IngredientType.valueOf("FILLING"));
    assertEquals("Значение FILLING должно быть корректным",
            IngredientType.FILLING, IngredientType.valueOf("FILLING"));
}
}