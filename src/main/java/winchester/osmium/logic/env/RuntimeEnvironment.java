package winchester.osmium.logic.env;

import java.util.HashMap;
import java.util.Optional;

public class RuntimeEnvironment {
    HashMap<String, Integer> runtimeVariablesList;
    
    public RuntimeEnvironment() {
        runtimeVariablesList = new HashMap<>();
    }

    public void addVariable(String symbol, int value) {
        runtimeVariablesList.put(symbol, value);
    }

    public Optional<Integer> getVariableValue(String symbol) {
        if (runtimeVariablesList.containsKey(symbol)) {
            return Optional.of(runtimeVariablesList.get(symbol));
        }
        return Optional.empty();
    }

}
