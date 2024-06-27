// generated with ast extension for cup
// version 0.8
// 27/5/2024 3:27:41


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartListOne extends VarDeclPartList {

    private VarDeclPartOne VarDeclPartOne;

    public VarDeclPartListOne (VarDeclPartOne VarDeclPartOne) {
        this.VarDeclPartOne=VarDeclPartOne;
        if(VarDeclPartOne!=null) VarDeclPartOne.setParent(this);
    }

    public VarDeclPartOne getVarDeclPartOne() {
        return VarDeclPartOne;
    }

    public void setVarDeclPartOne(VarDeclPartOne VarDeclPartOne) {
        this.VarDeclPartOne=VarDeclPartOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclPartOne!=null) VarDeclPartOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclPartOne!=null) VarDeclPartOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclPartOne!=null) VarDeclPartOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartListOne(\n");

        if(VarDeclPartOne!=null)
            buffer.append(VarDeclPartOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPartListOne]");
        return buffer.toString();
    }
}
