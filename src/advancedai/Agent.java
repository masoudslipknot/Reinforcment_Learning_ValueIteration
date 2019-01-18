
package advancedai;

import java.util.Random;


public class Agent {
public char[][] Map = new char[5][11];
int currentX;
int currentY;
double gamma = 0.1;
public char[][]Policy = new char[5][11];
public int[][] Reward = new int[5][11];
public static double deltaMin = 1e-9; 
public static int Totaliteration = 10000;
public static double Utility[][];  // long-term utility
public static double Updating[][];
   
 public void intialMap(int PosX, int PosY){
     for(int i=0;i<5;i++){
           for(int j=0;j<11;j++){
               if(j%2 ==0){
                  Map[i][j]='|';
               }else{
                   Map[i][j]=' ';
               }              
           }
       }
       Map[0][3]='A';
       Map[0][7]='B';
       Map[2][7]='C';
       Map[4][3]='D';
       Map[PosX][PosY]='M';
       currentX = PosX;
       currentY = PosY;
       
 }
 
   public double Northmove(int Row, int column){
         if (Row < 0){
             return -1+ Utility[Row][column];
         }else if((Row==0 && column ==3)||(Row==0 && column ==7)){
             return Utility[Row][column];
         } 
         return Utility[Row-1][column]; 
   }
    public double Easthmove(int Row, int column){
         if (column > 9){
             return -1+ Utility[Row][column];
         }else if((Row==0 && column ==3)||(Row==0 && column ==7)){
             return Utility[Row][column];
         } 
         return Utility[Row][column+2]; 
   }
    
     public double Westmove(int Row, int column){
         if (column < 1){
             return -1+ Utility[Row][column];
         }else if((Row==0 && column ==3)||(Row==0 && column ==7)){
             return Utility[Row][column];
         } 
         return Utility[Row][column-2]; 
   }
     
      public double Southmove(int Row, int column){
         if (Row > 4){
             return -1+ Utility[Row][column];
         }else if((Row==0 && column ==3)||(Row==0 && column ==7)){
             return Utility[Row][column];
         } 
         return Utility[Row+1][column]; 
   }
      
      public void  UpdateUtility(int Row,int column){
          
          double best=-1;
          int index = -1;
          double[] calculated = new double[4];
          if((Row==0 && column ==3)||(Row==0 && column ==7)){
              Updating[Row][column]= Reward[Row][column];
          }
          
          calculated[0] = Northmove(Row, column)*0.6 + Easthmove(Row, column)*0.2 + Westmove(Row, column)*0.2;
          calculated[1] = Easthmove(Row, column)*0.6 + Northmove(Row, column)*0.2 + Southmove(Row, column)*0.2;
          calculated[2] = Westmove(Row, column)*0.6 + Northmove(Row, column)*0.2 + Southmove(Row, column)*0.2;
          calculated[3] = Southmove(Row, column)*0.6 + Easthmove(Row, column)*0.2 + Westmove(Row, column)*0.2;
          
          for(int y=0; y<4;y++){
              if(calculated[y]> best){
                  best = calculated[y];
                  index = y;
              }
          }
          
          Updating[Row][column]= best*gamma + Reward[Row][column];
          
          switch(index){
                  
              case 0:
                  Policy[Row][column]='N';
                  break;
              case 1:
                  Policy[Row][column]='E';
                  break;
              case 2:
                  Policy[Row][column]='W';
                  break;
              case 3:
                  Policy[Row][column]='S';
                  break;          
          }
      }
    
    public void printmap(){  
       for (int i=0; i<5;i++){
           System.out.print("-----------\n");
           for(int j=0;j<11;j++){
               System.out.print(Map[i][j]); 
           }
           System.out.print("\n");
       }
       System.out.print("-----------\n");
    }
    
    public void iteratepolicyonMap(){
        for(int i=0;i<5;i++){
            for(int j=1; j<11; j=+2){
               char toDo = Policy[i][j];
               if(toDo == 'N'){
                   
               }else if(toDo =='E'){
                   
               }else if(toDo == 'W'){
                   
               }else{
                   
               }
            }
        }
        
    }
    
    public void ValueIteration(){
       double delta =0;
       for(int i=0;i<5;i++){
           for(int j=1;j<11;j=j+2){
              Reward[i][j]=0; 
           }
       }
       Reward[0][3]=10;
       Reward[0][7]=5;
      
       
       for(int i=0;i<5;i++){
           for(int j=1;j<11;j=j+2){
               Updating[i][j]=0;
           }
           
           int iteration = 0;
           do{
           for(int k =0; k<5;k++){
               for(int o=1; o<11; o=+2){
                   Utility[k][o]= Updating[k][o];
               }  
           }
           iteration++;
           delta = 0;
           for(int n=0; n<5;n++){
               for(int f=1;f<11;f=+2){
                     UpdateUtility(n,f);
                    double diff = Math.abs(Updating[n][f] - Utility[n][f]);
                    if (diff > delta)
                        delta = diff;
                }
                   
               }
           }while (delta > deltaMin && iteration < Totaliteration);
       }
    }
    public static void agentrun(){
        Agent a = new Agent();
        Random rand = new Random();
        int PosX = rand.nextInt(5);
        int PosY = rand.nextInt(11);
        if(PosY%2==0)
            PosY = PosY+1;
        
        a.intialMap(PosX, PosY);
        System.out.println("First state of MAP");
        a.printmap();
        a.ValueIteration();
        
    }
    
}
