// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:4


package rs.ac.bg.etf.pp1.ast;

public class FormalParametersListNonEmptyDerived1 extends FormalParametersListNonEmpty {

    private FormalParametersListNonEmpty FormalParametersListNonEmpty;
    private FormalParameter FormalParameter;

    public FormalParametersListNonEmptyDerived1 (FormalParametersListNonEmpty FormalParametersListNonEmpty, FormalParameter FormalParameter) {
        this.FormalParametersListNonEmpty=FormalParametersListNonEmpty;
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.setParent(this);
        this.FormalParameter=FormalParameter;
        if(FormalParameter!=null) FormalParameter.setParent(this);
    }

    public FormalParametersListNonEmpty getFormalParametersListNonEmpty() {
        return FormalParametersListNonEmpty;
    }

    public void setFormalParametersListNonEmpty(FormalParametersListNonEmpty FormalParametersListNonEmpty) {
        this.FormalParametersListNonEmpty=FormalParametersListNonEmpty;
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
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.accept(visitor);
        if(FormalParameter!=null) FormalParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.traverseTopDown(visitor);
        if(FormalParameter!=null) FormalParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.traverseBottomUp(visitor);
        if(FormalParameter!=null) FormalParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParametersListNonEmptyDerived1(\n");

        if(FormalParametersListNonEmpty!=null)
            buffer.append(FormalParametersListNonEmpty.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParameter!=null)
            buffer.append(FormalParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParametersListNonEmptyDerived1]");
        return buffer.toString();
    }
}
