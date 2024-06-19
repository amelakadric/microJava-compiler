// generated with ast extension for cup
// version 0.8
// 19/5/2024 16:51:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListMany extends ConstDeclList {

    private Type Type;
    private String I2;
    private ConstOptions ConstOptions;
    private ConstDeclOptionsListExists ConstDeclOptionsListExists;
    private ConstDeclList ConstDeclList;

    public ConstDeclListMany (Type Type, String I2, ConstOptions ConstOptions, ConstDeclOptionsListExists ConstDeclOptionsListExists, ConstDeclList ConstDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.ConstOptions=ConstOptions;
        if(ConstOptions!=null) ConstOptions.setParent(this);
        this.ConstDeclOptionsListExists=ConstDeclOptionsListExists;
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
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

    public ConstOptions getConstOptions() {
        return ConstOptions;
    }

    public void setConstOptions(ConstOptions ConstOptions) {
        this.ConstOptions=ConstOptions;
    }

    public ConstDeclOptionsListExists getConstDeclOptionsListExists() {
        return ConstDeclOptionsListExists;
    }

    public void setConstDeclOptionsListExists(ConstDeclOptionsListExists ConstDeclOptionsListExists) {
        this.ConstDeclOptionsListExists=ConstDeclOptionsListExists;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstOptions!=null) ConstOptions.accept(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstOptions!=null) ConstOptions.traverseTopDown(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstOptions!=null) ConstOptions.traverseBottomUp(visitor);
        if(ConstDeclOptionsListExists!=null) ConstDeclOptionsListExists.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListMany(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(ConstOptions!=null)
            buffer.append(ConstOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclOptionsListExists!=null)
            buffer.append(ConstDeclOptionsListExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListMany]");
        return buffer.toString();
    }
}
