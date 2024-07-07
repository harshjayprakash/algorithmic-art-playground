package winchester.osmium.logic.def;

import java.util.function.Function;

public class FunctionObject extends SymbolObject {
    private final int argumentCount;

    public FunctionObject(String name, int argumentCount) {
        super(name);
        this.argumentCount = argumentCount;
    }

    public int getArgumentCount() {
        return this.argumentCount;
    }

}
