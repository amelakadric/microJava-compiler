// generated with ast extension for cup
// version 0.8
// 24/5/2024 17:34:49


package rs.ac.bg.etf.pp1.ast;

public class VarErrorComma extends VarDecl {

    public VarErrorComma () {
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
        buffer.append("VarErrorComma(\n");

        buffer.append(tab);
        buffer.append(") [VarErrorComma]");
        return buffer.toString();
    }
}