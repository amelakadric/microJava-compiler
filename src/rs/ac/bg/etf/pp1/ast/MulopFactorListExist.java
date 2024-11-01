// generated with ast extension for cup
// version 0.8
// 27/5/2024 3:27:41


package rs.ac.bg.etf.pp1.ast;

public class MulopFactorListExist extends MulopFactorListExists {

    private MulopFactorList MulopFactorList;

    public MulopFactorListExist (MulopFactorList MulopFactorList) {
        this.MulopFactorList=MulopFactorList;
        if(MulopFactorList!=null) MulopFactorList.setParent(this);
    }

    public MulopFactorList getMulopFactorList() {
        return MulopFactorList;
    }

    public void setMulopFactorList(MulopFactorList MulopFactorList) {
        this.MulopFactorList=MulopFactorList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactorList!=null) MulopFactorList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactorListExist(\n");

        if(MulopFactorList!=null)
            buffer.append(MulopFactorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactorListExist]");
        return buffer.toString();
    }
}
