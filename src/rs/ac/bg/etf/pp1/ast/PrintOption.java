// generated with ast extension for cup
// version 0.8
// 27/5/2024 21:43:18


package rs.ac.bg.etf.pp1.ast;

public class PrintOption extends PrintOptions {

    private Integer printNumber;

    public PrintOption (Integer printNumber) {
        this.printNumber=printNumber;
    }

    public Integer getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(Integer printNumber) {
        this.printNumber=printNumber;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintOption(\n");

        buffer.append(" "+tab+printNumber);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintOption]");
        return buffer.toString();
    }
}
