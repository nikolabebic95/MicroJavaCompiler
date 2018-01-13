package rs.ac.bg.etf.pp1.Extensions;

import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class ExtendedStruct extends Struct {

    public static final int Bool = 5;

    public ExtendedStruct(int kind) {
        super(kind);
    }

    public ExtendedStruct(int kind, Struct elemType) {
        super(kind, elemType);
    }

    public ExtendedStruct(int kind, SymbolDataStructure members) {
        super(kind, members);
    }
}
