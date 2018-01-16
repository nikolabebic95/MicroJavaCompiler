// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:2


package rs.ac.bg.etf.pp1.ast;

public class ConditionTermDerived1 extends ConditionTerm {

    private ConditionFactor ConditionFactor;
    private OptionalConditionFactors OptionalConditionFactors;

    public ConditionTermDerived1 (ConditionFactor ConditionFactor, OptionalConditionFactors OptionalConditionFactors) {
        this.ConditionFactor=ConditionFactor;
        if(ConditionFactor!=null) ConditionFactor.setParent(this);
        this.OptionalConditionFactors=OptionalConditionFactors;
        if(OptionalConditionFactors!=null) OptionalConditionFactors.setParent(this);
    }

    public ConditionFactor getConditionFactor() {
        return ConditionFactor;
    }

    public void setConditionFactor(ConditionFactor ConditionFactor) {
        this.ConditionFactor=ConditionFactor;
    }

    public OptionalConditionFactors getOptionalConditionFactors() {
        return OptionalConditionFactors;
    }

    public void setOptionalConditionFactors(OptionalConditionFactors OptionalConditionFactors) {
        this.OptionalConditionFactors=OptionalConditionFactors;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFactor!=null) ConditionFactor.accept(visitor);
        if(OptionalConditionFactors!=null) OptionalConditionFactors.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactor!=null) ConditionFactor.traverseTopDown(visitor);
        if(OptionalConditionFactors!=null) OptionalConditionFactors.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactor!=null) ConditionFactor.traverseBottomUp(visitor);
        if(OptionalConditionFactors!=null) OptionalConditionFactors.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionTermDerived1(\n");

        if(ConditionFactor!=null)
            buffer.append(ConditionFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalConditionFactors!=null)
            buffer.append(OptionalConditionFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionTermDerived1]");
        return buffer.toString();
    }
}
