package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class SmartInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
           Map<Long, Integer> smartInputParser_idsAndCountInput = new HashMap<>();

           String[] words = inputLine.split("[ ,.-]");

        for (String word : words) {
            Long id = keywordsToIds.get(word);
            if (id != null) {
                smartInputParser_idsAndCountInput.put(id, smartInputParser_idsAndCountInput.getOrDefault(id, 0) + 2);

            }
        }
        return smartInputParser_idsAndCountInput; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}
