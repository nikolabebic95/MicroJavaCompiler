// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:31:31


package rs.ac.bg.etf.pp1.ast;

public class PureArithmeticExpressionDerived1 extends PureArithmeticExpression {

    private Term Term;
    private OptionalTerms OptionalTerms;

    public PureArithmeticExpressionDerived1 (Term Term, OptionalTerms OptionalTerms) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.OptionalTerms=OptionalTerms;
        if(OptionalTerms!=null) OptionalTerms.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public OptionalTerms getOptionalTerms() {
        return OptionalTerms;
    }

    public void setOptionalTerms(OptionalTerms OptionalTerms) {
        this.OptionalTerms=OptionalTerms;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(OptionalTerms!=null) OptionalTerms.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(OptionalTerms!=null) OptionalTerms.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(OptionalTerms!=null) OptionalTerms.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PureArithmeticExpressionDerived1(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalTerms!=null)
            buffer.append(OptionalTerms.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PureArithmeticExpressionDerived1]");
        return buffer.toString();
    }
}
