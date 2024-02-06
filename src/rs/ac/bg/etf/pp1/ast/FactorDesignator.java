// generated with ast extension for cup
// version 0.8
// 5/1/2024 21:55:54


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private ActParsParen ActParsParen;

    public FactorDesignator (Designator Designator, ActParsParen ActParsParen) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsParen=ActParsParen;
        if(ActParsParen!=null) ActParsParen.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsParen getActParsParen() {
        return ActParsParen;
    }

    public void setActParsParen(ActParsParen ActParsParen) {
        this.ActParsParen=ActParsParen;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsParen!=null) ActParsParen.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsParen!=null) ActParsParen.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsParen!=null) ActParsParen.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsParen!=null)
            buffer.append(ActParsParen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
