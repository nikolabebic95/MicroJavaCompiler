// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:5


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactorTokenDerived1 extends ConditionFactorToken {

    private ArithmeticExpression ArithmeticExpression;

    public ConditionFactorTokenDerived1 (ArithmeticExpression ArithmeticExpression) {
        this.ArithmeticExpression=ArithmeticExpression;
        if(ArithmeticExpression!=null) ArithmeticExpression.setParent(this);
    }

    public ArithmeticExpression getArithmeticExpression() {
        return ArithmeticExpression;
    }

    public void setArithmeticExpression(ArithmeticExpression ArithmeticExpression) {
        this.ArithmeticExpression=ArithmeticExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArithmeticExpression!=null) ArithmeticExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArithmeticExpression!=null) ArithmeticExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArithmeticExpression!=null) ArithmeticExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFactorTokenDerived1(\n");

        if(ArithmeticExpression!=null)
            buffer.append(ArithmeticExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactorTokenDerived1]");
        return buffer.toString();
    }
}
