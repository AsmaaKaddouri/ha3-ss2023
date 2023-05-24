package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> result = new HashMap<>();

        String[] words = inputLine.split("[ ,.-]");

        for (String word : words) {
            Long id = keywordsToIds.get(word);
            if (id != null) {
                result.put(id, result.getOrDefault(id, 0) + 1);

            }
        }
        return result; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}
