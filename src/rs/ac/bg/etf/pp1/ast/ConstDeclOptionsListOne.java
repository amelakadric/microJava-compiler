// generated with ast extension for cup
// version 0.8
// 26/5/2024 23:36:8


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOptionsListOne extends ConstDeclOptionsList {

    private ConstOne ConstOne;

    public ConstDeclOptionsListOne (ConstOne ConstOne) {
        this.ConstOne=ConstOne;
        if(ConstOne!=null) ConstOne.setParent(this);
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
        if(ConstOne!=null) ConstOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstOne!=null) ConstOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstOne!=null) ConstOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclOptionsListOne(\n");

        if(ConstOne!=null)
            buffer.append(ConstOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOptionsListOne]");
        return buffer.toString();
    }
}
