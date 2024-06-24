package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	int nVars;
    Struct currentVarType = null;
    Struct currentConstType = null;
    

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

    public void visit(VarDeclOne varDecl){
        Obj varNode = Tab.find(varDecl.getVarName());
        currentVarType = varDecl.getType().struct;
        currentConstType=null;

        if(varNode != Tab.noObj){
            report_error("Greska na liniji " + varDecl.getLine() + ": Promenljiva " + varDecl.getVarName() + " je vec deklarisana!", null);
        }else{
            Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
            report_info("Deklarisana promenljiva "+ varDecl.getVarName(), varDecl);
            varDeclCount++;
        }
		
	}

    //visitor method for VarDeclPartOne
    public void visit(VarDeclPartOne varDeclPartOne){
        Obj varNode = Tab.find(varDeclPartOne.getVarName());
        if(varNode != Tab.noObj || currentVarType == null){
            report_error("Greska na liniji " + varDeclPartOne.getLine() + ": Promenljiva " + varDeclPartOne.getVarName() + " je vec deklarisana!", null);
        }else{
            Tab.insert(Obj.Var, varDeclPartOne.getVarName(), currentVarType);
            report_info("Deklarisana promenljiva "+ varDeclPartOne.getVarName(), varDeclPartOne);
            varDeclCount++;
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
//    public void visit(BoolConstant boolConst) {
//         Obj constNode = Tab.find(boolConst.getConstName());
//         if (constNode != Tab.noObj) {
//             report_error("Greska na liniji " + boolConst.getLine() + ": Konstanta " + boolConst.getConstName() + " je vec deklarisana!", null);
//         } else {
//             if (currentConstType.getKind() != Struct.Bool) {
//                 report_error("Greska: Konstanta " + boolConst.getConstName() + " nije ispravnog tipa", boolConst);
//             } else {
//                 Obj constBoolNode = Tab.insert(Obj.Con, boolConst.getConstName(), boolType);
//                 // constBoolNode.setAdr(boolConst.getValue() ? 1 : 0);
//                 // report_info("Deklarisana bool konstanta: " + boolConst.getConstName() + "= " + boolConst.getValue(), boolConst);
//             }
//         }
//     }

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

    //visitor method for FunctionMain
    

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
        
        returnFound = false;
        currentMethod = null;
    }
    
    // public void visit(Designator designator){
    // 	Obj obj = Tab.find(designator.getName());
    // 	if(obj == Tab.noObj){
	// 		report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
    // 	}
    // 	designator.obj = obj;
    // }
    
    
    // public void visit(FuncCall funcCall){
    // 	Obj func = funcCall.getDesignator().obj;
    // 	if(Obj.Meth == func.getKind()){
	// 		report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
	// 		funcCall.struct = func.getType();
    // 	}else{
	// 		report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
	// 		funcCall.struct = Tab.noType;
    // 	}
    // }
    
    // public void visit(Term term){
    // 	term.struct = term.getFactor().struct;
    // }
    
    // public void visit(TermExpr termExpr){
    // 	termExpr.struct = termExpr.getTerm().struct;
    // }
    
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
    
    // public void visit(Const cnst){
    // 	cnst.struct = Tab.intType;
    // }
    
    // public void visit(Var var){
    // 	var.struct = var.getDesignator().obj.getType();
    // }
    
    // public void visit(ReturnExpr returnExpr){
    // 	returnFound = true;
    // 	Struct currMethType = currentMethod.getType();
    // 	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
	// 		report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    // 	}
    // }
    
    // public void visit(Assignment assignment){
    // 	if(!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
    // 		report_error("Greska na liniji " + assignment.getLine() + " : " + "nekompatibilni tipovi u dodeli vrednosti! ", null);
    // }
    
    
    public boolean passed(){
    	return !errorDetected;
    }
    
}
