// generated with ast extension for cup
// version 0.8
// 8/0/2018 2:11:43


package rs.ac.bg.etf.pp1.ast;

public class MethodsListDerived1 extends MethodsList {

    private MethodsList MethodsList;
    private Method Method;

    public MethodsListDerived1 (MethodsList MethodsList, Method Method) {
        this.MethodsList=MethodsList;
        if(MethodsList!=null) MethodsList.setParent(this);
        this.Method=Method;
        if(Method!=null) Method.setParent(this);
    }

    public MethodsList getMethodsList() {
        return MethodsList;
    }

    public void setMethodsList(MethodsList MethodsList) {
        this.MethodsList=MethodsList;
    }

    public Method getMethod() {
        return Method;
    }

    public void setMethod(Method Method) {
        this.Method=Method;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodsList!=null) MethodsList.accept(visitor);
        if(Method!=null) Method.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodsList!=null) MethodsList.traverseTopDown(visitor);
        if(Method!=null) Method.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodsList!=null) MethodsList.traverseBottomUp(visitor);
        if(Method!=null) Method.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodsListDerived1(\n");

        if(MethodsList!=null)
            buffer.append(MethodsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Method!=null)
            buffer.append(Method.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodsListDerived1]");
        return buffer.toString();
    }
}
