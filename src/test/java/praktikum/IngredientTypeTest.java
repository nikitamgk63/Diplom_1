package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void testEnumValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}