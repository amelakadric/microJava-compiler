// generated with ast extension for cup
// version 0.8
// 23/5/2024 20:53:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartListOne extends VarDeclPartList {

    private String varName;
    private SqBracesOption SqBracesOption;

    public VarDeclPartListOne (String varName, SqBracesOption SqBracesOption) {
        this.varName=varName;
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public SqBracesOption getSqBracesOption() {
        return SqBracesOption;
    }

    public void setSqBracesOption(SqBracesOption SqBracesOption) {
        this.SqBracesOption=SqBracesOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartListOne(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SqBracesOption!=null)
            buffer.append(SqBracesOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPartListOne]");
        return buffer.toString();
    }
}
