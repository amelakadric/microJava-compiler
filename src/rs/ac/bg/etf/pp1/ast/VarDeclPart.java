// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPart implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private Braces Braces;

    public VarDeclPart (String I1, Braces Braces) {
        this.I1=I1;
        this.Braces=Braces;
        if(Braces!=null) Braces.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Braces getBraces() {
        return Braces;
    }

    public void setBraces(Braces Braces) {
        this.Braces=Braces;
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
        if(Braces!=null) Braces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Braces!=null) Braces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Braces!=null) Braces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPart(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Braces!=null)
            buffer.append(Braces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPart]");
        return buffer.toString();
    }
}
