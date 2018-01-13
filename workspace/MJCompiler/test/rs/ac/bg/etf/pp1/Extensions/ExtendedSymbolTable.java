package rs.ac.bg.etf.pp1.Extensions;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class ExtendedSymbolTable extends Tab {

    public static final Struct boolType = new ExtendedStruct(ExtendedStruct.Bool);

    public static void init() {
        // No other way to initialize the currentLevel field
        Tab.init();

        // Initialize universe scope
        Tab.currentScope = new Scope(null);
        Scope universe = Tab.currentScope;

        // Add Basic types
        // Nulltype is not needed, since there is no way to create objects of this type explicitly
        // The only way to create null objects is to create a class object and initialize it with the null constant
        universe.addToLocals(new Obj(Obj.Type, "int", intType));
        universe.addToLocals(new Obj(Obj.Type, "char", charType));
        universe.addToLocals(new Obj(Obj.Type, "bool", boolType));

        // Add predefined null consntant
        universe.addToLocals(new Obj(Obj.Con, "null", nullType, 0, 0));

        // Add predefined eol constant
        universe.addToLocals(new Obj(Obj.Con, "eol", charType, '\n', 0));

        // Add the ord predefined method
        universe.addToLocals(ordObj = new Obj(Obj.Meth, "ord", intType, 0, 1));
        openScope();
        currentScope.addToLocals(new Obj(Obj.Var, "character", charType, 0, 1));
        chrObj.setLocals(currentScope.getLocals());
        closeScope();

        // Add the chr predefined method
        universe.addToLocals(chrObj = new Obj(Obj.Meth, "chr", charType, 0, 1));
        openScope();
        currentScope.addToLocals(new Obj(Obj.Var, "value", intType, 0, 1));
        chrObj.setLocals(currentScope.getLocals());
        closeScope();

        // Add the len predefined method
        universe.addToLocals(lenObj = new Obj(Obj.Meth, "len", intType, 0, 1));
        openScope();
        currentScope.addToLocals(new Obj(Obj.Var, "array", new Struct(Struct.Array, noType), 0, 1));
        lenObj.setLocals(currentScope.getLocals());
        closeScope();
    }

    public static void dump() {
        Tab.dump(new ExtendedDumpSymbolTableVisitor());
    }

    public static Obj findInCurrentScope(String name) {
        Obj ret = null;
        if (currentScope.getLocals() != null) {
            ret = currentScope.getLocals().searchKey(name);
        }

        return ret == null ? noObj : ret;
    }

    public static Obj insert(int kind, String name, Struct type, int adr) {
        Obj ret = Tab.insert(kind, name, type);
        ret.setAdr(adr);
        return ret;
    }

    public static Obj insertMethod(String name, Struct type, int numOfFormalParams) {
        Obj ret = Tab.insert(Obj.Meth, name, type);
        ret.setLevel(numOfFormalParams);
        return ret;
    }
}
