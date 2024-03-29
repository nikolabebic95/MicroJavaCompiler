// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:22


package rs.ac.bg.etf.pp1.ast;

public class IncrementDecrementDerived1 extends IncrementDecrement {

    private LeftValue LeftValue;

    public IncrementDecrementDerived1 (LeftValue LeftValue) {
        this.LeftValue=LeftValue;
        if(LeftValue!=null) LeftValue.setParent(this);
    }

    public LeftValue getLeftValue() {
        return LeftValue;
    }

    public void setLeftValue(LeftValue LeftValue) {
        this.LeftValue=LeftValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftValue!=null) LeftValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftValue!=null) LeftValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftValue!=null) LeftValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IncrementDecrementDerived1(\n");

        if(LeftValue!=null)
            buffer.append(LeftValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IncrementDecrementDerived1]");
        return buffer.toString();
    }
}
