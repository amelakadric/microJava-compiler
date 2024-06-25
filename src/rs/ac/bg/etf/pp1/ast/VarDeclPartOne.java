// generated with ast extension for cup
// version 0.8
// 25/5/2024 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartOne implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private SqBracesOption SqBracesOption;

    public VarDeclPartOne (String varName, SqBracesOption SqBracesOption) {
        this.varName=varName;
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
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
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartOne(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SqBracesOption!=null)
            buffer.append(SqBracesOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPartOne]");
        return buffer.toString();
    }
}
