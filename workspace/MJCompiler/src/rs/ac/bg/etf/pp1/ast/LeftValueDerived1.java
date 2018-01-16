// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class LeftValueDerived1 extends LeftValue {

    private LeftValueStart LeftValueStart;
    private OptionalIndirections OptionalIndirections;

    public LeftValueDerived1 (LeftValueStart LeftValueStart, OptionalIndirections OptionalIndirections) {
        this.LeftValueStart=LeftValueStart;
        if(LeftValueStart!=null) LeftValueStart.setParent(this);
        this.OptionalIndirections=OptionalIndirections;
        if(OptionalIndirections!=null) OptionalIndirections.setParent(this);
    }

    public LeftValueStart getLeftValueStart() {
        return LeftValueStart;
    }

    public void setLeftValueStart(LeftValueStart LeftValueStart) {
        this.LeftValueStart=LeftValueStart;
    }

    public OptionalIndirections getOptionalIndirections() {
        return OptionalIndirections;
    }

    public void setOptionalIndirections(OptionalIndirections OptionalIndirections) {
        this.OptionalIndirections=OptionalIndirections;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftValueStart!=null) LeftValueStart.accept(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftValueStart!=null) LeftValueStart.traverseTopDown(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftValueStart!=null) LeftValueStart.traverseBottomUp(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LeftValueDerived1(\n");

        if(LeftValueStart!=null)
            buffer.append(LeftValueStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalIndirections!=null)
            buffer.append(OptionalIndirections.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LeftValueDerived1]");
        return buffer.toString();
    }
}
