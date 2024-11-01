// generated with ast extension for cup
// version 0.8
// 27/5/2024 3:27:40


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstOne ConstOne;
    private ConstDeclOptionsListExists ConstDeclOptionsListExists;

    public ConstDecl (Type Type, ConstOne ConstOne, ConstDeclOptionsListExists ConstDeclOptionsListExists) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstOne=ConstOne;
        if(ConstOne!=null) ConstOne.setParent(this);
        this.ConstDeclOptionsListExists=ConstDeclOptionsListExists;
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstOne getConstOne() {
        return ConstOne;
    }

    public void setConstOne(ConstOne ConstOne) {
        this.ConstOne=ConstOne;
    }

    public ConstDeclOptionsListExists getConstDeclOptionsListExists() {
        return ConstDeclOptionsListExists;
    }

    public void setConstDeclOptionsListExists(ConstDeclOptionsListExists ConstDeclOptionsListExists) {
        this.ConstDeclOptionsListExists=ConstDeclOptionsListExists;
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
        if(ConstOne!=null) ConstOne.accept(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstOne!=null) ConstOne.traverseTopDown(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstOne!=null) ConstOne.traverseBottomUp(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstOne!=null)
            buffer.append(ConstOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclOptionsListExists!=null)
            buffer.append(ConstDeclOptionsListExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
