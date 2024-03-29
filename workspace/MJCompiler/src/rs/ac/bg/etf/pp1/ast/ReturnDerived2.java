// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:22


package rs.ac.bg.etf.pp1.ast;

public class ReturnDerived2 extends Return {

    private ReturnStart ReturnStart;

    public ReturnDerived2 (ReturnStart ReturnStart) {
        this.ReturnStart=ReturnStart;
        if(ReturnStart!=null) ReturnStart.setParent(this);
    }

    public ReturnStart getReturnStart() {
        return ReturnStart;
    }

    public void setReturnStart(ReturnStart ReturnStart) {
        this.ReturnStart=ReturnStart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnStart!=null) ReturnStart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnStart!=null) ReturnStart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnStart!=null) ReturnStart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnDerived2(\n");

        if(ReturnStart!=null)
            buffer.append(ReturnStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnDerived2]");
        return buffer.toString();
    }
}
