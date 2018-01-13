// generated with ast extension for cup
// version 0.8
// 13/0/2018 22:49:31


package rs.ac.bg.etf.pp1.ast;

public class OptionalIndirectionsDerived1 extends OptionalIndirections {

    private OptionalIndirections OptionalIndirections;
    private Indirection Indirection;

    public OptionalIndirectionsDerived1 (OptionalIndirections OptionalIndirections, Indirection Indirection) {
        this.OptionalIndirections=OptionalIndirections;
        if(OptionalIndirections!=null) OptionalIndirections.setParent(this);
        this.Indirection=Indirection;
        if(Indirection!=null) Indirection.setParent(this);
    }

    public OptionalIndirections getOptionalIndirections() {
        return OptionalIndirections;
    }

    public void setOptionalIndirections(OptionalIndirections OptionalIndirections) {
        this.OptionalIndirections=OptionalIndirections;
    }

    public Indirection getIndirection() {
        return Indirection;
    }

    public void setIndirection(Indirection Indirection) {
        this.Indirection=Indirection;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalIndirections!=null) OptionalIndirections.accept(visitor);
        if(Indirection!=null) Indirection.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalIndirections!=null) OptionalIndirections.traverseTopDown(visitor);
        if(Indirection!=null) Indirection.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalIndirections!=null) OptionalIndirections.traverseBottomUp(visitor);
        if(Indirection!=null) Indirection.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalIndirectionsDerived1(\n");

        if(OptionalIndirections!=null)
            buffer.append(OptionalIndirections.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Indirection!=null)
            buffer.append(Indirection.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalIndirectionsDerived1]");
        return buffer.toString();
    }
}
