// generated with ast extension for cup
// version 0.8
// 24/5/2024 17:34:49


package rs.ac.bg.etf.pp1.ast;

public class DeclListMore extends DeclList {

    private DeclList DeclList;
    private DeclOne DeclOne;

    public DeclListMore (DeclList DeclList, DeclOne DeclOne) {
        this.DeclList=DeclList;
        if(DeclList!=null) DeclList.setParent(this);
        this.DeclOne=DeclOne;
        if(DeclOne!=null) DeclOne.setParent(this);
    }

    public DeclList getDeclList() {
        return DeclList;
    }

    public void setDeclList(DeclList DeclList) {
        this.DeclList=DeclList;
    }

    public DeclOne getDeclOne() {
        return DeclOne;
    }

    public void setDeclOne(DeclOne DeclOne) {
        this.DeclOne=DeclOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclList!=null) DeclList.accept(visitor);
        if(DeclOne!=null) DeclOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclList!=null) DeclList.traverseTopDown(visitor);
        if(DeclOne!=null) DeclOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclList!=null) DeclList.traverseBottomUp(visitor);
        if(DeclOne!=null) DeclOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListMore(\n");

        if(DeclList!=null)
            buffer.append(DeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclOne!=null)
            buffer.append(DeclOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListMore]");
        return buffer.toString();
    }
}
