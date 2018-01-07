// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:31:29


package rs.ac.bg.etf.pp1.ast;

public class BlockDerived1 extends Block {

    private Block Block;
    private Statement Statement;

    public BlockDerived1 (Block Block, Statement Statement) {
        this.Block=Block;
        if(Block!=null) Block.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public Block getBlock() {
        return Block;
    }

    public void setBlock(Block Block) {
        this.Block=Block;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Block!=null) Block.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Block!=null) Block.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Block!=null) Block.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BlockDerived1(\n");

        if(Block!=null)
            buffer.append(Block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BlockDerived1]");
        return buffer.toString();
    }
}
