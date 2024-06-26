// generated with ast extension for cup
// version 0.8
// 26/5/2024 21:54:25


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends Statement {

    private Expr Expr;
    private PrintOptions PrintOptions;

    public PrintStatement (Expr Expr, PrintOptions PrintOptions) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintOptions=PrintOptions;
        if(PrintOptions!=null) PrintOptions.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PrintOptions getPrintOptions() {
        return PrintOptions;
    }

    public void setPrintOptions(PrintOptions PrintOptions) {
        this.PrintOptions=PrintOptions;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PrintOptions!=null) PrintOptions.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintOptions!=null) PrintOptions.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintOptions!=null) PrintOptions.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintOptions!=null)
            buffer.append(PrintOptions.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
