// generated with ast extension for cup
// version 0.8
// 10/0/2018 16:2:30


package rs.ac.bg.etf.pp1.ast;

public class MethodDerived1 extends Method {

    private ReturnType ReturnType;
    private String I2;
    private FormalParametersList FormalParametersList;
    private LocalVariablesList LocalVariablesList;
    private Block Block;

    public MethodDerived1 (ReturnType ReturnType, String I2, FormalParametersList FormalParametersList, LocalVariablesList LocalVariablesList, Block Block) {
        this.ReturnType=ReturnType;
        if(ReturnType!=null) ReturnType.setParent(this);
        this.I2=I2;
        this.FormalParametersList=FormalParametersList;
        if(FormalParametersList!=null) FormalParametersList.setParent(this);
        this.LocalVariablesList=LocalVariablesList;
        if(LocalVariablesList!=null) LocalVariablesList.setParent(this);
        this.Block=Block;
        if(Block!=null) Block.setParent(this);
    }

    public ReturnType getReturnType() {
        return ReturnType;
    }

    public void setReturnType(ReturnType ReturnType) {
        this.ReturnType=ReturnType;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public FormalParametersList getFormalParametersList() {
        return FormalParametersList;
    }

    public void setFormalParametersList(FormalParametersList FormalParametersList) {
        this.FormalParametersList=FormalParametersList;
    }

    public LocalVariablesList getLocalVariablesList() {
        return LocalVariablesList;
    }

    public void setLocalVariablesList(LocalVariablesList LocalVariablesList) {
        this.LocalVariablesList=LocalVariablesList;
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
        if(ReturnType!=null) ReturnType.accept(visitor);
        if(FormalParametersList!=null) FormalParametersList.accept(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.accept(visitor);
        if(Block!=null) Block.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnType!=null) ReturnType.traverseTopDown(visitor);
        if(FormalParametersList!=null) FormalParametersList.traverseTopDown(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseTopDown(visitor);
        if(Block!=null) Block.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnType!=null) ReturnType.traverseBottomUp(visitor);
        if(FormalParametersList!=null) FormalParametersList.traverseBottomUp(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseBottomUp(visitor);
        if(Block!=null) Block.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDerived1(\n");

        if(ReturnType!=null)
            buffer.append(ReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FormalParametersList!=null)
            buffer.append(FormalParametersList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariablesList!=null)
            buffer.append(LocalVariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Block!=null)
            buffer.append(Block.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDerived1]");
        return buffer.toString();
    }
}
