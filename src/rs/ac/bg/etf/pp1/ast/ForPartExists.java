// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class ForPartExists extends ForPart {

    private DesignatorStatement DesignatorStatement;
    private DesignatorStatementList DesignatorStatementList;

    public ForPartExists (DesignatorStatement DesignatorStatement, DesignatorStatementList DesignatorStatementList) {
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.DesignatorStatementList=DesignatorStatementList;
        if(DesignatorStatementList!=null) DesignatorStatementList.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public DesignatorStatementList getDesignatorStatementList() {
        return DesignatorStatementList;
    }

    public void setDesignatorStatementList(DesignatorStatementList DesignatorStatementList) {
        this.DesignatorStatementList=DesignatorStatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForPartExists(\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementList!=null)
            buffer.append(DesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForPartExists]");
        return buffer.toString();
    }
}
