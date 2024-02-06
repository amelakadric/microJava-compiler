// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOnee extends ConstDeclOne {

    private String I1;
    private ConstOptions ConstOptions;

    public ConstDeclOnee (String I1, ConstOptions ConstOptions) {
        this.I1=I1;
        this.ConstOptions=ConstOptions;
        if(ConstOptions!=null) ConstOptions.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ConstOptions getConstOptions() {
        return ConstOptions;
    }

    public void setConstOptions(ConstOptions ConstOptions) {
        this.ConstOptions=ConstOptions;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstOptions!=null) ConstOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstOptions!=null) ConstOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstOptions!=null) ConstOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclOnee(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ConstOptions!=null)
            buffer.append(ConstOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOnee]");
        return buffer.toString();
    }
}
