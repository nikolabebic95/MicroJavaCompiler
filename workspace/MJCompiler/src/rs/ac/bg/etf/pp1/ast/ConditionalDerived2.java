// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:22


package rs.ac.bg.etf.pp1.ast;

public class ConditionalDerived2 extends Conditional {

    private ConditionalStart ConditionalStart;
    private ConditionalDummy ConditionalDummy;
    private Statement Statement;
    private OptionalElse OptionalElse;

    public ConditionalDerived2 (ConditionalStart ConditionalStart, ConditionalDummy ConditionalDummy, Statement Statement, OptionalElse OptionalElse) {
        this.ConditionalStart=ConditionalStart;
        if(ConditionalStart!=null) ConditionalStart.setParent(this);
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
        if(ConditionalDummy!=null) ConditionalDummy.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(OptionalElse!=null) OptionalElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionalStart!=null) ConditionalStart.traverseTopDown(visitor);
        if(ConditionalDummy!=null) ConditionalDummy.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(OptionalElse!=null) OptionalElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionalStart!=null) ConditionalStart.traverseBottomUp(visitor);
        if(ConditionalDummy!=null) ConditionalDummy.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(OptionalElse!=null) OptionalElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionalDerived2(\n");

        if(ConditionalStart!=null)
            buffer.append(ConditionalStart.toString("  "+tab));
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
        buffer.append(") [ConditionalDerived2]");
        return buffer.toString();
    }
}
