// generated with ast extension for cup
// version 0.8
// 24/5/2024 2:53:33


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationOne extends VarDecl {

    private VarDeclOne VarDeclOne;
    private SqBracesOption SqBracesOption;
    private VarDeclPartListExists VarDeclPartListExists;

    public VarDeclarationOne (VarDeclOne VarDeclOne, SqBracesOption SqBracesOption, VarDeclPartListExists VarDeclPartListExists) {
        this.VarDeclOne=VarDeclOne;
        if(VarDeclOne!=null) VarDeclOne.setParent(this);
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
        this.VarDeclPartListExists=VarDeclPartListExists;
        if(VarDeclPartListExists!=null) VarDeclPartListExists.setParent(this);
    }

    public VarDeclOne getVarDeclOne() {
        return VarDeclOne;
    }

    public void setVarDeclOne(VarDeclOne VarDeclOne) {
        this.VarDeclOne=VarDeclOne;
    }

    public SqBracesOption getSqBracesOption() {
        return SqBracesOption;
    }

    public void setSqBracesOption(SqBracesOption SqBracesOption) {
        this.SqBracesOption=SqBracesOption;
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
        if(VarDeclOne!=null) VarDeclOne.accept(visitor);
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclOne!=null) VarDeclOne.traverseTopDown(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclOne!=null) VarDeclOne.traverseBottomUp(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationOne(\n");

        if(VarDeclOne!=null)
            buffer.append(VarDeclOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SqBracesOption!=null)
            buffer.append(SqBracesOption.toString("  "+tab));
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
