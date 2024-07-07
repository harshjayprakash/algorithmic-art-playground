package winchester.osmium.logic.def;

import java.util.ArrayList;

public class SymbolTable {
    public static SymbolTable instance = new SymbolTable();

    private final ArrayList<FunctionObject> functionList = new ArrayList<>() {{
        add(new FunctionObject("Move", 2));
        add(new FunctionObject("Position", 2));
        add(new FunctionObject("Compass", 1));
    }};

    private final ArrayList<VariableObject<Integer>> constantsList = new ArrayList<>() {{
        add(new VariableObject<>("North", 0));
        add(new VariableObject<>("East", 1));
        add(new VariableObject<>("South", 2));
        add(new VariableObject<>("West", 3));
    }};
    
    private SymbolTable() { }

    public static SymbolTable getInstance() {
        return instance;
    }

    public ArrayList<FunctionObject> getFunctionList() {
        return this.functionList;
    }

    public ArrayList<VariableObject<Integer>> getConstantsList() {
        return this.constantsList;
    }
}
