// generated with ast extension for cup
// version 0.8
// 27/5/2024 3:27:41


package rs.ac.bg.etf.pp1.ast;

public class VarDeclOne implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String varName;
    private SqBracesOption SqBracesOption;

    public VarDeclOne (Type Type, String varName, SqBracesOption SqBracesOption) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.varName=varName;
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public SqBracesOption getSqBracesOption() {
        return SqBracesOption;
    }

    public void setSqBracesOption(SqBracesOption SqBracesOption) {
        this.SqBracesOption=SqBracesOption;
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
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclOne(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SqBracesOption!=null)
            buffer.append(SqBracesOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclOne]");
        return buffer.toString();
    }
}
