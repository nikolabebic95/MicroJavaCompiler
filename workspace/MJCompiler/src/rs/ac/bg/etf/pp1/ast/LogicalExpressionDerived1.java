// generated with ast extension for cup
// version 0.8
// 17/0/2018 0:47:22


package rs.ac.bg.etf.pp1.ast;

public class LogicalExpressionDerived1 extends LogicalExpression {

    private PureCondition PureCondition;

    public LogicalExpressionDerived1 (PureCondition PureCondition) {
        this.PureCondition=PureCondition;
        if(PureCondition!=null) PureCondition.setParent(this);
    }

    public PureCondition getPureCondition() {
        return PureCondition;
    }

    public void setPureCondition(PureCondition PureCondition) {
        this.PureCondition=PureCondition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PureCondition!=null) PureCondition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PureCondition!=null) PureCondition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PureCondition!=null) PureCondition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LogicalExpressionDerived1(\n");

        if(PureCondition!=null)
            buffer.append(PureCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LogicalExpressionDerived1]");
        return buffer.toString();
    }
}
