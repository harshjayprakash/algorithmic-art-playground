package winchester.osmium.logic.env;

import winchester.osmium.logic.def.VariableObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class RuntimeEnvironment {
    ArrayList<VariableObject<Integer>> runtimeVariables;
    
    public RuntimeEnvironment() {
        this.runtimeVariables = new ArrayList<>();
    }

    public void addOrUpdateVariable(String symbol, int value) {
        for (VariableObject<Integer> variable : runtimeVariables) {
            if (variable.getName().equalsIgnoreCase(symbol)) {
                variable.setValue(value);
                return;
            }
        }
        this.runtimeVariables.add(new VariableObject<>(symbol, value));
    }

    public Optional<Integer> getVariableValue(String symbol) {
        for (VariableObject<Integer> variable : runtimeVariables) {
            if (variable.getName().equalsIgnoreCase(symbol)) {
                return Optional.of(variable.getValue());
            }
        }
        return Optional.empty();
    }
    

}
