// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:28


package rs.ac.bg.etf.pp1.ast;

public class OptionalConditionTermsDerived1 extends OptionalConditionTerms {

    private OptionalConditionTermsStart OptionalConditionTermsStart;
    private Condition Condition;

    public OptionalConditionTermsDerived1 (OptionalConditionTermsStart OptionalConditionTermsStart, Condition Condition) {
        this.OptionalConditionTermsStart=OptionalConditionTermsStart;
        if(OptionalConditionTermsStart!=null) OptionalConditionTermsStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public OptionalConditionTermsStart getOptionalConditionTermsStart() {
        return OptionalConditionTermsStart;
    }

    public void setOptionalConditionTermsStart(OptionalConditionTermsStart OptionalConditionTermsStart) {
        this.OptionalConditionTermsStart=OptionalConditionTermsStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalConditionTermsStart!=null) OptionalConditionTermsStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalConditionTermsStart!=null) OptionalConditionTermsStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalConditionTermsStart!=null) OptionalConditionTermsStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalConditionTermsDerived1(\n");

        if(OptionalConditionTermsStart!=null)
            buffer.append(OptionalConditionTermsStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalConditionTermsDerived1]");
        return buffer.toString();
    }
}
