// generated with ast extension for cup
// version 0.8
// 17/0/2018 0:47:22


package rs.ac.bg.etf.pp1.ast;

public class FactorDerived1 extends Factor {

    private DummyFactorStart DummyFactorStart;
    private RightValue RightValue;

    public FactorDerived1 (DummyFactorStart DummyFactorStart, RightValue RightValue) {
        this.DummyFactorStart=DummyFactorStart;
        if(DummyFactorStart!=null) DummyFactorStart.setParent(this);
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
    }

    public DummyFactorStart getDummyFactorStart() {
        return DummyFactorStart;
    }

    public void setDummyFactorStart(DummyFactorStart DummyFactorStart) {
        this.DummyFactorStart=DummyFactorStart;
    }

    public RightValue getRightValue() {
        return RightValue;
    }

    public void setRightValue(RightValue RightValue) {
        this.RightValue=RightValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DummyFactorStart!=null) DummyFactorStart.accept(visitor);
        if(RightValue!=null) RightValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DummyFactorStart!=null) DummyFactorStart.traverseTopDown(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DummyFactorStart!=null) DummyFactorStart.traverseBottomUp(visitor);
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDerived1(\n");

        if(DummyFactorStart!=null)
            buffer.append(DummyFactorStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDerived1]");
        return buffer.toString();
    }
}
