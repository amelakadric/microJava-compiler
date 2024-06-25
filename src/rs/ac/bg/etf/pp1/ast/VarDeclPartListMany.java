// generated with ast extension for cup
// version 0.8
// 25/5/2024 23:30:55


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartListMany extends VarDeclPartList {

    private VarDeclPartOne VarDeclPartOne;
    private VarDeclPartList VarDeclPartList;

    public VarDeclPartListMany (VarDeclPartOne VarDeclPartOne, VarDeclPartList VarDeclPartList) {
        this.VarDeclPartOne=VarDeclPartOne;
        if(VarDeclPartOne!=null) VarDeclPartOne.setParent(this);
        this.VarDeclPartList=VarDeclPartList;
        if(VarDeclPartList!=null) VarDeclPartList.setParent(this);
    }

    public VarDeclPartOne getVarDeclPartOne() {
        return VarDeclPartOne;
    }

    public void setVarDeclPartOne(VarDeclPartOne VarDeclPartOne) {
        this.VarDeclPartOne=VarDeclPartOne;
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
        if(VarDeclPartOne!=null) VarDeclPartOne.accept(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclPartOne!=null) VarDeclPartOne.traverseTopDown(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclPartOne!=null) VarDeclPartOne.traverseBottomUp(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartListMany(\n");

        if(VarDeclPartOne!=null)
            buffer.append(VarDeclPartOne.toString("  "+tab));
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
