package rs.ac.bg.etf.pp1;
import java.util.Collection;
import java.util.List;

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
		Obj n = Tab.insert(Obj.Var, "amela", Tab.intType);
		Obj r = Tab.insert(Obj.Var, "rrr", Tab.intType);


    }

	public Obj findProgramObject() {
		Collection<Obj> symbols = Tab.currentScope().getLocals().symbols();
		return symbols.stream()
					  .filter(obj -> obj.getType() == Tab.noType)
					  .findFirst()
					  .orElse(Tab.noObj);
	}
	
	public Obj findObjectInProgram(String name) {
		Obj programObj = findProgramObject();
		if (programObj != Tab.noObj) {
			return programObj.getLocalSymbols().stream()
							 .filter(local -> name.equals(local.getName()))
							 .findFirst()
							 .orElse(Tab.noObj);
		}
		return Tab.noObj;
	}
	
	public Obj findObjectInMain(String name) {
		Obj mainObj = findObjectInProgram("main");
		if (mainObj != Tab.noObj) {
			return mainObj.getLocalSymbols().stream()
						  .filter(local -> name.equals(local.getName()))
						  .findFirst()
						  .orElse(Tab.noObj);
		}
		return Tab.noObj;
	}
	

	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(PrintStatement printStmt){
		if( printStmt.getExpr().obj.getType().getKind() == Struct.Array){
			// Get the length of the array
			Obj n = Tab.insert(Obj.Var, "amela", Tab.intType);
			// Obj n = Tab.find("amela");
			n.setAdr(100);

			// n.setAdr(0);
			Code.loadConst(0);
			Code.store(n);
			
			Code.put(Code.dup);
			Code.put(Code.arraylength);
			// Store the length in a temporary variable
			
			// Loop start
			// Code.l(0); // Initialize the loop counter
			int loopStart = Code.pc;
			Code.put(Code.dup); // load the array length
			Code.load(n); // Load the loop iterator
			Code.putFalseJump(Code.ne, 10); // Jump out of the loop if the counter >= length
			
			int jumpAddr = Code.pc - 2; // Save the address of the jump instruction
			
			// Loop body
			Code.put(Code.dup2);
			Code.put(Code.pop);	
			// Load the array reference
			Code.load(n);
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
			Code.load(n); // Load the loop counter
			Code.loadConst(1); // Load the increment value
			Code.put(Code.add); // Add the increment value to the loop counter
			Code.store(n); // Store the updated loop counter
			
			// Jump back to the loop start
			Code.putJump(loopStart);
			
			// Update the jump address
			Code.fixup(jumpAddr);
			
			Code.put(Code.pop); // Pop the array length from the stack
			Code.put(Code.pop);	
			// Code.store(printStmt); // Store the array reference in the variable

		}
		else if(printStmt.getExpr().obj.getType() == Tab.intType || printStmt.getExpr().obj.getType() == boolType
				|| printStmt.getExpr().obj.getType().getKind() == Struct.Int || printStmt.getExpr().obj.getType().getKind() == Struct.Bool){
			if(printStmt.getPrintOptions() instanceof PrintOption){
				Code.loadConst(((PrintOption)printStmt.getPrintOptions()).getPrintNumber());
			}
			else{
				Code.loadConst(5);
			}
			Code.put(Code.print);
		}else if(printStmt.getExpr().obj.getType() == Tab.charType || printStmt.getExpr().obj.getType().getElemType().getKind() == Struct.Char){
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
				if(assignop.getDesignator().obj.getFpPos()==1){
					assignop.getDesignator().obj.setFpPos(2);
					Code.put(Code.astore);
				}
				else if(assignop.getDesignator().obj.getFpPos()==0){
					Code.put(Code.astore);
				}
				else{
					//baca se greska neka;
				}

			}
			// Code.put(Code.pop);
		}else{
			if(assignop.getDesignator().obj.getType().getKind() == Struct.Array){
				// Obj o = Tab.find( ((DesignatorSingle)assignop.getDesignator()).getVarName());
				// Code.store(o);
				Obj o =findObjectInMain(((DesignatorSingle)assignop.getDesignator()).getVarName());
				if(o == Tab.noObj){
					o=findObjectInProgram(((DesignatorSingle)assignop.getDesignator()).getVarName());
					// if(o==Tab.noObj){
					// 	Code.store(assignop.getDesignator().obj);
					// }
				}
				if(o.getFpPos()==1){
					o.setFpPos(2);
					Code.store(o);
				}
				else if(o.getFpPos()==0){
					Code.store(o);
				}
				else{
					Code.put(Code.pop);
					Code.loadConst(88);
				}

			}else{	
				
				Code.store(assignop.getDesignator().obj);
			}
			
		}
	}
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

	//visit method for DesignatorSingle
	public void visit(DesignatorSingle designatorSingle){
		if(!(designatorSingle.getParent() instanceof DesignatorAssignopExpr)
				&& !( designatorSingle.getParent() instanceof DesignatorInc)
				&& !(designatorSingle.getParent() instanceof  DesignatorDec)
				&& !(designatorSingle.getParent().getParent() instanceof ReadStatement)) {

					// // if(designatorSingle.obj.getType().getKind() == Struct.Array){
					// 	Obj o =findFromMain(designatorSingle.getVarName());
					// 	if(o == Tab.noObj){
					// 		o =findFromProg(designatorSingle.getVarName());
					// 	}
					// 	Code.load(o);
	
						
					// }
					// else{
						Code.load(designatorSingle.obj);
					// }
			

		}
	}

	//visit method for DesignatorArray
	public void visit(DesignatorArray designatorArray){
		if(!(designatorArray.getParent() instanceof DesignatorAssignopExpr)
				&& !( designatorArray.getParent() instanceof DesignatorInc)
				&& !(designatorArray.getParent() instanceof  DesignatorDec)
				&& !(designatorArray.getParent().getParent() instanceof ReadStatement)) {
		
			Code.load(designatorArray.obj);

			}
			
	}
		
	

	//DesignatorName
	public void visit(DesignatorName designatorName){
		Obj arrayVar = findObjectInMain(designatorName.getVarName());
            if (arrayVar == Tab.noObj) {
                arrayVar = findObjectInProgram(designatorName.getVarName());
            }
            Code.load(arrayVar);
	
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
		//generate code for range factor
		// Obj n = Tab.insert(Obj.Var, "rrr", Tab.intType);
		Obj n = Tab.find("rrr");
		n.setAdr(102);

		Code.put(Code.dup);
		Code.put(Code.newarray);
		Code.put(1);
		// n.setAdr(0);
				
		Code.loadConst(0);
		Code.store(n);
		// Loop start
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
		

}
