package winchester.osmium.logic.def;

import java.util.ArrayList;

public class SymbolTable {

    public static SymbolTable instance = new SymbolTable();

    ArrayList<String> functionList = new ArrayList<>() {{
        add("Move"); add("Position");
    }};

    ArrayList<String> constantsList = new ArrayList<>() {{
        add("North"); add("South"); add("East"); add("West");
    }};
    
    private SymbolTable() {
        
    }

    public static SymbolTable getInstance() {
        return instance;
    }

    public String[] getFunctionList() {
        return this.functionList.toArray(new String[0]);
    }

    public String[] getConstantsList() {
        return this.constantsList.toArray(new String[0]);
    }

}
