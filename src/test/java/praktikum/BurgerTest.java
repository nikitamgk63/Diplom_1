package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock private Bun bun;
    @Mock private Ingredient ingredient1;
    @Mock private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        float expectedPrice = 2 * 100f + 50f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("black bun"));
        assertTrue(receipt.contains("hot sauce"));
        assertTrue(receipt.contains("sauce"));
    }
}