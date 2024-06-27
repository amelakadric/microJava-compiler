// generated with ast extension for cup
// version 0.8
// 27/5/2024 22:44:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationOne extends VarDecl {

    private VarOneOptions VarOneOptions;
    private VarDeclPartListExists VarDeclPartListExists;

    public VarDeclarationOne (VarOneOptions VarOneOptions, VarDeclPartListExists VarDeclPartListExists) {
        this.VarOneOptions=VarOneOptions;
        if(VarOneOptions!=null) VarOneOptions.setParent(this);
        this.VarDeclPartListExists=VarDeclPartListExists;
        if(VarDeclPartListExists!=null) VarDeclPartListExists.setParent(this);
    }

    public VarOneOptions getVarOneOptions() {
        return VarOneOptions;
    }

    public void setVarOneOptions(VarOneOptions VarOneOptions) {
        this.VarOneOptions=VarOneOptions;
    }

    public VarDeclPartListExists getVarDeclPartListExists() {
        return VarDeclPartListExists;
    }

    public void setVarDeclPartListExists(VarDeclPartListExists VarDeclPartListExists) {
        this.VarDeclPartListExists=VarDeclPartListExists;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarOneOptions!=null) VarOneOptions.accept(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarOneOptions!=null) VarOneOptions.traverseTopDown(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarOneOptions!=null) VarOneOptions.traverseBottomUp(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationOne(\n");

        if(VarOneOptions!=null)
            buffer.append(VarOneOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclPartListExists!=null)
            buffer.append(VarDeclPartListExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationOne]");
        return buffer.toString();
    }
}
