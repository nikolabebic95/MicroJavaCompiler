// generated with ast extension for cup
// version 0.8
// 10/0/2018 16:2:30


package rs.ac.bg.etf.pp1.ast;

public class ConditionDerived1 extends Condition {

    private ConditionTerm ConditionTerm;
    private OptionalConditionTerms OptionalConditionTerms;

    public ConditionDerived1 (ConditionTerm ConditionTerm, OptionalConditionTerms OptionalConditionTerms) {
        this.ConditionTerm=ConditionTerm;
        if(ConditionTerm!=null) ConditionTerm.setParent(this);
        this.OptionalConditionTerms=OptionalConditionTerms;
        if(OptionalConditionTerms!=null) OptionalConditionTerms.setParent(this);
    }

    public ConditionTerm getConditionTerm() {
        return ConditionTerm;
    }

    public void setConditionTerm(ConditionTerm ConditionTerm) {
        this.ConditionTerm=ConditionTerm;
    }

    public OptionalConditionTerms getOptionalConditionTerms() {
        return OptionalConditionTerms;
    }

    public void setOptionalConditionTerms(OptionalConditionTerms OptionalConditionTerms) {
        this.OptionalConditionTerms=OptionalConditionTerms;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionTerm!=null) ConditionTerm.accept(visitor);
        if(OptionalConditionTerms!=null) OptionalConditionTerms.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionTerm!=null) ConditionTerm.traverseTopDown(visitor);
        if(OptionalConditionTerms!=null) OptionalConditionTerms.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionTerm!=null) ConditionTerm.traverseBottomUp(visitor);
        if(OptionalConditionTerms!=null) OptionalConditionTerms.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionDerived1(\n");

        if(ConditionTerm!=null)
            buffer.append(ConditionTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalConditionTerms!=null)
            buffer.append(OptionalConditionTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionDerived1]");
        return buffer.toString();
    }
}
