package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
    int readCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	int nVars;
    Struct currentVarType = null;
    Struct currentConstType = null;
    boolean isFinal = false;
    

    Struct boolType;
	
	Logger log = Logger.getLogger(getClass());

    public SemanticAnalyzer() {
        boolType = Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool)).getType();
        
    }


	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	
    public void visit(PrintStatement print) {
        printCallCount++;
        if (print.getExpr().obj.getType().getKind() == Struct.Array) {
            // Check if the array is of type int
            if (print.getExpr().obj.getType().getElemType().getKind() == Struct.Int) {
                report_info("Poziv funkcije print za niz tipa int", print);
            } else  if (print.getExpr().obj.getType().getElemType().getKind() == Struct.Char){
                report_info("Poziv funkcije print za niz tipa char", print);
            } else {
                report_error("Greska: Poziv funkcije print za niz koji nije tipa int ili char", print);
            }
        }
        else if (print.getExpr().obj.getType().getKind() == Struct.Int) {
            report_info("Poziv funkcije print za int", print);
        } else if (print.getExpr().obj.getType().getKind() == Struct.Char) {
            report_info("Poziv funkcije print za char", print);
        } else if (print.getExpr().obj.getType().getKind() == Struct.Bool) {
            report_info("Poziv funkcije print za bool", print);
        } else {
            report_error("Greska: Poziv funkcije print za tip koji nije int, char ili bool", print);
        }
	}

    public void visit(ReadStatement read) {
        readCallCount++;
        if (read.getDesignator().obj.getType().getKind() == Struct.Array) {
            // Check if the array is of type int
            if (read.getDesignator().obj.getType().getElemType().getKind() == Struct.Int) {
                report_info("Poziv funkcije read za niz tipa int", read);
            } else  if (read.getDesignator().obj.getType().getElemType().getKind() == Struct.Char){
                report_info("Poziv funkcije read za niz tipa char", read);
            } else {
                report_error("Greska: Poziv funkcije read za niz koji nije tipa int ili char", read);
            }
        }
        else if (read.getDesignator().obj.getType().getKind() == Struct.Int) {
            report_info("Poziv funkcije read za int", read);
        } else if (read.getDesignator().obj.getType().getKind() == Struct.Char) {
            report_info("Poziv funkcije read za char", read);
        } else if (read.getDesignator().obj.getType().getKind() == Struct.Bool) {
            report_info("Poziv funkcije read za bool", read);
        } else {
            report_error("Greska: Poziv funkcije read za tip koji nije int, char ili bool", read);
        }
    }
    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(Type type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
                currentConstType = typeNode.getType();
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }

    //visitor method for VarDeclOne with case for array declaration
    public void visit(VarDeclOne varDeclOne){
        currentVarType = varDeclOne.getType().struct;
        currentConstType=null;;
        Obj varNode = Tab.find(varDeclOne.getVarName());
        if(varNode != Tab.noObj || currentVarType == null){
            report_error("Greska na liniji " + varDeclOne.getLine() + ": Promenljiva " + varDeclOne.getVarName() + " je vec deklarisana!", null);
        }else{

            //check if isArray is instance
            if(varDeclOne.getSqBracesOption() instanceof SqBraces){
                Struct arrayType = new Struct(Struct.Array, currentVarType);
                Obj obj =Tab.insert(Obj.Var, varDeclOne.getVarName(), arrayType);
                if(varDeclOne.getParent() instanceof VarDeclFinal){
                    isFinal = true;
                    obj.setFpPos(1);
                }
                else{
                    obj.setFpPos(0);
                }
                report_info("Deklarisana promenljiva "+ varDeclOne.getVarName() + " tipa niz", varDeclOne);
                varDeclCount++;
            }else{
                Obj obj = Tab.insert(Obj.Var, varDeclOne.getVarName(), currentVarType);
                if(varDeclOne.getParent() instanceof VarDeclFinal){
                    isFinal = true;
                    obj.setFpPos(1);
                }
                else{
                    obj.setFpPos(0);
                }
                report_info("Deklarisana promenljiva "+ varDeclOne.getVarName(), varDeclOne);
                varDeclCount++;
            }
        }
    }

    //VarDecl
    public void visit(VarDeclFinal varDeclFinal){
        isFinal = false;
    }

    //visitor method for VarDeclPartOne
    public void visit(VarDeclPartOne varDeclPartOne){
        Obj varNode = Tab.find(varDeclPartOne.getVarName());
        if(varNode != Tab.noObj || currentVarType == null){
            report_error("Greska na liniji " + varDeclPartOne.getLine() + ": Promenljiva " + varDeclPartOne.getVarName() + " je vec deklarisana!", null);
        }else{
             //check if isArray is instance
             if(varDeclPartOne.getSqBracesOption() instanceof SqBraces){
                Struct arrayType = new Struct(Struct.Array, currentVarType);
                Obj obj =Tab.insert(Obj.Var, varDeclPartOne.getVarName(), arrayType);
                if(isFinal){
                    obj.setFpPos(1);
                }
                else{
                    obj.setFpPos(0);
                }
                report_info("Deklarisana promenljiva "+ varDeclPartOne.getVarName() + " tipa niz", varDeclPartOne);
                varDeclCount++;
            }else{
                Obj obj=Tab.insert(Obj.Var, varDeclPartOne.getVarName(), currentVarType);
                if(isFinal){
                    obj.setFpPos(1);
                }
                else{
                    obj.setFpPos(0);
                }
                report_info("Deklarisana promenljiva "+ varDeclPartOne.getVarName(), varDeclPartOne);
                varDeclCount++;
            }
        
        }
    }

    //visitor method for NoVarDeclPartList
    public void visit(NoVarDeclPartList noVarDeclPartList){
        currentVarType = null;
    }


    //visitor method for NumConst
    public void visit(NumConst numConst){
        Obj constNode = Tab.find(numConst.getConstName());
        if(constNode != Tab.noObj){
            report_error("Greska na liniji " + numConst.getLine() + ": Konstanta " + numConst.getConstName() + " je vec deklarisana!", null);
        }else{
            if(currentConstType.getKind() !=  Struct.Int){
        		report_error("Greska: Konstanta " + numConst.getConstName() + " nije ispravnog tipa", numConst);	
    		}
    		else {
        		Obj constNumNode = Tab.insert(Obj.Con,  numConst.getConstName(), Tab.intType);
        		constNumNode.setAdr(numConst.getValue());
        		report_info("Deklarisana int konstanta: " + numConst.getConstName() + "= " + numConst.getValue(), numConst);
    		}
         }
    }

    //visitor method for BoolConst
   public void visit(BoolConstant boolConst) {
        Obj constNode = Tab.find(boolConst.getConstName());
        if (constNode != Tab.noObj) {
            report_error("Greska na liniji " + boolConst.getLine() + ": Konstanta " + boolConst.getConstName() + " je vec deklarisana!", null);
        } else {
            if (currentConstType.getKind() != Struct.Bool) {
                report_error("Greska: Konstanta " + boolConst.getConstName() + " nije ispravnog tipa", boolConst);
            } else {
                Obj constBoolNode = Tab.insert(Obj.Con, boolConst.getConstName(), boolType);
                constBoolNode.setAdr(boolConst.getValue());
                report_info("Deklarisana bool konstanta: " + boolConst.getConstName() + "= " + (boolConst.getValue()==1?true:false), boolConst);
            }
        }
    }

    //visitor method for CharConst
    public void visit(CharConstant charConst){
        Obj constNode = Tab.find(charConst.getConstName());
        if(constNode != Tab.noObj){
            report_error("Greska na liniji " + charConst.getLine() + ": Konstanta " + charConst.getConstName() + " je vec deklarisana!", null);
        }else{
            if(currentConstType.getKind() !=  Struct.Char){
        		report_error("Greska: Konstanta " + charConst.getConstName() + " nije ispravnog tipa", charConst);	
    		}
    		else {
        		Obj constCharNode = Tab.insert(Obj.Con,  charConst.getConstName(), Tab.charType);
        		constCharNode.setAdr(charConst.getValue());
        		report_info("Deklarisana char konstanta: " + charConst.getConstName() + "= " + charConst.getValue(), charConst);
    		}
         }
    }


    // visitor method for FunctionTypeName
    public void visit(FunctionTypeName functionTypeName){
        currentMethod = Tab.insert(Obj.Meth, functionTypeName.getFuncName(), Tab.noType);
        functionTypeName.obj = currentMethod;
        Tab.openScope();
        report_info("Obradjuje se funkcija " + functionTypeName.getFuncName(), functionTypeName);
    }
    

    //visitor method for FunctionTypeNameVoid
    public void visit(FunctionMain functionMain){
        if(!returnFound && currentMethod != null && currentMethod.getType() != Tab.noType){
            report_error("Greska na liniji " + functionMain.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
        }
        
        Tab.chainLocalSymbols(currentMethod);
        Tab.closeScope();
        report_info("Kraj funkcije "+ functionMain.getFunctionTypeName().getFuncName(), functionMain);
        
        returnFound = false;
        currentMethod = null;
    }
    

    //visitor method for Designator
    public void visit(DesignatorSingle designator){
        Obj obj = Tab.find(designator.getVarName());
        if(obj == Tab.noObj){
            report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getVarName()+" nije deklarisano! ", null);
        }
        else{
            designator.obj = obj;
        }
    }

    //visitor method for DesignatorArray
    public void visit(DesignatorArray designatorArray){
        Obj obj = Tab.find(designatorArray.getDesignatorName().getVarName());
        if(obj == Tab.noObj){
            report_error("Greska na liniji " + designatorArray.getLine()+ " : ime "+designatorArray.getDesignatorName().getVarName()+" nije deklarisano! ", null);
        }
        if(obj.getType().getKind() != Struct.Array){
            report_error("Greska na liniji " + designatorArray.getLine() + " : " + "promenljiva " + designatorArray.getDesignatorName().getVarName() + " nije niz! ", null);
        }
        else{
            designatorArray.obj = new Obj(Obj.Elem, designatorArray.getDesignatorName().getVarName(), obj.getType().getElemType());
        }
    }

    //visitor method for DesignatorAssignopExpr
    public void visit(DesignatorAssignopExpr designatorAssignopExpr){
        if(!designatorAssignopExpr.getExpr().obj.getType().assignableTo(designatorAssignopExpr.getDesignator().obj.getType()))
            report_error("Greska na liniji " + designatorAssignopExpr.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
    }

    //visitor method for DesignatorInc
    public void visit(DesignatorInc designatorInc){
        if(designatorInc.getDesignator().obj.getType() != Tab.intType){
            report_error("Greska na liniji " + designatorInc.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
    }

    //visitor method for DesignatorDec
    public void visit(DesignatorDec designatorDec){
        if(designatorDec.getDesignator().obj.getType() != Tab.intType){
            report_error("Greska na liniji " + designatorDec.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
    }

    //visitor method for Expr
    public void visit(Expr expr){
        //check if getTerm is int
        // if(expr.getTerm().struct != Tab.intType){
        //     report_error("Greska na liniji " + expr.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        // }
        expr.obj = new Obj(Obj.Con, "", expr.getTerm().struct);
		// Obj n = Tab.insert(Obj.Var, "n", Tab.intType);

    }

    //visitor method for Term
    public void visit(Term term){
        //check if getFactor is int
        // if(term.getFactor().struct != Tab.intType){
        //     report_error("Greska na liniji " + term.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        // }
        term.struct = term.getFactor().struct;
    }

    //visitor method for DesignatorFactor
    public void visit(DesignatorFactor designatorFactor){
        designatorFactor.struct = designatorFactor.getDesignator().obj.getType();
    }

    //visitor method for NumFactor
    public void visit(NumConstFactor numFactor){
        numFactor.struct = Tab.intType;
    }

    //visitor method for CharFactor
    public void visit(CharConstFactor charFactor){
        charFactor.struct = Tab.charType;
    }

    //visitor method for BoolFactor
    public void visit(BoolConstFactor boolFactor){
        boolFactor.struct = boolType;
    }

    //visitor method for NewFactor
    public void visit(NewFactor newFactor){ 
        if(!newFactor.getExpr().obj.getType().equals(Tab.intType)) {
            report_error("Greska: Izraz unutar [] mora biti tipa int", newFactor);    
            newFactor.struct = Tab.noType;
        }
        else {
            newFactor.struct = new Struct(Struct.Array,  newFactor.getType().struct);
        }
    }
    //visitor method for ExprFactor
    public void visit(ExprFactor exprFactor){
        exprFactor.struct = exprFactor.getExpr().obj.getType();
    }

    //visitor method for AddopTermListOne
    public void visit(AddopTermListOne addopTermListOne){
        if(addopTermListOne.getTerm().struct != Tab.intType){
            report_error("Greska na liniji " + addopTermListOne.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        // addopTermListOne.struct = addopTermListOne.getTerm().struct;
    }

    //visitor method for AddopTermListMany
    public void visit(AddopTermListMany addopTermListMany){
        if(addopTermListMany.getTerm().struct != Tab.intType){
            report_error("Greska na liniji " + addopTermListMany.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        // addopTermListMany.struct = addopTermListMany.getTerm().struct;
    }

    //visitor method for MulopFactorListOne
    public void visit(MulopFactorListOne mulopFactorListOne){
        if(mulopFactorListOne.getFactor().struct != Tab.intType){
            report_error("Greska na liniji " + mulopFactorListOne.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        // mulopFactorListOne.struct = mulopFactorListOne.getFactor().struct;
    }

    //visitor method for MulopFactorListMany
    public void visit(MulopFactorListMany mulopFactorListMany){
        if(mulopFactorListMany.getFactor().struct != Tab.intType){
            report_error("Greska na liniji " + mulopFactorListMany.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        // mulopFactorListMany.struct = mulopFactorListMany.getFactor().struct;
    }

    //visitor method for RangeFactor
    public void visit(RangeFactor rangeFactor){
        if(rangeFactor.getExpr().obj.getType() != Tab.intType){
            report_error("Greska na liniji " + rangeFactor.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        rangeFactor.struct = new Struct(Struct.Array, rangeFactor.getExpr().obj.getType());
    }

    //RangeStep
    public void visit( RangeStep rangeStep){
        if(rangeStep.getExpr().obj.getType() != Tab.intType || rangeStep.getExpr1().obj.getType() != Tab.intType || rangeStep.getExpr2().obj.getType() != Tab.intType){
            report_error("Greska na liniji " + rangeStep.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
        }
        rangeStep.struct = new Struct(Struct.Array, rangeStep.getExpr().obj.getType());
    }

   

    
    // public void visit(AddExpr addExpr){
    // 	Struct te = addExpr.getExpr().struct;
    // 	Struct t = addExpr.getTerm().struct;
    // 	if(te.equals(t) && te == Tab.intType){
    // 		addExpr.struct = te;
    // 	}else{
	// 		report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
	// 		addExpr.struct = Tab.noType;
    // 	}
    // }
    
 
    
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}
