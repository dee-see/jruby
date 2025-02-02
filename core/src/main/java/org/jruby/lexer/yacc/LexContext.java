package org.jruby.lexer.yacc;

import org.jruby.ast.DefHolder;

public class LexContext {
    // Is the parser currently within a class body.
    public boolean in_class;

    // Is the parser currently within a method definition
    public boolean in_def;

    public boolean in_defined;

    public boolean in_kwarg;

    public ShareableConstantValue shareable_constant_value;

    public void reset() {
        in_def = false;
    }

    public Object clone() {
        LexContext context = new LexContext();
        context.in_class = in_class;
        context.in_def = in_def;
        context.in_defined = in_defined;
        context.shareable_constant_value = shareable_constant_value;

        return context;
    }

    public void restore(DefHolder holder) {
        this.in_def = holder.ctxt.in_def;
        this.shareable_constant_value = holder.ctxt.shareable_constant_value;
    }
}
