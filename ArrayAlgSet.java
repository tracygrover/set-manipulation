/* CoE 2SI4 - Project 1 */

package project1;

public class ArrayAlgSet extends AlgSet
{
    private Value []Set;
    private int syz=0;
   
    
   // private length=0,index=0;
    public ArrayAlgSet()
    {
        this.Set=new Value[1000];
        this.syz=0;
        for(int i=0;i<1000;i++)
            this.Set[i]=null;
    }
    
    public ArrayAlgSet(int n)
    {    
            this.Set=new Value[n];
            Value s = new Value();
            while(this.size() != n)
            {
                s.Random();
                this.add(s);
            }
    }
      

    /* how to implement another class?*/
    
    public int binarySearch( Value [ ] Set, Value x )
    {
        int low = 0;
        int high = this.size() - 1;
        int mid;

        while(low<=high)
        {
            mid=(low+high)/2;
            if( Set[mid].Val< x.Val )
                low = mid + 1;
            else if( Set[mid].Val>x.Val )
                high = mid - 1;
            else
                return mid;
        }

        return -1;    
    }
         
    public boolean isIn(Value n)
    {
        int result=binarySearch(this.Set,n );
        if (result!=-1)
            return true;
        else 
            return false;
    }
    
    public void add(Value x)
    {
        if(isIn(x))
            return;
        else if(syz == 0){
            Set[0] = x;
        }
        else
        {
          int i=0,j=0;
          for(i=0;i<syz;i++){
              while(Set[i].Val<x.Val){j++;}
          }
          for(i=j;i<syz;i++){Set[i+1]=Set[i];} 
          Set[j].Val=x.Val;
          syz++;
        }
        
   }
    
    public void delete(Value n)
    {        
         int index=0,i=0;
         
         index=binarySearch(this.Set,n);
         for(i=index;i<syz;i++)
             Set[i]=Set[i+1];
         syz--;
       
    }

    public AlgSet setIntersect(AlgSet A)
    {
        ArrayAlgSet Intersection=new ArrayAlgSet();
        int i=0,j=0,k=0;
                
        for(i=0;i<this.syz;i++){
               if(A.isIn(this.Set[i]))
               {
                   Intersection.add(this.Set[i]);
                  Intersection.syz++;
               }
        }
        return Intersection;
     }
   

     public AlgSet setUnion(AlgSet A)
     {
          ArrayAlgSet Union=new ArrayAlgSet();
          int i=0,j=0,k=0;
          ArrayAlgSet Temp = (ArrayAlgSet)A;
          
          for(i=0;i<this.syz;i++)
          {
              Union.add(this.Set[i]);
              Union.syz++;
          }
          
          for(j=0;j<Temp.syz;j++)
          {
              Union.add(Temp.Set[i]);
              Union.syz++;
          }
          return Union;
     }
     
     
     public AlgSet setDifference(AlgSet A)
     {
       
          ArrayAlgSet Difference=new ArrayAlgSet();
          int i=0,j=0;
          ArrayAlgSet Temp = (ArrayAlgSet)A;
          
          for(i=0;i<this.syz;i++)
          {
              Difference.add(this.Set[i]);
          }
          for(j=0;j<Temp.syz;j++){
              Difference.delete(Temp.Set[j]);
          }
          return Difference;
     }
    
     public int size()
     {
         return syz;
     }

     public void printSet()
     {
        System.out.println("The elements of the array are as follows:\n");
        System.out.print("{");
        for(int i=0;i<syz;i++) 
        {
            for(int j=0;j<10;j++)
            System.out.println("\t"+this.Set[i]);
            System.out.print("\n");
        }
        System.out.print("}");
     }
}