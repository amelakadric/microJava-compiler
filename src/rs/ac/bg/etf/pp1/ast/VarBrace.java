// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class VarBrace extends VarDecl {

    private Type Type;
    private String I2;
    private Braces Braces;
    private VarDeclPartList VarDeclPartList;

    public VarBrace (Type Type, String I2, Braces Braces, VarDeclPartList VarDeclPartList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.Braces=Braces;
        if(Braces!=null) Braces.setParent(this);
        this.VarDeclPartList=VarDeclPartList;
        if(VarDeclPartList!=null) VarDeclPartList.setParent(this);
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

    public Braces getBraces() {
        return Braces;
    }

    public void setBraces(Braces Braces) {
        this.Braces=Braces;
    }

    public VarDeclPartList getVarDeclPartList() {
        return VarDeclPartList;
    }

    public void setVarDeclPartList(VarDeclPartList VarDeclPartList) {
        this.VarDeclPartList=VarDeclPartList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Braces!=null) Braces.accept(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Braces!=null) Braces.traverseTopDown(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Braces!=null) Braces.traverseBottomUp(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarBrace(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(Braces!=null)
            buffer.append(Braces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclPartList!=null)
            buffer.append(VarDeclPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarBrace]");
        return buffer.toString();
    }
}
