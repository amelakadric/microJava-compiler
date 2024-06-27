// generated with ast extension for cup
// version 0.8
// 26/5/2024 23:36:8


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOptionsListMany extends ConstDeclOptionsList {

    private ConstDeclOptionsList ConstDeclOptionsList;
    private ConstOne ConstOne;

    public ConstDeclOptionsListMany (ConstDeclOptionsList ConstDeclOptionsList, ConstOne ConstOne) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.setParent(this);
        this.ConstOne=ConstOne;
        if(ConstOne!=null) ConstOne.setParent(this);
    }

    public ConstDeclOptionsList getConstDeclOptionsList() {
        return ConstDeclOptionsList;
    }

    public void setConstDeclOptionsList(ConstDeclOptionsList ConstDeclOptionsList) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
    }

    public ConstOne getConstOne() {
        return ConstOne;
    }

    public void setConstOne(ConstOne ConstOne) {
        this.ConstOne=ConstOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.accept(visitor);
        if(ConstOne!=null) ConstOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseTopDown(visitor);
        if(ConstOne!=null) ConstOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseBottomUp(visitor);
        if(ConstOne!=null) ConstOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclOptionsListMany(\n");

        if(ConstDeclOptionsList!=null)
            buffer.append(ConstDeclOptionsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstOne!=null)
            buffer.append(ConstOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOptionsListMany]");
        return buffer.toString();
    }
}
