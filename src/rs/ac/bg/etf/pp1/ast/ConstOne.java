// generated with ast extension for cup
// version 0.8
// 24/5/2024 2:53:33


package rs.ac.bg.etf.pp1.ast;

public class ConstOne implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String constName;
    private ConstOptions ConstOptions;

    public ConstOne (String constName, ConstOptions ConstOptions) {
        this.constName=constName;
        this.ConstOptions=ConstOptions;
        if(ConstOptions!=null) ConstOptions.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstOptions getConstOptions() {
        return ConstOptions;
    }

    public void setConstOptions(ConstOptions ConstOptions) {
        this.ConstOptions=ConstOptions;
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
        if(ConstOptions!=null) ConstOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstOptions!=null) ConstOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstOptions!=null) ConstOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstOne(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstOptions!=null)
            buffer.append(ConstOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstOne]");
        return buffer.toString();
    }
}
