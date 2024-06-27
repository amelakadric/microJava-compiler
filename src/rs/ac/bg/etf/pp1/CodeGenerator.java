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
    Struct arrayType;



    public CodeGenerator(){
        boolType = Tab.find("bool").getType();

		// arrayType = Tab.find("array").getType();
    }
	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(PrintStatement printStmt){
		if( printStmt.getExpr().obj.getType().getKind() == Struct.Array){
			Obj b = Tab.find("n");
			// b.setAdr(8);
			Obj l = Tab.insert(Obj.Var, "arrLen", Tab.intType);
			// l.setAdr(9);
			Code.loadConst(0);
			Code.store(b);
			// Get the length of the array
			Code.put(Code.dup);
			Code.put(Code.arraylength);
			// Store the length in a temporary variable
			// Code.store(n);
			Code.store(l);
			
			
			// Loop start
			// Code.l(0); // Initialize the loop counter
			int loopStart = Code.pc;
			// Code.put(Code.dup);
			Code.load(l);
			Code.load(b); // Load the array length
			Code.putFalseJump(Code.ne, 10); // Jump out of the loop if the counter >= length
			
			int jumpAddr = Code.pc - 2; // Save the address of the jump instruction
			
			// Loop body
			Code.put(Code.dup);
			// Code.put(Code.pop);	
			// Load the array reference
			Code.load(b);
			// Load the loop counter

			if(printStmt.getExpr().obj.getType().getElemType().getKind() == Struct.Char){
				Code.put(Code.baload); // Load the element at the current index
				Code.loadConst(1);
				Code.put(Code.bprint); // Print the element


			}else{
				Code.put(Code.aload); // Load the element at the current index
				Code.loadConst(5);
				Code.put(Code.print); // Print the element


			}
			
			// Increment the loop counter
			Code.load(b); // Load the loop counter
			Code.loadConst(1); // Load the increment value
			Code.put(Code.add); // Add the increment value to the loop counter
			Code.store(b); // Store the updated loop counter
			
			// Jump back to the loop start
			Code.putJump(loopStart);
			
			// Update the jump address
			Code.fixup(jumpAddr);
			
			Code.put(Code.pop); // Pop the array length from the stack
			// Code.put(Code.pop); // Pop the array length from the stack
		}
		else if(printStmt.getExpr().obj.getType() == Tab.intType || printStmt.getExpr().obj.getType() == boolType){
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
		 
		else{
			Code.loadConst(5);
			Code.put(Code.print);
		}

	
		
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
		if(assignop.getDesignator().obj.getKind() == Obj.Elem){
			if(assignop.getDesignator().obj.getType().getKind() == Struct.Char){
				Code.put(Code.bastore);
			}
			else{
				Code.put(Code.astore);
			}
		}else{
			if(assignop.getDesignator().obj.getType().getKind() == Struct.Array){
				Obj o = Tab.find(assignop.getDesignator().obj.getName());
				Code.store(o);
				// Code.put(Code.pop);
			}else{	
				
				Code.store(assignop.getDesignator().obj);
			}
			
		}
	}

	// Expr 
	// public void visit(Expr expr){
	// 	if(expr.getParent() instanceof PrintStatement){
	// 		if(expr.obj.getType().getKind()==Struct.Array){
	// 			// Code.put(Code.pop);
	// 		Code.load(expr.obj);
				
	// 		}
	// 	}
	// }
	//visit DesignatorInc
	public void visit(DesignatorInc inc){
		Code.load(inc.getDesignator().obj);

		if(inc.getDesignator().obj.getKind() == Obj.Elem){
			Code.put(Code.dup2);
		}
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}

	//visit DesignatorDec
	public void visit(DesignatorDec dec){
		Code.load(dec.getDesignator().obj);

		if(dec.getDesignator().obj.getKind() == Obj.Elem){
			Code.put(Code.dup2);
		}
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}


	//visit method for Designator 
	public void visit(Designator designator){	
		// if( designator.getParent() instanceof DesignatorInc || designator.getParent() instanceof DesignatorDec){
			// if (designator.getDesignatorOptions() instanceof DesignatorOption) {
				// Obj niz = Tab.find(designator.getDesignatorName().getVarName());
				// Code.load(niz);
			// 	Code.put(Code.dup2);
			// 	Code.put(Code.pop);
			// }
			// else
			//  if(designator.getParent() instanceof DesignatorInc || designator.getParent() instanceof DesignatorDec){
			// 	Code.load(designator.obj);
			// }	
		// }
		// else
		// if(designator.getDesignatorOptions() instanceof DesignatorOption){
	
		// }
		 if (designator.getParent().getParent().getParent().getParent() instanceof PrintStatement){
			if(designator.obj.getType().getKind() == Struct.Array){
				Obj o = Tab.find(designator.getDesignatorName().getVarName());
				Code.load(o);
				// Code.put(Code.pop);
			}else{	
				Code.load(designator.obj);
			}
		}	


		// System.err.println(Tab.currentLevel);
		// else{
		// 	Code.load(designator.obj);
		// }	

	}
	//DesignatorName
	public void visit(DesignatorName designatorName){
			// if(!(designatorName.getParent().getParent() instanceof DesignatorDec )
			// && !(designatorName.getParent().getParent() instanceof DesignatorInc)
			// && 
			if(!(designatorName.getParent().getParent().getParent().getParent().getParent() instanceof PrintStatement)){
				Obj o = Tab.find(designatorName.getVarName());
				Code.load(o);
			}
			
	}

	//DesignatorOption
	public void visit(DesignatorOption designatorOption){
		// Code.loadConst(designatorOption.getExpr().obj.getAdr());
		// Code.loadConst(8);
		// Code.put(Code.pop);
	}
	//NoDesignatorOption
	public void visit(NoDesignatorOptions noDesignatorOption){
		if(!(noDesignatorOption.getParent().getParent().getParent().getParent().getParent() instanceof PrintStatement)
		||!(noDesignatorOption.getParent().getParent().getParent().getParent() instanceof Expr)){
			Code.put(Code.pop);

		}
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
		if(newFactor.getType().struct == Tab.intType || newFactor.getType().struct == boolType){
			Code.put(1);
		}else{
			Code.put(0);
		}
	}

	//visit method for RangeFactor
	public void visit(RangeFactor rangeFactor){
		Obj n = Tab.insert(Obj.Var, "$$$", Tab.intType);
		// n.setAdr(7);

		//generate code for range factor
		Code.put(Code.dup);
		Code.put(Code.newarray);
		Code.put(1);
				
		
		// Loop start
		Code.loadConst(0);
		Code.store(n);
		int loopStart = Code.pc;
		Code.put(Code.dup2);
		Code.put(Code.pop);
		Code.load(n);
		Code.putFalseJump(Code.ne, 10); // Jump out of the loop if i == n
		
		int jumpAddr = Code.pc - 2; // Save the address of the jump instruction
		
		// Loop body
		Code.put(Code.dup);
		Code.load(n);
		Code.load(n);
		Code.put(Code.astore);
		
		// // Increment i
		Code.load(n);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(n); //nece da storuje u n

		// // Jump back to the loop start
		Code.putJump( loopStart);
		
		// // Update the jump address
		Code.fixup(jumpAddr);

		Code.store(n);
		Code.put(Code.pop);
		Code.load(n);
		
		
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
