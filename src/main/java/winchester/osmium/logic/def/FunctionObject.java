package winchester.osmium.logic.def;

import java.util.function.Function;

public class FunctionObject<T>{
    private final String symbolName;
    private final int argumentCount;
    private Function<T, Void> action;

    public FunctionObject(String symbolName, int argumentCount) {
        this.symbolName = symbolName;
        this.argumentCount = argumentCount;
        this.action = null;
    }

    public void defineMethod(Function<T, Void> action) {
        this.action = action;
    }

    public void get(T data) {
        if (action == null) {
            System.err.println("Implementation Error: No Function Method Added");
        }
        action.apply(data);
    }

}
