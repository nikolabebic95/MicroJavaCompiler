// generated with ast extension for cup
// version 0.8
// 17/0/2018 18:3:11


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactorDerived1 extends ConditionFactor {

    private ConditionFactorToken ConditionFactorToken;
    private RelationalOperator RelationalOperator;
    private ConditionFactorToken ConditionFactorToken1;

    public ConditionFactorDerived1 (ConditionFactorToken ConditionFactorToken, RelationalOperator RelationalOperator, ConditionFactorToken ConditionFactorToken1) {
        this.ConditionFactorToken=ConditionFactorToken;
        if(ConditionFactorToken!=null) ConditionFactorToken.setParent(this);
        this.RelationalOperator=RelationalOperator;
        if(RelationalOperator!=null) RelationalOperator.setParent(this);
        this.ConditionFactorToken1=ConditionFactorToken1;
        if(ConditionFactorToken1!=null) ConditionFactorToken1.setParent(this);
    }

    public ConditionFactorToken getConditionFactorToken() {
        return ConditionFactorToken;
    }

    public void setConditionFactorToken(ConditionFactorToken ConditionFactorToken) {
        this.ConditionFactorToken=ConditionFactorToken;
    }

    public RelationalOperator getRelationalOperator() {
        return RelationalOperator;
    }

    public void setRelationalOperator(RelationalOperator RelationalOperator) {
        this.RelationalOperator=RelationalOperator;
    }

    public ConditionFactorToken getConditionFactorToken1() {
        return ConditionFactorToken1;
    }

    public void setConditionFactorToken1(ConditionFactorToken ConditionFactorToken1) {
        this.ConditionFactorToken1=ConditionFactorToken1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFactorToken!=null) ConditionFactorToken.accept(visitor);
        if(RelationalOperator!=null) RelationalOperator.accept(visitor);
        if(ConditionFactorToken1!=null) ConditionFactorToken1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactorToken!=null) ConditionFactorToken.traverseTopDown(visitor);
        if(RelationalOperator!=null) RelationalOperator.traverseTopDown(visitor);
        if(ConditionFactorToken1!=null) ConditionFactorToken1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactorToken!=null) ConditionFactorToken.traverseBottomUp(visitor);
        if(RelationalOperator!=null) RelationalOperator.traverseBottomUp(visitor);
        if(ConditionFactorToken1!=null) ConditionFactorToken1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFactorDerived1(\n");

        if(ConditionFactorToken!=null)
            buffer.append(ConditionFactorToken.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RelationalOperator!=null)
            buffer.append(RelationalOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFactorToken1!=null)
            buffer.append(ConditionFactorToken1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactorDerived1]");
        return buffer.toString();
    }
}
