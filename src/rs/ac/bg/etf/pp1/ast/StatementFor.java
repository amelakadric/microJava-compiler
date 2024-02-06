// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private ForPart ForPart;
    private CondFact CondFact;
    private ForPart ForPart1;
    private Statement Statement;

    public StatementFor (ForPart ForPart, CondFact CondFact, ForPart ForPart1, Statement Statement) {
        this.ForPart=ForPart;
        if(ForPart!=null) ForPart.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.ForPart1=ForPart1;
        if(ForPart1!=null) ForPart1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForPart getForPart() {
        return ForPart;
    }

    public void setForPart(ForPart ForPart) {
        this.ForPart=ForPart;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public ForPart getForPart1() {
        return ForPart1;
    }

    public void setForPart1(ForPart ForPart1) {
        this.ForPart1=ForPart1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForPart!=null) ForPart.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
        if(ForPart1!=null) ForPart1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForPart!=null) ForPart.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(ForPart1!=null) ForPart1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForPart!=null) ForPart.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(ForPart1!=null) ForPart1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(ForPart!=null)
            buffer.append(ForPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForPart1!=null)
            buffer.append(ForPart1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
