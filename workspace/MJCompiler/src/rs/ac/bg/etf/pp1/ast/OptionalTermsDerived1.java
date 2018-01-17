// generated with ast extension for cup
// version 0.8
// 17/0/2018 2:13:13


package rs.ac.bg.etf.pp1.ast;

public class OptionalTermsDerived1 extends OptionalTerms {

    private AddOperator AddOperator;
    private PureArithmeticExpression PureArithmeticExpression;

    public OptionalTermsDerived1 (AddOperator AddOperator, PureArithmeticExpression PureArithmeticExpression) {
        this.AddOperator=AddOperator;
        if(AddOperator!=null) AddOperator.setParent(this);
        this.PureArithmeticExpression=PureArithmeticExpression;
        if(PureArithmeticExpression!=null) PureArithmeticExpression.setParent(this);
    }

    public AddOperator getAddOperator() {
        return AddOperator;
    }

    public void setAddOperator(AddOperator AddOperator) {
        this.AddOperator=AddOperator;
    }

    public PureArithmeticExpression getPureArithmeticExpression() {
        return PureArithmeticExpression;
    }

    public void setPureArithmeticExpression(PureArithmeticExpression PureArithmeticExpression) {
        this.PureArithmeticExpression=PureArithmeticExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddOperator!=null) AddOperator.accept(visitor);
        if(PureArithmeticExpression!=null) PureArithmeticExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddOperator!=null) AddOperator.traverseTopDown(visitor);
        if(PureArithmeticExpression!=null) PureArithmeticExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddOperator!=null) AddOperator.traverseBottomUp(visitor);
        if(PureArithmeticExpression!=null) PureArithmeticExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalTermsDerived1(\n");

        if(AddOperator!=null)
            buffer.append(AddOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PureArithmeticExpression!=null)
            buffer.append(PureArithmeticExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalTermsDerived1]");
        return buffer.toString();
    }
}
