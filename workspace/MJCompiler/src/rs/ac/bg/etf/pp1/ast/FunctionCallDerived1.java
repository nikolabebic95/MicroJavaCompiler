// generated with ast extension for cup
// version 0.8
// 10/0/2018 16:2:30


package rs.ac.bg.etf.pp1.ast;

public class FunctionCallDerived1 extends FunctionCall {

    private String I1;
    private ActualParametersList ActualParametersList;

    public FunctionCallDerived1 (String I1, ActualParametersList ActualParametersList) {
        this.I1=I1;
        this.ActualParametersList=ActualParametersList;
        if(ActualParametersList!=null) ActualParametersList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ActualParametersList getActualParametersList() {
        return ActualParametersList;
    }

    public void setActualParametersList(ActualParametersList ActualParametersList) {
        this.ActualParametersList=ActualParametersList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParametersList!=null) ActualParametersList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParametersList!=null) ActualParametersList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParametersList!=null) ActualParametersList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionCallDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ActualParametersList!=null)
            buffer.append(ActualParametersList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionCallDerived1]");
        return buffer.toString();
    }
}
