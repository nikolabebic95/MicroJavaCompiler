// generated with ast extension for cup
// version 0.8
// 10/0/2018 16:2:30


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived3 extends Statement {

    private Block Block;

    public StatementDerived3 (Block Block) {
        this.Block=Block;
        if(Block!=null) Block.setParent(this);
    }

    public Block getBlock() {
        return Block;
    }

    public void setBlock(Block Block) {
        this.Block=Block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Block!=null) Block.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Block!=null) Block.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Block!=null) Block.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived3(\n");

        if(Block!=null)
            buffer.append(Block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived3]");
        return buffer.toString();
    }
}
