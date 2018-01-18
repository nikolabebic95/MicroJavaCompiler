// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:27


package rs.ac.bg.etf.pp1.ast;

public class FormalParametersListDerived1 extends FormalParametersList {

    private FormalParametersListNonEmpty FormalParametersListNonEmpty;

    public FormalParametersListDerived1 (FormalParametersListNonEmpty FormalParametersListNonEmpty) {
        this.FormalParametersListNonEmpty=FormalParametersListNonEmpty;
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.setParent(this);
    }

    public FormalParametersListNonEmpty getFormalParametersListNonEmpty() {
        return FormalParametersListNonEmpty;
    }

    public void setFormalParametersListNonEmpty(FormalParametersListNonEmpty FormalParametersListNonEmpty) {
        this.FormalParametersListNonEmpty=FormalParametersListNonEmpty;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParametersListNonEmpty!=null) FormalParametersListNonEmpty.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParametersListDerived1(\n");

        if(FormalParametersListNonEmpty!=null)
            buffer.append(FormalParametersListNonEmpty.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParametersListDerived1]");
        return buffer.toString();
    }
}
