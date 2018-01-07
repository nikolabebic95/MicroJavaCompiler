// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:31:31


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactorDerived1 extends ConditionFactor {

    private ConditionFactorToken ConditionFactorToken;
    private OptionalConditionFactorTokens OptionalConditionFactorTokens;

    public ConditionFactorDerived1 (ConditionFactorToken ConditionFactorToken, OptionalConditionFactorTokens OptionalConditionFactorTokens) {
        this.ConditionFactorToken=ConditionFactorToken;
        if(ConditionFactorToken!=null) ConditionFactorToken.setParent(this);
        this.OptionalConditionFactorTokens=OptionalConditionFactorTokens;
        if(OptionalConditionFactorTokens!=null) OptionalConditionFactorTokens.setParent(this);
    }

    public ConditionFactorToken getConditionFactorToken() {
        return ConditionFactorToken;
    }

    public void setConditionFactorToken(ConditionFactorToken ConditionFactorToken) {
        this.ConditionFactorToken=ConditionFactorToken;
    }

    public OptionalConditionFactorTokens getOptionalConditionFactorTokens() {
        return OptionalConditionFactorTokens;
    }

    public void setOptionalConditionFactorTokens(OptionalConditionFactorTokens OptionalConditionFactorTokens) {
        this.OptionalConditionFactorTokens=OptionalConditionFactorTokens;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionFactorToken!=null) ConditionFactorToken.accept(visitor);
        if(OptionalConditionFactorTokens!=null) OptionalConditionFactorTokens.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionFactorToken!=null) ConditionFactorToken.traverseTopDown(visitor);
        if(OptionalConditionFactorTokens!=null) OptionalConditionFactorTokens.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionFactorToken!=null) ConditionFactorToken.traverseBottomUp(visitor);
        if(OptionalConditionFactorTokens!=null) OptionalConditionFactorTokens.traverseBottomUp(visitor);
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

        if(OptionalConditionFactorTokens!=null)
            buffer.append(OptionalConditionFactorTokens.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactorDerived1]");
        return buffer.toString();
    }
}
