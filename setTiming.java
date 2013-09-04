/* CoE 2SI4 - Project 1 */

package project1;

public class setTiming {
    
    
AlgSet A,B,C;
long startTime, endTime;
double runTime=0.0;

   public static void measureTime(int n)
   {
           int MAXNUMSETS=1;
           int MAXRUN=1;
           AlgSet A,B,C;
            long startTime, endTime;
            double runTime=0.0;
  
         for(int numSets=0;numSets<MAXNUMSETS;numSets++){
          A = new ArrayAlgSet(n); // makes a random set of size n
          B = new ArrayAlgSet(n); // makes another random set of size n
          
          startTime = System.currentTimeMillis();

          for(int numRun=0;numRun<MAXRUN;numRun++)
          {
             C=A.setUnion(B);
          }
           endTime = System.currentTimeMillis();
          
           runTime +=(double) (endTime-startTime)/((double) MAXRUN);
    }

      runTime = runTime/((double) MAXNUMSETS); 
 
    System.out.println("\n The Run-time for the Union is :"+runTime);
    
}
   
   public static void main(String [] args)
   {
      // int a=100;
       measureTime(10);
   }
   
   
  
}
