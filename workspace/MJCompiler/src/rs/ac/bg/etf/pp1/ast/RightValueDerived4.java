// generated with ast extension for cup
// version 0.8
// 16/0/2018 22:14:37


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived4 extends RightValue {

    private PredefinedFunction PredefinedFunction;

    public RightValueDerived4 (PredefinedFunction PredefinedFunction) {
        this.PredefinedFunction=PredefinedFunction;
        if(PredefinedFunction!=null) PredefinedFunction.setParent(this);
    }

    public PredefinedFunction getPredefinedFunction() {
        return PredefinedFunction;
    }

    public void setPredefinedFunction(PredefinedFunction PredefinedFunction) {
        this.PredefinedFunction=PredefinedFunction;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PredefinedFunction!=null) PredefinedFunction.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PredefinedFunction!=null) PredefinedFunction.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PredefinedFunction!=null) PredefinedFunction.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightValueDerived4(\n");

        if(PredefinedFunction!=null)
            buffer.append(PredefinedFunction.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived4]");
        return buffer.toString();
    }
}
