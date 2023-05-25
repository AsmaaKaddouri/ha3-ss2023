package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> countingInputParser_idsAndCountInput = new HashMap<>();

        String[] words = inputLine.split("[ ,.-]");

        for (String word : words) {
            Long id = keywordsToIds.get(word);
            if (id != null) {
                countingInputParser_idsAndCountInput.put(id, countingInputParser_idsAndCountInput .getOrDefault(id, 0) + 1);

            }
        }
        return countingInputParser_idsAndCountInput ; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}
