package winchester.osmium.logic.def;

public abstract class SymbolObject {
    protected final String name;

    public SymbolObject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
