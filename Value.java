/* COE 2SI4 - Project 1
--------------------------------------------------
Program Description: The program describes a class Value which is in many ways
 *  similar to an integer, it accepts values only between 0 & 65535 it has
 *  methods Random and IsEqual which generate a random value and check for
 *  equality respectively. This Class has been developed specifically for this
 *  project to be used in the set ADT.
Inputs: The Constructor uses an Integer and the Isequal method takes in a Value
 *  which will be used for comparison.
Outputs: Method Random outputs a random value while the method IsEqual returns
 *  a boolean.
 */

public class Value {    
    int Val;    
    /** Creates a new instance of Value */
    public Value() {
        Val = -1;
    }
    /** Creates a new instance of Value and stores A in Val*/
    public Value(int A){
        if(A>0 && A<65535){
            Val = A;
        }
        else{
            throw new ArithmeticException("Value is negative or over 65535");
        }
    }
    /*
        Function Description: Method compares two Values and returns true
            if they are equal else returns False.
        Inputs: Value(For Comparison).
        Outputs: boolean(After Comparison).
        Assumptions: The Value V is initialised.
    */
    public boolean IsEqual(Value V){
        if(this.Val == V.Val){return true;}
        else{return false;}
    }
    /*
        Function Description: The toString Method to make the object
     *      printing-friendly.
        Inputs: NONE
        Outputs: String
        Assumptions: Val is Initialized.
    */
    public String toString(){
        return "Value Is: "+Val;
    }
}
