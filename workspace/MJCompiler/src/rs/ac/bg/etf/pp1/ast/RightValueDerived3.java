// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived3 extends RightValue {

    private Allocation Allocation;

    public RightValueDerived3 (Allocation Allocation) {
        this.Allocation=Allocation;
        if(Allocation!=null) Allocation.setParent(this);
    }

    public Allocation getAllocation() {
        return Allocation;
    }

    public void setAllocation(Allocation Allocation) {
        this.Allocation=Allocation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Allocation!=null) Allocation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Allocation!=null) Allocation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Allocation!=null) Allocation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightValueDerived3(\n");

        if(Allocation!=null)
            buffer.append(Allocation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived3]");
        return buffer.toString();
    }
}
