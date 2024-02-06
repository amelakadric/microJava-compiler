// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartListMany extends VarDeclPartList {

    private VarDeclPart VarDeclPart;
    private VarDeclPartList VarDeclPartList;

    public VarDeclPartListMany (VarDeclPart VarDeclPart, VarDeclPartList VarDeclPartList) {
        this.VarDeclPart=VarDeclPart;
        if(VarDeclPart!=null) VarDeclPart.setParent(this);
        this.VarDeclPartList=VarDeclPartList;
        if(VarDeclPartList!=null) VarDeclPartList.setParent(this);
    }

    public VarDeclPart getVarDeclPart() {
        return VarDeclPart;
    }

    public void setVarDeclPart(VarDeclPart VarDeclPart) {
        this.VarDeclPart=VarDeclPart;
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
        if(VarDeclPart!=null) VarDeclPart.accept(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclPart!=null) VarDeclPart.traverseTopDown(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclPart!=null) VarDeclPart.traverseBottomUp(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartListMany(\n");

        if(VarDeclPart!=null)
            buffer.append(VarDeclPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclPartList!=null)
            buffer.append(VarDeclPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPartListMany]");
        return buffer.toString();
    }
}
