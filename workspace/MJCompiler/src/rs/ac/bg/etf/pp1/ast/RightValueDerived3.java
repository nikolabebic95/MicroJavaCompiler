// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:31:30


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived3 extends RightValue {

    private LogicalExpression LogicalExpression;

    public RightValueDerived3 (LogicalExpression LogicalExpression) {
        this.LogicalExpression=LogicalExpression;
        if(LogicalExpression!=null) LogicalExpression.setParent(this);
    }

    public LogicalExpression getLogicalExpression() {
        return LogicalExpression;
    }

    public void setLogicalExpression(LogicalExpression LogicalExpression) {
        this.LogicalExpression=LogicalExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LogicalExpression!=null) LogicalExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LogicalExpression!=null) LogicalExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LogicalExpression!=null) LogicalExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightValueDerived3(\n");

        if(LogicalExpression!=null)
            buffer.append(LogicalExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived3]");
        return buffer.toString();
    }
}
