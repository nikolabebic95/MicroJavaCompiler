// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:31:29


package rs.ac.bg.etf.pp1.ast;

public class FormalParametersListDerived1 extends FormalParametersList {

    private FormalParametersList FormalParametersList;
    private FormalParameter FormalParameter;

    public FormalParametersListDerived1 (FormalParametersList FormalParametersList, FormalParameter FormalParameter) {
        this.FormalParametersList=FormalParametersList;
        if(FormalParametersList!=null) FormalParametersList.setParent(this);
        this.FormalParameter=FormalParameter;
        if(FormalParameter!=null) FormalParameter.setParent(this);
    }

    public FormalParametersList getFormalParametersList() {
        return FormalParametersList;
    }

    public void setFormalParametersList(FormalParametersList FormalParametersList) {
        this.FormalParametersList=FormalParametersList;
    }

    public FormalParameter getFormalParameter() {
        return FormalParameter;
    }

    public void setFormalParameter(FormalParameter FormalParameter) {
        this.FormalParameter=FormalParameter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParametersList!=null) FormalParametersList.accept(visitor);
        if(FormalParameter!=null) FormalParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParametersList!=null) FormalParametersList.traverseTopDown(visitor);
        if(FormalParameter!=null) FormalParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParametersList!=null) FormalParametersList.traverseBottomUp(visitor);
        if(FormalParameter!=null) FormalParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParametersListDerived1(\n");

        if(FormalParametersList!=null)
            buffer.append(FormalParametersList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParameter!=null)
            buffer.append(FormalParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParametersListDerived1]");
        return buffer.toString();
    }
}
