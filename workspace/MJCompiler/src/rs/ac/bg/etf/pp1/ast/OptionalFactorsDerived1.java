// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:28


package rs.ac.bg.etf.pp1.ast;

public class OptionalFactorsDerived1 extends OptionalFactors {

    private MultiplyOperator MultiplyOperator;
    private Term Term;

    public OptionalFactorsDerived1 (MultiplyOperator MultiplyOperator, Term Term) {
        this.MultiplyOperator=MultiplyOperator;
        if(MultiplyOperator!=null) MultiplyOperator.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public MultiplyOperator getMultiplyOperator() {
        return MultiplyOperator;
    }

    public void setMultiplyOperator(MultiplyOperator MultiplyOperator) {
        this.MultiplyOperator=MultiplyOperator;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultiplyOperator!=null) MultiplyOperator.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultiplyOperator!=null) MultiplyOperator.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultiplyOperator!=null) MultiplyOperator.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalFactorsDerived1(\n");

        if(MultiplyOperator!=null)
            buffer.append(MultiplyOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalFactorsDerived1]");
        return buffer.toString();
    }
}
