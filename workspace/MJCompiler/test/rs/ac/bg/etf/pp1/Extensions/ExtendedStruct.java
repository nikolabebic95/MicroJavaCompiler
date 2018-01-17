package rs.ac.bg.etf.pp1.extensions;

import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class ExtendedStruct extends Struct {

    public static final int Bool = 5;

    private ExtendedStruct parent;

    private int virtualTablePointer;

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

    public int getVirtualTablePointer() {
        return virtualTablePointer;
    }

    public void setVirtualTablePointer(int virtualTablePointer) {
        this.virtualTablePointer = virtualTablePointer;
    }

    @Override
    public boolean assignableTo(Struct dest) {
        if (getKind() == Struct.Class) {
            ExtendedStruct curr = this;
            while (curr != null) {
                if (curr.equals(dest)) {
                    return true;
                }

                curr = curr.getParent();
            }

            return false;
        } else {
            return super.assignableTo(dest);
        }
    }
}
