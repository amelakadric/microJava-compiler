// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class DeclOptionsListMany extends DeclOptionsList {

    private DeclOptionsList DeclOptionsList;
    private DeclOptions DeclOptions;

    public DeclOptionsListMany (DeclOptionsList DeclOptionsList, DeclOptions DeclOptions) {
        this.DeclOptionsList=DeclOptionsList;
        if(DeclOptionsList!=null) DeclOptionsList.setParent(this);
        this.DeclOptions=DeclOptions;
        if(DeclOptions!=null) DeclOptions.setParent(this);
    }

    public DeclOptionsList getDeclOptionsList() {
        return DeclOptionsList;
    }

    public void setDeclOptionsList(DeclOptionsList DeclOptionsList) {
        this.DeclOptionsList=DeclOptionsList;
    }

    public DeclOptions getDeclOptions() {
        return DeclOptions;
    }

    public void setDeclOptions(DeclOptions DeclOptions) {
        this.DeclOptions=DeclOptions;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclOptionsList!=null) DeclOptionsList.accept(visitor);
        if(DeclOptions!=null) DeclOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclOptionsList!=null) DeclOptionsList.traverseTopDown(visitor);
        if(DeclOptions!=null) DeclOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclOptionsList!=null) DeclOptionsList.traverseBottomUp(visitor);
        if(DeclOptions!=null) DeclOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclOptionsListMany(\n");

        if(DeclOptionsList!=null)
            buffer.append(DeclOptionsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclOptions!=null)
            buffer.append(DeclOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclOptionsListMany]");
        return buffer.toString();
    }
}
