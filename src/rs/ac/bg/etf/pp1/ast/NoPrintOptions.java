// generated with ast extension for cup
// version 0.8
// 27/5/2024 22:44:29


package rs.ac.bg.etf.pp1.ast;

public class NoPrintOptions extends PrintOptions {

    public NoPrintOptions () {
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
        buffer.append("NoPrintOptions(\n");

        buffer.append(tab);
        buffer.append(") [NoPrintOptions]");
        return buffer.toString();
    }
}
