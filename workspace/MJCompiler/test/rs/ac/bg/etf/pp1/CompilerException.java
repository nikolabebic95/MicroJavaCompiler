package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;

public class CompilerException extends RuntimeException {
    private SyntaxNode syntaxNode;

    public CompilerException(SyntaxNode syntaxNode, String message) {
        super(message);
        this.syntaxNode = syntaxNode;
    }

    @Override
    public String getMessage() {
        return "Error on line " + syntaxNode.getLine() + ": \n\t" + super.getMessage();
    }
}
