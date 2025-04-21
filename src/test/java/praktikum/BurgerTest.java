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
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("standard bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Проверка установки булочки", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue("Проверка добавления ингредиента", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse("Проверка удаления ингредиента", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Проверка перемещения ингредиента", ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        float expectedPrice = 2 * 100f + 50f;
        assertEquals("Проверка расчета цены", expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceiptContainsBunName() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        burger.setBuns(bun);

        String receipt = burger.getReceipt();
        assertTrue("Проверка наличия названия булочки в рецепте", receipt.contains("black bun"));
    }

    @Test
    public void testGetReceiptContainsIngredientName() {
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();
        assertTrue("Проверка наличия названия ингредиента в рецепте", receipt.contains("hot sauce"));
    }

    @Test
    public void testGetReceiptContainsIngredientType() {
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("sauce");
        ;
        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();
        assertTrue("Проверка наличия типа ингредиента в рецепте", receipt.contains("sauce"));
    }
}