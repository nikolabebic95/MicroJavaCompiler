package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.Extensions.ExtendedSymbolTable;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

import java.io.*;

public class Compiler {

    static {
        DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
        Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
    }

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Compiler.class);

        try {
            File sourceCode = new File("MJCompiler/test/test303.mj");
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))){

                // Lexer and parser
                Yylex lexer = new Yylex(br);
                MJParser p = new MJParser(lexer);
                Symbol s = p.parse();

                // Output parser results
                Program program = (Program) s.value;
                System.out.println(program);

                // Semantic check
                ExtendedSymbolTable.init();
                SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
                program.traverseBottomUp(semanticAnalyzer);
                ExtendedSymbolTable.dump();
            }
        }
        catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            log.error(e);
        }
    }
}
