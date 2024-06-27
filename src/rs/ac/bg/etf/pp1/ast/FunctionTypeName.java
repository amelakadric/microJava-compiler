// generated with ast extension for cup
// version 0.8
// 27/5/2024 21:43:18


package rs.ac.bg.etf.pp1.ast;

public class FunctionTypeName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private TypeOptions TypeOptions;
    private String funcName;

    public FunctionTypeName (TypeOptions TypeOptions, String funcName) {
        this.TypeOptions=TypeOptions;
        if(TypeOptions!=null) TypeOptions.setParent(this);
        this.funcName=funcName;
    }

    public TypeOptions getTypeOptions() {
        return TypeOptions;
    }

    public void setTypeOptions(TypeOptions TypeOptions) {
        this.TypeOptions=TypeOptions;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName=funcName;
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
        if(TypeOptions!=null) TypeOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOptions!=null) TypeOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOptions!=null) TypeOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionTypeName(\n");

        if(TypeOptions!=null)
            buffer.append(TypeOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+funcName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionTypeName]");
        return buffer.toString();
    }
}
