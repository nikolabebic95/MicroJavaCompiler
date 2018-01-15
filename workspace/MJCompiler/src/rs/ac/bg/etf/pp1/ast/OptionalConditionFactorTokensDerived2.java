// generated with ast extension for cup
// version 0.8
// 15/0/2018 16:25:52


package rs.ac.bg.etf.pp1.ast;

public class OptionalConditionFactorTokensDerived2 extends OptionalConditionFactorTokens {

    public OptionalConditionFactorTokensDerived2 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalConditionFactorTokensDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OptionalConditionFactorTokensDerived2]");
        return buffer.toString();
    }
}
