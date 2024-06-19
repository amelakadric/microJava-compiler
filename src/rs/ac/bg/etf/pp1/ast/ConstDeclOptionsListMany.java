// generated with ast extension for cup
// version 0.8
// 19/5/2024 16:51:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOptionsListMany extends ConstDeclOptionsList {

    private ConstDeclOptionsList ConstDeclOptionsList;
    private String I2;
    private ConstOptions ConstOptions;

    public ConstDeclOptionsListMany (ConstDeclOptionsList ConstDeclOptionsList, String I2, ConstOptions ConstOptions) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.setParent(this);
        this.I2=I2;
        this.ConstOptions=ConstOptions;
        if(ConstOptions!=null) ConstOptions.setParent(this);
    }

    public ConstDeclOptionsList getConstDeclOptionsList() {
        return ConstDeclOptionsList;
    }

    public void setConstDeclOptionsList(ConstDeclOptionsList ConstDeclOptionsList) {
        this.ConstDeclOptionsList=ConstDeclOptionsList;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.accept(visitor);
        if(ConstOptions!=null) ConstOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseTopDown(visitor);
        if(ConstOptions!=null) ConstOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclOptionsList!=null) ConstDeclOptionsList.traverseBottomUp(visitor);
        if(ConstOptions!=null) ConstOptions.traverseBottomUp(visitor);
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

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(ConstOptions!=null)
            buffer.append(ConstOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOptionsListMany]");
        return buffer.toString();
    }
}
