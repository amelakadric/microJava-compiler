// generated with ast extension for cup
// version 0.8
// 25/5/2024 18:19:4


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private MinusOption MinusOption;
    private Term Term;
    private AddopTermListExists AddopTermListExists;

    public Expr (MinusOption MinusOption, Term Term, AddopTermListExists AddopTermListExists) {
        this.MinusOption=MinusOption;
        if(MinusOption!=null) MinusOption.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopTermListExists=AddopTermListExists;
        if(AddopTermListExists!=null) AddopTermListExists.setParent(this);
    }

    public MinusOption getMinusOption() {
        return MinusOption;
    }

    public void setMinusOption(MinusOption MinusOption) {
        this.MinusOption=MinusOption;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddopTermListExists getAddopTermListExists() {
        return AddopTermListExists;
    }

    public void setAddopTermListExists(AddopTermListExists AddopTermListExists) {
        this.AddopTermListExists=AddopTermListExists;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MinusOption!=null) MinusOption.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(AddopTermListExists!=null) AddopTermListExists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusOption!=null) MinusOption.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopTermListExists!=null) AddopTermListExists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusOption!=null) MinusOption.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopTermListExists!=null) AddopTermListExists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(MinusOption!=null)
            buffer.append(MinusOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermListExists!=null)
            buffer.append(AddopTermListExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}
