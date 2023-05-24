package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MenuUtilsTest {

    private final Ingredient avocado = new Ingredient("Avocado", new BigDecimal("0.01"), 1000);
    private final Ingredient reis = new Ingredient("Reis", new BigDecimal("0.02"), 2000);
    private final Ingredient lachs = new Ingredient("Lachs", new BigDecimal("0.03"), 3000);

    private final Map<Long, Ingredient> testMenu = Map.of(
            42L, avocado,
            66L, reis,
            17L, lachs);

    @Test
    @DisplayName("should extract only the ingredient names from the Menu")
    void focusOnNames() {
        List<String> expected = List.of("Avocado", "Reis", "Lachs");
        List<String> actual = MenuUtils.focusOnNames(testMenu);

        List<String> expectedSorted = expected.stream().sorted().collect(Collectors.toList());
        List<String> actualSorted = actual.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("should select the ingredient name and invert the passed map, i.e. keys become values and values become keys")
    void focusOnNameAndInvert() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenu);
        Map<String, Long> expected = Map.of(
                "Avocado", 42L,
                "Reis", 66L,
                "Lachs", 17L);
        assertEquals(expected, actual);
    }


    @Test  // gibt an, dass es sich um einen JUnit-Testfall handelt.
    @DisplayName("should return an empty map when input map is empty")
    // Die Methode EmptyInput() ist der eigentliche Testfall, der das erwartete Verhalten der Methode überprüft.
    void focusOnNameAndInvert_EmptyInput() {
    // Zunächst wird eine leere Eingabe-Map namens "emptyMenu" erstellt, indem Collections.emptyMap() aufgerufen wird.
    // Diese Map enthält keine Schlüssel-Wert-Paare.
        Map<Long, Ingredient> emptyMenu = Collections.emptyMap();

    // Dann wird die Methode focusOnNameAndInvert mit der leeren Eingabe-Map aufgerufen
    // und das tatsächliche Ergebnis in der Variable "actual" gespeichert.
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(emptyMenu);

    // Die erwartete Ausgabe ist ebenfalls eine leere Map, die mit Collections.emptyMap() erstellt
    // und in der Variable "expected" gespeichert wird.
        Map<String, Long> expected = Collections.emptyMap();

    // Schließlich wird mit assertEquals(expected, actual) überprüft,
    // ob das tatsächliche Ergebnis der Methode "focusOnNameAndInvert" der erwarteten leeren Map entspricht.
        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("should get the ingredients from the passed menu in the stated quantities of the input map")
    void ingredientsFromIdAndCount() {
        Map<Long, Integer> counts = Map.of(
                66L, 1,
                17L, 2);

        List<Ingredient> expected = List.of(reis, lachs, lachs);
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenu);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test // gibt an, dass es sich um einen JUnit-Testfall handelt.
    @DisplayName("should return an empty list when input maps are empty")
    // Die Methode ingredientsFromIdAndCount_EmptyInput() ist der eigentliche Testfall,
    // der das erwartete Verhalten der Methode überprüft.
    void ingredientsFromIdAndCount_EmptyInput() {

    // Zunächst werden zwei leere Eingabe-Maps erstellt: "emptyCounts" für die Zutaten-IDs und Mengen und "emptyArticles" für die Zutaten selbst.
    // Beide Maps enthalten keine Schlüssel-Wert-Paare.
        Map<Long, Integer> emptyCounts = Collections.emptyMap();
        Map<Long, Ingredient> emptyArticles = Collections.emptyMap();

    // Dann wird die Methode ingredientsFromIdAndCount mit den leeren Eingabe-Maps aufgerufen
    // und das tatsächliche Ergebnis in der Variable "actual" gespeichert.
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(emptyCounts, emptyArticles);

    // Die erwartete Ausgabe ist ebenfalls eine leere Liste, die mit Collections.emptyList() erstellt
    // und in der Variable "expected" gespeichert wird.
        List<Ingredient> expected = Collections.emptyList();

    // Schließlich wird mit assertEquals(expected, actual) überprüft,
    // ob das tatsächliche Ergebnis der Methode "ingredientsFromIdAndCount" der erwarteten leeren Liste entspricht.
        assertEquals(expected, actual);
    }
}
