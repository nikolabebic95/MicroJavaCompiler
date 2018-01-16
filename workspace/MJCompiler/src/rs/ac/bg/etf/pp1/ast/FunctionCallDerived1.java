// generated with ast extension for cup
// version 0.8
// 15/0/2018 23:38:22


package rs.ac.bg.etf.pp1.ast;

public class FunctionCallDerived1 extends FunctionCall {

    private FunctionCallStart FunctionCallStart;
    private ActualParametersList ActualParametersList;

    public FunctionCallDerived1 (FunctionCallStart FunctionCallStart, ActualParametersList ActualParametersList) {
        this.FunctionCallStart=FunctionCallStart;
        if(FunctionCallStart!=null) FunctionCallStart.setParent(this);
        this.ActualParametersList=ActualParametersList;
        if(ActualParametersList!=null) ActualParametersList.setParent(this);
    }

    public FunctionCallStart getFunctionCallStart() {
        return FunctionCallStart;
    }

    public void setFunctionCallStart(FunctionCallStart FunctionCallStart) {
        this.FunctionCallStart=FunctionCallStart;
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
        if(FunctionCallStart!=null) FunctionCallStart.accept(visitor);
        if(ActualParametersList!=null) ActualParametersList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FunctionCallStart!=null) FunctionCallStart.traverseTopDown(visitor);
        if(ActualParametersList!=null) ActualParametersList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FunctionCallStart!=null) FunctionCallStart.traverseBottomUp(visitor);
        if(ActualParametersList!=null) ActualParametersList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionCallDerived1(\n");

        if(FunctionCallStart!=null)
            buffer.append(FunctionCallStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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
