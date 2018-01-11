// generated with ast extension for cup
// version 0.8
// 11/0/2018 22:8:2


package rs.ac.bg.etf.pp1.ast;

public class TermDerived1 extends Term {

    private Factor Factor;
    private OptionalFactors OptionalFactors;

    public TermDerived1 (Factor Factor, OptionalFactors OptionalFactors) {
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.OptionalFactors=OptionalFactors;
        if(OptionalFactors!=null) OptionalFactors.setParent(this);
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public OptionalFactors getOptionalFactors() {
        return OptionalFactors;
    }

    public void setOptionalFactors(OptionalFactors OptionalFactors) {
        this.OptionalFactors=OptionalFactors;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Factor!=null) Factor.accept(visitor);
        if(OptionalFactors!=null) OptionalFactors.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(OptionalFactors!=null) OptionalFactors.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(OptionalFactors!=null) OptionalFactors.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermDerived1(\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalFactors!=null)
            buffer.append(OptionalFactors.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermDerived1]");
        return buffer.toString();
    }
}
