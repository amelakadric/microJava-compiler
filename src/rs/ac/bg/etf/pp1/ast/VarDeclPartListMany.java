// generated with ast extension for cup
// version 0.8
// 23/5/2024 20:53:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclPartListMany extends VarDeclPartList {

    private String varName;
    private SqBracesOption SqBracesOption;
    private VarDeclPartList VarDeclPartList;

    public VarDeclPartListMany (String varName, SqBracesOption SqBracesOption, VarDeclPartList VarDeclPartList) {
        this.varName=varName;
        this.SqBracesOption=SqBracesOption;
        if(SqBracesOption!=null) SqBracesOption.setParent(this);
        this.VarDeclPartList=VarDeclPartList;
        if(VarDeclPartList!=null) VarDeclPartList.setParent(this);
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

    public VarDeclPartList getVarDeclPartList() {
        return VarDeclPartList;
    }

    public void setVarDeclPartList(VarDeclPartList VarDeclPartList) {
        this.VarDeclPartList=VarDeclPartList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SqBracesOption!=null) SqBracesOption.accept(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SqBracesOption!=null) SqBracesOption.traverseTopDown(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SqBracesOption!=null) SqBracesOption.traverseBottomUp(visitor);
        if(VarDeclPartList!=null) VarDeclPartList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclPartListMany(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SqBracesOption!=null)
            buffer.append(SqBracesOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclPartList!=null)
            buffer.append(VarDeclPartList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclPartListMany]");
        return buffer.toString();
    }
}
