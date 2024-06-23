// generated with ast extension for cup
// version 0.8
// 23/5/2024 20:53:34


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Type Type;
    private DesignatorOptions DesignatorOptions;

    public Designator (Type Type, DesignatorOptions DesignatorOptions) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.DesignatorOptions=DesignatorOptions;
        if(DesignatorOptions!=null) DesignatorOptions.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public DesignatorOptions getDesignatorOptions() {
        return DesignatorOptions;
    }

    public void setDesignatorOptions(DesignatorOptions DesignatorOptions) {
        this.DesignatorOptions=DesignatorOptions;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(DesignatorOptions!=null) DesignatorOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(DesignatorOptions!=null) DesignatorOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(DesignatorOptions!=null) DesignatorOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorOptions!=null)
            buffer.append(DesignatorOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
