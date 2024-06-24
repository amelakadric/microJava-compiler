// generated with ast extension for cup
// version 0.8
// 24/5/2024 17:34:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOptionsListExist extends ConstDeclOptionsListExists {

    private ConstDeclOptionsList ConstDeclOptionsList;

    public ConstDeclOptionsListExist (ConstDeclOptionsList ConstDeclOptionsList) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.setParent(this);
    }

    public ConstDeclOptionsList getConstDeclOptionsList() {
        return ConstDeclOptionsList;
    }

    public void setConstDeclOptionsList(ConstDeclOptionsList ConstDeclOptionsList) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclOptionsListExist(\n");

        if(ConstDeclOptionsList!=null)
            buffer.append(ConstDeclOptionsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOptionsListExist]");
        return buffer.toString();
    }
}
