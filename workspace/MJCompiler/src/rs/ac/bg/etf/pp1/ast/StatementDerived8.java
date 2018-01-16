// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived8 extends Statement {

    private BuiltInFunction BuiltInFunction;

    public StatementDerived8 (BuiltInFunction BuiltInFunction) {
        this.BuiltInFunction=BuiltInFunction;
        if(BuiltInFunction!=null) BuiltInFunction.setParent(this);
    }

    public BuiltInFunction getBuiltInFunction() {
        return BuiltInFunction;
    }

    public void setBuiltInFunction(BuiltInFunction BuiltInFunction) {
        this.BuiltInFunction=BuiltInFunction;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BuiltInFunction!=null) BuiltInFunction.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BuiltInFunction!=null) BuiltInFunction.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BuiltInFunction!=null) BuiltInFunction.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived8(\n");

        if(BuiltInFunction!=null)
            buffer.append(BuiltInFunction.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived8]");
        return buffer.toString();
    }
}
