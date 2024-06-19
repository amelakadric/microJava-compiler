// generated with ast extension for cup
// version 0.8
// 19/5/2024 16:51:6


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TypeOptions TypeOptions;
    private String I2;
    private FormParsExists FormParsExists;
    private VarDeclList VarDeclList;
    private StatementList StatementList;

    public MethodDecl (TypeOptions TypeOptions, String I2, FormParsExists FormParsExists, VarDeclList VarDeclList, StatementList StatementList) {
        this.TypeOptions=TypeOptions;
        if(TypeOptions!=null) TypeOptions.setParent(this);
        this.I2=I2;
        this.FormParsExists=FormParsExists;
        if(FormParsExists!=null) FormParsExists.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public TypeOptions getTypeOptions() {
        return TypeOptions;
    }

    public void setTypeOptions(TypeOptions TypeOptions) {
        this.TypeOptions=TypeOptions;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public FormParsExists getFormParsExists() {
        return FormParsExists;
    }

    public void setFormParsExists(FormParsExists FormParsExists) {
        this.FormParsExists=FormParsExists;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
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
        if(TypeOptions!=null) TypeOptions.accept(visitor);
        if(FormParsExists!=null) FormParsExists.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOptions!=null) TypeOptions.traverseTopDown(visitor);
        if(FormParsExists!=null) FormParsExists.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOptions!=null) TypeOptions.traverseBottomUp(visitor);
        if(FormParsExists!=null) FormParsExists.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(TypeOptions!=null)
            buffer.append(TypeOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FormParsExists!=null)
            buffer.append(FormParsExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
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
