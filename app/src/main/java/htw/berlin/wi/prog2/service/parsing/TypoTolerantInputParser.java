package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class TypoTolerantInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> idsAndCountInput= new HashMap<>();

        String[] words = inputLine.split("[ ,.-]");

        for (String word : words) {
            Long id = keywordsToIds.get(word);
            if(id != null) {
                idsAndCountInput.put(id, idsAndCountInput.getOrDefault(id, 0) + 1);

            }
        }
        return idsAndCountInput; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}
