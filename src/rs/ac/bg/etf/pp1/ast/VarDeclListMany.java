// generated with ast extension for cup
// version 0.8
// 19/5/2024 16:51:6


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListMany extends VarDeclList {

    private Type Type;
    private String I2;
    private SqBracesOption SqBracesOption;
    private VarDeclPartListExists VarDeclPartListExists;
    private VarDeclList VarDeclList;

    public VarDeclListMany (Type Type, String I2, SqBracesOption SqBracesOption, VarDeclPartListExists VarDeclPartListExists, VarDeclList VarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
        this.VarDeclPartListExists=VarDeclPartListExists;
        if(VarDeclPartListExists!=null) VarDeclPartListExists.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        if(VarDeclPartListExists!=null) VarDeclPartListExists.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListMany(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
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

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListMany]");
        return buffer.toString();
    }
}
