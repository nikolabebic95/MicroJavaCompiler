package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.ac.bg.etf.pp1.extensions.ExtendedSymbolTable;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;

import java.io.*;

public class Compiler {

    static {
        DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
        Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Not enough params (2 needed)");
            return;
        }

        Logger log = Logger.getLogger(Compiler.class);

        try {
            File sourceCode = new File(args[0]);
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))){

                // Lexer and parser
                Yylex lexer = new Yylex(br);
                MJParser p = new MJParser(lexer);
                Symbol s = p.parse();

                if (!(s.value instanceof Program)) {
                    log.error("Errors found - Stopping compiler");
                    return;
                }

                if (!p.allCorrect) {
                    log.error("Errors found - Stopping compiler");
                    return;
                }

                // Output parser results
                Program program = (Program) s.value;
                System.out.println(program);

                // Semantic check
                ExtendedSymbolTable.init();
                SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
                program.traverseBottomUp(semanticAnalyzer);
                ExtendedSymbolTable.dump();

                // Code generation
                CodeGenerator codeGenerator = new CodeGenerator();
                program.traverseBottomUp(codeGenerator);
                Code.write(new FileOutputStream(args[1]));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
