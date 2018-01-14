// generated with ast extension for cup
// version 0.8
// 14/0/2018 2:25:51


package rs.ac.bg.etf.pp1.ast;

public class OptionalConditionFactorTokensDerived1 extends OptionalConditionFactorTokens {

    private RelationalOperator RelationalOperator;
    private ConditionFactor ConditionFactor;

    public OptionalConditionFactorTokensDerived1 (RelationalOperator RelationalOperator, ConditionFactor ConditionFactor) {
        this.RelationalOperator=RelationalOperator;
        if(RelationalOperator!=null) RelationalOperator.setParent(this);
        this.ConditionFactor=ConditionFactor;
        if(ConditionFactor!=null) ConditionFactor.setParent(this);
    }

    public RelationalOperator getRelationalOperator() {
        return RelationalOperator;
    }

    public void setRelationalOperator(RelationalOperator RelationalOperator) {
        this.RelationalOperator=RelationalOperator;
    }

    public ConditionFactor getConditionFactor() {
        return ConditionFactor;
    }

    public void setConditionFactor(ConditionFactor ConditionFactor) {
        this.ConditionFactor=ConditionFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RelationalOperator!=null) RelationalOperator.accept(visitor);
        if(ConditionFactor!=null) ConditionFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RelationalOperator!=null) RelationalOperator.traverseTopDown(visitor);
        if(ConditionFactor!=null) ConditionFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RelationalOperator!=null) RelationalOperator.traverseBottomUp(visitor);
        if(ConditionFactor!=null) ConditionFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalConditionFactorTokensDerived1(\n");

        if(RelationalOperator!=null)
            buffer.append(RelationalOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFactor!=null)
            buffer.append(ConditionFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalConditionFactorTokensDerived1]");
        return buffer.toString();
    }
}
