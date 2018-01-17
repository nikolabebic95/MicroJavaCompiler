package rs.ac.bg.etf.pp1.extensions;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.HashMap;

public class ExtendedSymbolTable extends Tab {

    public static final Struct boolType = new ExtendedStruct(ExtendedStruct.Bool);

    private static final HashMap<SyntaxNode, Obj> symbolTableHashMap = new HashMap<>();

    private static final HashMap<SyntaxNode, Scope> scopesHashMap = new HashMap<>();

    private static final HashMap<SyntaxNode, Struct> typesHashMap = new HashMap<>();

    private static final HashMap<SyntaxNode, ExtendedStruct> classesHashMap = new HashMap<>();

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

    public static Obj find(String name, Scope scope) {
        Obj resultObj = null;
        for (Scope s = scope; s != null; s = s.getOuter()) {
            if (s.getLocals() != null) {
                resultObj = s.getLocals().searchKey(name);
                if (resultObj != null) break;
            }
        }
        return (resultObj != null) ? resultObj : noObj;
    }

    public static Obj findInBaseClasses(String name, ExtendedStruct childClass) {
        ExtendedStruct currentClass = childClass;
        while (currentClass != null) {
            Obj ret = currentClass.getMembers().searchKey(name);
            if (ret != null) {
                return ret;
            }

            currentClass = currentClass.getParent();
        }

        return noObj;
    }

    public static Obj insert(int kind, String name, Struct type, int adr) {
        Obj ret = Tab.insert(kind, name, type);
        ret.setAdr(adr);
        return ret;
    }

    public static void insert(SyntaxNode syntaxNode, Obj obj) {
        symbolTableHashMap.put(syntaxNode, obj);
    }

    public static Obj get(SyntaxNode syntaxNode) {
        return symbolTableHashMap.get(syntaxNode);
    }

    public static void insert(SyntaxNode syntaxNode, Scope scope) {
        scopesHashMap.put(syntaxNode, scope);
    }

    public static Scope getScope(SyntaxNode syntaxNode) {
        return scopesHashMap.get(syntaxNode);
    }

    public static void insert(SyntaxNode syntaxNode, Struct type) {
        typesHashMap.put(syntaxNode, type);
    }

    public static Struct getStruct(SyntaxNode syntaxNode) {
        return typesHashMap.get(syntaxNode);
    }

    public static void insertClass(SyntaxNode syntaxNode, ExtendedStruct classStruct) {
        classesHashMap.put(syntaxNode, classStruct);
    }

    public static ExtendedStruct getClassStruct(SyntaxNode syntaxNode) {
        return classesHashMap.get(syntaxNode);
    }
}
