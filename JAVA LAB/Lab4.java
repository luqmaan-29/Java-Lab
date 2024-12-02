import java.util.Scanner;

abstract     class   Robber  
{


    public void MachineLearning ( )  { 


System.out.println(      "I love Machine Learning." )  ; }




    public abstract void RobbingClass ( ) ; 
public   abstract    int RowHouses ( int [ ]   money ) ; 
    public abstract int   RoundHouses ( int[ ]   cash   ) ; 



    public abstract int SquareHouse( int[]  sqHouse )   ; 
    public   abstract int  MultiHouseBuilding ( int[ ]... bldg ) ; }



class    JAVAProfessionalRobber extends Robber { 

@Override 
   public void RobbingClass( )    { 
System.out.println("MSc AI & ML"); 
}

private 
    int simpleRob(int[]arr,int start, int stop){
int robA = 0,robB = 0;

        for (int i=start;i <=stop ; i++) 
{
int tmp   =  robB ; 


robB=Math.max(robA + arr[i],robB)  ; robA = tmp; 
} 

return robB ; 
}
@Override 
public int RowHouses  (int[]row)  { 

int rob1=0,rob2=0; for ( int r : row ) 
{

int temp= rob2   ; 
rob2 = Math.max (rob1+r ,rob2); 
rob1=temp; }
return rob2; 
}
@Override

public  int RoundHouses(int[ ]round )   {

if(round.length==1)return  round [ 0] ; 
return Math.max ( 
simpleRob(round,0,round.length-2) ,   simpleRob(round,1,round.length-1)  ); }

@Override 
    public int SquareHouse (int[ ]square ) 

{

return  RowHouses(square); 
}

public  int MultiHouseBuilding ( int[ ]... build) 
    { int total =0; 


    for (int[]bld: build ) { 
total += RowHouses (bld) ; }
return total  ; 
    } } 


public class Lab4  
{ 
public static void main(String[ ]args)  { 
Scanner sc = new Scanner( System.in); 


JAVAProfessionalRobber   robber = new JAVAProfessionalRobber() ;

System.out.println ( "Welcome to the Robber Simulation Program!" ); 
robber.RobbingClass ( ) ; 
robber.MachineLearning()  ; 
System.out.print( "Enter number of houses for RowHouses: " )  ; 
int n = sc.nextInt();int [ ]rowHouses= new int [n] ;
System.out.println ( "Enter the money in each house: ") ; 
for (int i=0;i<n; i++) 
{ rowHouses [i] = sc.nextInt() ; }

System.out.println("Maximum money from RowHouses: "+ 
robber.RowHouses(rowHouses) )   ;


System.out.print ("Enter number of houses for RoundHouses: "); 
int m=sc.nextInt(); int []roundHouses=new int [m];

System.out.println ( "Enter the money in each house:" )  ; 
for (int i=0 ; i < m ;i++){roundHouses[i]= sc.nextInt() ; }
System.out.println("Maximum money from RoundHouses: "+ 
robber.RoundHouses(roundHouses));

System.out.print("Enter number of houses for SquareHouse: ")   ; 
int p = sc.nextInt();int []squareHouse =new int [p];
System.out.println("Enter the money in each house: ");
for (int i= 0; i< p; i++)
{ 
squareHouse [ i] =sc.nextInt( ); } 


System.out.println("Maximum money from SquareHouse: "+ robber.SquareHouse(squareHouse));

System.out.print("Enter number of rows of houses for MultiHouseBuilding: ") ; 
int q=sc.nextInt( );int[][] multiHouses = new int[q][];
for(int i=0;i<q;i++) {
    System.out.print( "Enter number of houses in row "+ ( i+1) +": " )  ; 
int r =sc.nextInt( ) ;
multiHouses[i]= new int[r];
System.out.println("Enter the money in each house: "); 
for(int j= 0;j<r;j++) 
{

multiHouses[ i ][ j] = sc.nextInt() ;
    }}
System.out.println("Maximum money from MultiHouseBuilding: "+ robber.MultiHouseBuilding(multiHouses))  ; 
sc.close( );} 
}
