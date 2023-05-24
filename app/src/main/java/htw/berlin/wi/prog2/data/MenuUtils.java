package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuUtils {

    public static List<String> focusOnNames(Map<Long, Ingredient> articles) {
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles.values()) names.add(art.getName());
        return names;
    }

    public static Map<String, Long> focusOnNameAndInvert(Map<Long, Ingredient> articles) {
        // Diese Map wird verwendet, um den invertierten Schlüssel-Wert-Zuordnungen zu speichern
        HashMap<String, Long> nameAndInvert = new HashMap<>();

        // Die Methode durchläuft eine Schleife über die Einträge der übergegebenen Map "articles"
        // mithilfe der "entrySet()" Methode
        // Für jeden Eintrag wird der Schlüssel(Key) als "Long" und der Wert(Value) als "Ingredient" zugewiesen

        for (Map.Entry<Long, Ingredient> entry : articles.entrySet()) {
            Ingredient ingredient = entry.getValue();

        // Aus dem "Ingredient" wird der Name der Zutat extrahiert und in der Variablen"name" gespeichert
            String name = ingredient.getName();

        // Der ursprüngliche Schlüssel (vom Typ "Long") wird in der Variablen "value" gespeichert
            Long value = entry.getKey();

        // Die invertierte Zuordnung wird zur Map "nameAndInvert" hinzugefügt, indem der Name der Zutat als Schlüssel
        // und der ursprüngliche Schlüssel als Wert verwendet wird
            nameAndInvert.put(name, value);

        }
        // Am Ende der Schleife wird die fertig aufgebaute Map "nameAndInvert" zurückgegeben.
        return nameAndInvert; // TODO hier implementieren und korrekte Ergebnis-Map zurückgeben
    }

    public static List<Ingredient> ingredientsFromIdAndCount(Map<Long, Integer> idsAndCount, Map<Long, Ingredient> articles) {
        return List.of(); // TODO hier implementieren und korrekte Ergebnis-Liste zurückgeben
    }
}
