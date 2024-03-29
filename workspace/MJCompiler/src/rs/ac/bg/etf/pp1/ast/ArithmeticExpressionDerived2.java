// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:22


package rs.ac.bg.etf.pp1.ast;

public class ArithmeticExpressionDerived2 extends ArithmeticExpression {

    private PureArithmeticExpression PureArithmeticExpression;

    public ArithmeticExpressionDerived2 (PureArithmeticExpression PureArithmeticExpression) {
        this.PureArithmeticExpression=PureArithmeticExpression;
        if(PureArithmeticExpression!=null) PureArithmeticExpression.setParent(this);
    }

    public PureArithmeticExpression getPureArithmeticExpression() {
        return PureArithmeticExpression;
    }

    public void setPureArithmeticExpression(PureArithmeticExpression PureArithmeticExpression) {
        this.PureArithmeticExpression=PureArithmeticExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PureArithmeticExpression!=null) PureArithmeticExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PureArithmeticExpression!=null) PureArithmeticExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PureArithmeticExpression!=null) PureArithmeticExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArithmeticExpressionDerived2(\n");

        if(PureArithmeticExpression!=null)
            buffer.append(PureArithmeticExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArithmeticExpressionDerived2]");
        return buffer.toString();
    }
}
