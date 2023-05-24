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
        // List<Ingredient> idAndCount = new ArrayList<>(); erstellt eine leere Liste namens idAndCount,
        // die die Zutaten entsprechend der Anzahl (Menge) enthält.
        List<Ingredient> idAndCount = new ArrayList<>();

        // Die Schleife for (Map.Entry<Long, Integer> entry : idsAndCount.entrySet()) durchläuft die Einträge der Map idsAndCount,
        // die die Zutaten-IDs und die gewünschten Mengen enthält.
        for (Map.Entry<Long, Integer> entry : idsAndCount.entrySet()) {

        // In jedem Schleifendurchlauf werden der Schlüssel (Long id)
        // und der Wert (Integer count) des aktuellen Eintrags abgerufen.
            Long id = entry.getKey();
            Integer count = entry.getValue();

        //  Mit Ingredient ingredient = articles.get(id); wird die entsprechende Zutat
        //  aus der Map articles basierend auf der Zutaten-ID abgerufen.
            Ingredient ingredient = articles.get(id);

        //  Wenn die Zutat (ingredient) nicht null ist, d.h. wenn sie in der Map articles vorhanden ist,
        //  wird eine innere Schleife gestartet. Diese Schleife fügt die Zutat count-mal zur Liste idAndCount hinzu.
            if (ingredient != null) {
                for (int i = 0; i < count; i++) {
                    idAndCount.add(ingredient);

                }
            }
        }
        // Nachdem alle Einträge in der Map idsAndCount verarbeitet wurden,
        // wird die Liste idAndCount als Ergebnis zurückgegeben.
        return idAndCount; // TODO hier implementieren und korrekte Ergebnis-Liste zurückgeben
    }
}
