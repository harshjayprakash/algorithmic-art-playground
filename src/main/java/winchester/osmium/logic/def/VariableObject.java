package winchester.osmium.logic.def;

public class VariableObject<T> extends SymbolObject {
    private T value;

    public VariableObject(String name, T value) {
        super(name);
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("VAR %s = %s]", name, value.toString());
    }
}
