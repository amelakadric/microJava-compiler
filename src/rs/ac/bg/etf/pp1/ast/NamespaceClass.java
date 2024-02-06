// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class NamespaceClass extends Names {

    private String I1;
    private DeclOptionsList DeclOptionsList;
    private MethodDeclList MethodDeclList;

    public NamespaceClass (String I1, DeclOptionsList DeclOptionsList, MethodDeclList MethodDeclList) {
        this.I1=I1;
        this.DeclOptionsList=DeclOptionsList;
        if(DeclOptionsList!=null) DeclOptionsList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DeclOptionsList getDeclOptionsList() {
        return DeclOptionsList;
    }

    public void setDeclOptionsList(DeclOptionsList DeclOptionsList) {
        this.DeclOptionsList=DeclOptionsList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclOptionsList!=null) DeclOptionsList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclOptionsList!=null) DeclOptionsList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclOptionsList!=null) DeclOptionsList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceClass(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DeclOptionsList!=null)
            buffer.append(DeclOptionsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceClass]");
        return buffer.toString();
    }
}
