// generated with ast extension for cup
// version 0.8
// 24/5/2024 2:53:33


package rs.ac.bg.etf.pp1.ast;

public class NoVarDeclPartList extends VarDeclPartListExists {

    public NoVarDeclPartList () {
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
        buffer.append("NoVarDeclPartList(\n");

        buffer.append(tab);
        buffer.append(") [NoVarDeclPartList]");
        return buffer.toString();
    }
}
