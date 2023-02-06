package cz.zcu.kiv.visitor;

import cz.zcu.kiv.gen.AdAsBaseVisitor;
import cz.zcu.kiv.gen.AdAsParser;
import cz.zcu.kiv.vo.Program;

public class ProgramVisitor extends AdAsBaseVisitor<Program> {

    @Override
    public Program visitProgram(AdAsParser.ProgramContext ctx) {
        Program program = new Program();
        ExpressionVisitor visitor = new ExpressionVisitor();
        int childCount = ctx.getChildCount();

        for (int i = 0; i < childCount; i++) {
            program.addExpression(visitor.visit(ctx.getChild(i)));
        }

        return program;
    }

}