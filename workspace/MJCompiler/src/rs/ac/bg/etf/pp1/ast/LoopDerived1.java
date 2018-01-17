// generated with ast extension for cup
// version 0.8
// 17/0/2018 2:13:13


package rs.ac.bg.etf.pp1.ast;

public class LoopDerived1 extends Loop {

    private LoopStart LoopStart;
    private Statement Statement;
    private LoopConditionStart LoopConditionStart;
    private Condition Condition;

    public LoopDerived1 (LoopStart LoopStart, Statement Statement, LoopConditionStart LoopConditionStart, Condition Condition) {
        this.LoopStart=LoopStart;
        if(LoopStart!=null) LoopStart.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.LoopConditionStart=LoopConditionStart;
        if(LoopConditionStart!=null) LoopConditionStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public LoopStart getLoopStart() {
        return LoopStart;
    }

    public void setLoopStart(LoopStart LoopStart) {
        this.LoopStart=LoopStart;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public LoopConditionStart getLoopConditionStart() {
        return LoopConditionStart;
    }

    public void setLoopConditionStart(LoopConditionStart LoopConditionStart) {
        this.LoopConditionStart=LoopConditionStart;
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
        if(LoopStart!=null) LoopStart.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(LoopConditionStart!=null) LoopConditionStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LoopStart!=null) LoopStart.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(LoopConditionStart!=null) LoopConditionStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LoopStart!=null) LoopStart.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(LoopConditionStart!=null) LoopConditionStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LoopDerived1(\n");

        if(LoopStart!=null)
            buffer.append(LoopStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LoopConditionStart!=null)
            buffer.append(LoopConditionStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LoopDerived1]");
        return buffer.toString();
    }
}
