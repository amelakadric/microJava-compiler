// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class NamespaceListOpt extends NamespaceList {

    private NamespaceList NamespaceList;
    private Names Names;

    public NamespaceListOpt (NamespaceList NamespaceList, Names Names) {
        this.NamespaceList=NamespaceList;
        if(NamespaceList!=null) NamespaceList.setParent(this);
        this.Names=Names;
        if(Names!=null) Names.setParent(this);
    }

    public NamespaceList getNamespaceList() {
        return NamespaceList;
    }

    public void setNamespaceList(NamespaceList NamespaceList) {
        this.NamespaceList=NamespaceList;
    }

    public Names getNames() {
        return Names;
    }

    public void setNames(Names Names) {
        this.Names=Names;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.accept(visitor);
        if(Names!=null) Names.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceList!=null) NamespaceList.traverseTopDown(visitor);
        if(Names!=null) Names.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.traverseBottomUp(visitor);
        if(Names!=null) Names.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceListOpt(\n");

        if(NamespaceList!=null)
            buffer.append(NamespaceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Names!=null)
            buffer.append(Names.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceListOpt]");
        return buffer.toString();
    }
}
