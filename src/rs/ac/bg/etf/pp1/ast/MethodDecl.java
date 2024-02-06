// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodDeclOpt MethodDeclOpt;
    private String I2;
    private FormParsOpt FormParsOpt;
    private VarList VarList;
    private StatementList StatementList;

    public MethodDecl (MethodDeclOpt MethodDeclOpt, String I2, FormParsOpt FormParsOpt, VarList VarList, StatementList StatementList) {
        this.MethodDeclOpt=MethodDeclOpt;
        if(MethodDeclOpt!=null) MethodDeclOpt.setParent(this);
        this.I2=I2;
        this.FormParsOpt=FormParsOpt;
        if(FormParsOpt!=null) FormParsOpt.setParent(this);
        this.VarList=VarList;
        if(VarList!=null) VarList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodDeclOpt getMethodDeclOpt() {
        return MethodDeclOpt;
    }

    public void setMethodDeclOpt(MethodDeclOpt MethodDeclOpt) {
        this.MethodDeclOpt=MethodDeclOpt;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public FormParsOpt getFormParsOpt() {
        return FormParsOpt;
    }

    public void setFormParsOpt(FormParsOpt FormParsOpt) {
        this.FormParsOpt=FormParsOpt;
    }

    public VarList getVarList() {
        return VarList;
    }

    public void setVarList(VarList VarList) {
        this.VarList=VarList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
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
        if(MethodDeclOpt!=null) MethodDeclOpt.accept(visitor);
        if(FormParsOpt!=null) FormParsOpt.accept(visitor);
        if(VarList!=null) VarList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclOpt!=null) MethodDeclOpt.traverseTopDown(visitor);
        if(FormParsOpt!=null) FormParsOpt.traverseTopDown(visitor);
        if(VarList!=null) VarList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclOpt!=null) MethodDeclOpt.traverseBottomUp(visitor);
        if(FormParsOpt!=null) FormParsOpt.traverseBottomUp(visitor);
        if(VarList!=null) VarList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodDeclOpt!=null)
            buffer.append(MethodDeclOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FormParsOpt!=null)
            buffer.append(FormParsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarList!=null)
            buffer.append(VarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
