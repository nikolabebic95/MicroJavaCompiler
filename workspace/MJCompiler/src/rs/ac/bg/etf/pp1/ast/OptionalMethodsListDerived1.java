// generated with ast extension for cup
// version 0.8
// 17/0/2018 0:47:21


package rs.ac.bg.etf.pp1.ast;

public class OptionalMethodsListDerived1 extends OptionalMethodsList {

    private MethodsList MethodsList;

    public OptionalMethodsListDerived1 (MethodsList MethodsList) {
        this.MethodsList=MethodsList;
        if(MethodsList!=null) MethodsList.setParent(this);
    }

    public MethodsList getMethodsList() {
        return MethodsList;
    }

    public void setMethodsList(MethodsList MethodsList) {
        this.MethodsList=MethodsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodsList!=null) MethodsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodsList!=null) MethodsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodsList!=null) MethodsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalMethodsListDerived1(\n");

        if(MethodsList!=null)
            buffer.append(MethodsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalMethodsListDerived1]");
        return buffer.toString();
    }
}
