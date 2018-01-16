package rs.ac.bg.etf.pp1.extensions;

import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class ExtendedStruct extends Struct {

    public static final int Bool = 5;

    private ExtendedStruct parent;

    public ExtendedStruct(int kind) {
        super(kind);
    }

    public ExtendedStruct(int kind, Struct elemType) {
        super(kind, elemType);
    }

    public ExtendedStruct(int kind, SymbolDataStructure members) {
        super(kind, members);
    }

    public ExtendedStruct getParent() {
        return parent;
    }

    public void setParent(ExtendedStruct parent) {
        this.parent = parent;
    }

    @Override
    public boolean assignableTo(Struct dest) {
        if (!super.assignableTo(dest)) {
            ExtendedStruct curr = parent;
            while (curr != null) {
                if (curr.equals(dest)) {
                    return true;
                }
            }

            return false;
        }

        return true;
    }
}
