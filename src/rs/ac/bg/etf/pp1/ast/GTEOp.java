// generated with ast extension for cup
// version 0.8
// 24/5/2024 4:23:13


package rs.ac.bg.etf.pp1.ast;

public class GTEOp extends Relop {

    public GTEOp () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GTEOp(\n");

        buffer.append(tab);
        buffer.append(") [GTEOp]");
        return buffer.toString();
    }
}
