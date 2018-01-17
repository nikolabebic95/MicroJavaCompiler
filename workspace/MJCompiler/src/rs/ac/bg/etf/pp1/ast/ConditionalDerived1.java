// generated with ast extension for cup
// version 0.8
// 17/0/2018 18:3:11


package rs.ac.bg.etf.pp1.ast;

public class ConditionalDerived1 extends Conditional {

    private ConditionalStart ConditionalStart;
    private Condition Condition;
    private ConditionalDummy ConditionalDummy;
    private Statement Statement;
    private OptionalElse OptionalElse;

    public ConditionalDerived1 (ConditionalStart ConditionalStart, Condition Condition, ConditionalDummy ConditionalDummy, Statement Statement, OptionalElse OptionalElse) {
        this.ConditionalStart=ConditionalStart;
        if(ConditionalStart!=null) ConditionalStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.ConditionalDummy=ConditionalDummy;
        if(ConditionalDummy!=null) ConditionalDummy.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.OptionalElse=OptionalElse;
        if(OptionalElse!=null) OptionalElse.setParent(this);
    }

    public ConditionalStart getConditionalStart() {
        return ConditionalStart;
    }

    public void setConditionalStart(ConditionalStart ConditionalStart) {
        this.ConditionalStart=ConditionalStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public ConditionalDummy getConditionalDummy() {
        return ConditionalDummy;
    }

    public void setConditionalDummy(ConditionalDummy ConditionalDummy) {
        this.ConditionalDummy=ConditionalDummy;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public OptionalElse getOptionalElse() {
        return OptionalElse;
    }

    public void setOptionalElse(OptionalElse OptionalElse) {
        this.OptionalElse=OptionalElse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionalStart!=null) ConditionalStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(ConditionalDummy!=null) ConditionalDummy.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(OptionalElse!=null) OptionalElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionalStart!=null) ConditionalStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(ConditionalDummy!=null) ConditionalDummy.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(OptionalElse!=null) OptionalElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionalStart!=null) ConditionalStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(ConditionalDummy!=null) ConditionalDummy.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(OptionalElse!=null) OptionalElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalDerived1(\n");

        if(ConditionalStart!=null)
            buffer.append(ConditionalStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionalDummy!=null)
            buffer.append(ConditionalDummy.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalElse!=null)
            buffer.append(OptionalElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionalDerived1]");
        return buffer.toString();
    }
}
