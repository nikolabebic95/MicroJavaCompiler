// generated with ast extension for cup
// version 0.8
// 17/0/2018 2:13:13


package rs.ac.bg.etf.pp1.ast;

public class OptionalIndirectionsDerived1 extends OptionalIndirections {

    private Indirection Indirection;
    private OptionalIndirections OptionalIndirections;

    public OptionalIndirectionsDerived1 (Indirection Indirection, OptionalIndirections OptionalIndirections) {
        this.Indirection=Indirection;
        if(Indirection!=null) Indirection.setParent(this);
        this.OptionalIndirections=OptionalIndirections;
        if(OptionalIndirections!=null) OptionalIndirections.setParent(this);
    }

    public Indirection getIndirection() {
        return Indirection;
    }

    public void setIndirection(Indirection Indirection) {
        this.Indirection=Indirection;
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
        if(Indirection!=null) Indirection.accept(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Indirection!=null) Indirection.traverseTopDown(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Indirection!=null) Indirection.traverseBottomUp(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalIndirectionsDerived1(\n");

        if(Indirection!=null)
            buffer.append(Indirection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalIndirections!=null)
            buffer.append(OptionalIndirections.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalIndirectionsDerived1]");
        return buffer.toString();
    }
}
