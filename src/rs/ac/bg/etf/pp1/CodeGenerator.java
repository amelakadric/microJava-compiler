package rs.ac.bg.etf.pp1;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
    Struct boolType;


    public CodeGenerator(){
        boolType = Tab.find("bool").getType();
    }
	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(PrintStatement printStmt){
		if(printStmt.getExpr().obj.getType() == Tab.intType || printStmt.getExpr().obj.getType() == boolType){
			if(printStmt.getPrintOptions() instanceof PrintOption){
				Code.loadConst(((PrintOption)printStmt.getPrintOptions()).getPrintNumber());
			}
			else{
				Code.loadConst(5);
			}
			Code.put(Code.print);
		}else if(printStmt.getExpr().obj.getType() == Tab.charType){
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		// if(printStmt.getExpr().obj.getType().getKind() == Struct.Array){
		// 	if(printStmt.getExpr().obj.getType().getElemType() == Tab.intType || printStmt.getExpr().obj.getType().getElemType() == boolType){
		// 		Code.put(Code.print);
		// 	}else if(printStmt.getExpr().obj.getType().getElemType() == Tab.charType){
		// 		Code.put(Code.bprint);
		// 	}
		// } else {
			// Code for handling non-array type
			// Add your logic here
		// }
		
	}


	public void visit(FunctionTypeName functionTypeName){
		
		if("main".equalsIgnoreCase(functionTypeName.getFuncName())){
			mainPc = Code.pc;
		}
		functionTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = functionTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(0 + varCnt.getCount());
	
	}
	
	public void visit(FunctionMain functionMain){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}


	//visit ReadStatement
	public void visit(ReadStatement readStmt){
		if(readStmt.getDesignator().obj.getType() == Tab.intType || readStmt.getDesignator().obj.getType() == boolType){
			Code.put(Code.read);
		}else{
			Code.put(Code.bread);
		}
		Code.store(readStmt.getDesignator().obj);
	}

	//visit DesignatorAssignopExpr
	public void visit(DesignatorAssignopExpr assignop){
		Code.store(assignop.getDesignator().obj);
	}
	//visit DesignatorInc
	public void visit(DesignatorInc inc){
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}

	//visit DesignatorDec
	public void visit(DesignatorDec dec){
		Code.load(dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}


	//visit method for Designator 
	public void visit(Designator designator){
		// if(designator.getParent() instanceof DesignatorAssignopExpr 
		// || designator.getParent() instanceof DesignatorInc 
		// || designator.getParent() instanceof DesignatorDec){
		// 	return;
		// }
		// if(designator.getParent() instanceof DesignatorFactor){
		// 	Code.put(Code.dup);
		// }
		// else{
		// 	Code.load(designator.obj);
		// }
		Code.load(designator.obj);

	}


	//visit method for Minus
	public void visit(Minus minus){
		Code.put(Code.neg);
	}

	//visit method for NumConstFactor
	public void visit(NumConstFactor cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getValue());
		
		Code.load(con);
	}

    //visitor method for CharConstFactor
    public void visit(CharConstFactor cnst){
        Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
        con.setLevel(0);
        con.setAdr(cnst.getValue());
        
        Code.load(con);
    }
    
    //visitor method for BoolConstFactor
    public void visit(BoolConstFactor cnst){
        Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
        con.setLevel(0);
        con.setAdr(cnst.getValue());
        
        Code.load(con);
    }

	//visit method for NewFactor
	public void visit(NewFactor newFactor){
		Code.put(Code.newarray);
		if(newFactor.getType().struct == Tab.intType){
			Code.put(1);
		}else{
			Code.put(0);
		}
	}

	//visit method for RangeFactor
	public void visit(RangeFactor rangeFactor){
	
	}


	//visit method for MulopFactorListOne
	public void visit(MulopFactorListOne mulopFactorListOne){
		if(mulopFactorListOne.getMulop() instanceof MulOpMul){
			Code.put(Code.mul);
		}else if(mulopFactorListOne.getMulop() instanceof DivOp){
			Code.put(Code.div);
		}else{
			Code.put(Code.rem);
		}
	}

	//visit method for MulopFactorListMany
	public void visit(MulopFactorListMany mulopFactorListMany){
		if(mulopFactorListMany.getMulop() instanceof MulOpMul){
			Code.put(Code.mul);
		}else if(mulopFactorListMany.getMulop() instanceof DivOp){
			Code.put(Code.div);
		}else{
			Code.put(Code.rem);
		}
	}

	//visit method for AddopTermListOne
	public void visit(AddopTermListOne addopTermListOne){
		if(addopTermListOne.getAddop() instanceof PlusOp){
			Code.put(Code.add);
		}else{
			Code.put(Code.sub);
		}
	}

	// AddopTermListMany
	public void visit(AddopTermListMany addopTermListMany){
		if(addopTermListMany.getAddop() instanceof PlusOp){
			Code.put(Code.add);
		}else{
			Code.put(Code.sub);
		}
	}




	




	


	// public void visit(Assignment assignment){
	// 	Code.store(assignment.getDesignator().obj);
	// }
	
	// public void visit(Designator designator){
	// 	SyntaxNode parent = designator.getParent();
		
	// 	if(Assignment.class != parent.getClass() && FuncCall.class != parent.getClass() && ProcCall.class != parent.getClass()){
	// 		Code.load(designator.obj);
	// 	}
	// }
	
	// public void visit(FuncCall funcCall){
	// 	Obj functionObj = funcCall.getDesignator().obj;
	// 	int offset = functionObj.getAdr() - Code.pc;
	// 	Code.put(Code.call);
		
	// 	Code.put2(offset);
	// }
	
	// public void visit(ProcCall procCall){
	// 	Obj functionObj = procCall.getDesignator().obj;
	// 	int offset = functionObj.getAdr() - Code.pc;
	// 	Code.put(Code.call);
	// 	Code.put2(offset);
	// 	if(procCall.getDesignator().obj.getType() != Tab.noType){
	// 		Code.put(Code.pop);
	// 	}
	// }
	
	// public void visit(ReturnExpr returnExpr){
	// 	Code.put(Code.exit);
	// 	Code.put(Code.return_);
	// }
	
	// public void visit(ReturnNoExpr returnNoExpr){
	// 	Code.put(Code.exit);
	// 	Code.put(Code.return_);
	// }
	
	// public void visit(AddExpr addExpr){
	// 	Code.put(Code.add);
	// }
}
