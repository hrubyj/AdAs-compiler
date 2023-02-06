package cz.zcu.kiv;

import cz.zcu.kiv.gen.AdAsLexer;
import cz.zcu.kiv.gen.AdAsParser;
import cz.zcu.kiv.visitor.ProgramVisitor;
import cz.zcu.kiv.vo.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdAs {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Wrong parameters! Parameters should be: <input_file> <output_file>");
            System.exit(-1);
        }
        if (!new File(args[0]).exists()) {
            System.out.println("Input file does not exist!");
            System.exit(-1);
        }

        try {

            compileSourceFile(args[0], args[1]);
            System.out.println("Compilation successful!");

        } catch (final Exception e) {
            System.out.format("""
                    Compilation error:
                    \t%s
                    """, e.getMessage());
            System.exit(-1);
        }
    }

    private static void compileSourceFile(final String sourceFile, final String outputFile) {
        CharStream input = null;
        try {
            input = CharStreams.fromFileName(sourceFile);
        } catch (Exception e) {
            System.out.println("Input file not found");
            System.exit(-1);
        }

        AdAsLexer lexer = new AdAsLexer(input);
        CommonTokenStream token_stream = new CommonTokenStream(lexer);
        AdAsParser parser = new AdAsParser(token_stream);
        ParseTree tree = parser.program();
        checkErrors(tree);

        ProgramVisitor programVisitor = new ProgramVisitor();
        Program program = programVisitor.visit(tree);

        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            Writer writer = new Writer(fileWriter);
            Compiler compiler = new Compiler(program, writer);
            compiler.compile();
        } catch (IOException e) {
            System.out.println("Compilation error! " + e.getMessage());
            System.exit(-1);
        }
    }

    public static void checkErrors(ParseTree parseTree) {
        for (int i = 0; i < parseTree.getChildCount(); i++) {
            if (parseTree.getChild(i) instanceof ErrorNodeImpl) {
                System.out.println("ParseTree including errors!");
                System.exit(-1);
            } else {
                checkErrors(parseTree.getChild(i));
            }
        }
    }


}
