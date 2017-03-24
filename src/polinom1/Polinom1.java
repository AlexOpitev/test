package polinom1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.Scanner;


public class Polinom1 {
    public static void main(String[] args) {
        System.out.println("Введите широту:             (Внимание! десятые вводятся через знак ',')");
        double fi = 0;
        double ro = 0;
        double lia = 0;
        
            Scanner sc  = new Scanner (System.in);
            if(sc.hasNextDouble())
            fi=sc.nextDouble();
            if((fi>=-90.00)&(fi<=90.00)){ 
            double rad = Math.PI*fi/180;
                double sinFi = sin(rad);
                    System.out.println("sin Fi = "+sinFi);
                double cosFi = cos(rad);
                    System.out.println("cos Fi = "+cosFi);
                    System.out.println();
     
            }else{
            System.out.println("Ведите число от -90,00 до 90,00");   
            }
            
        System.out.println("Введите долготу:             (Внимание! десятые вводятся через знак ',')");
            Scanner sc1  = new Scanner (System.in);
            if(sc1.hasNextDouble())
            lia=sc1.nextDouble();
            if((lia>=-180.00)&(lia<=180.00)){ 
            double rad1 = Math.PI*lia/180;
                double sinlia = sin(rad1);
                    System.out.println("sin lia = "+sinlia);
                double coslia = cos(rad1);
                    System.out.println("cos lia = "+coslia);
                    System.out.println();
            }else{
            System.out.println("Ведите число от -180,00 до 180,00");   
            }            
        double [][]legandr = new double[41][41];  
        for( int n=0;n<41;n++){
            for(int m=0;m<41;m++){
                legandr [n][m] = legandr(fi,n,m);
                System.out.print(legandr[n][m]+"  ");
                }
            System.out.println(" ");
        }
        double b=Hkvazi(ro,fi,lia);
        System.out.println(); 
        System.out.println("Высота квазигеоида = "+b);    
    }
//    public static void STX(String[] args) throws FileNotFoundException, IOException{
//        try{
//                File file = new File("C:\\Users\\OpitevAD\\Desktop\\Prog\\JAVA\\Rezult_Colloc_Grid_81.txt");
//                FileReader fr = new FileReader(file);
//                BufferedReader reader = new BufferedReader(fr); 
//                String line = reader.readLine();
//                String[]str = new String[31];
//            int i=0;
//            while(line!=null){
//                str[i]=line;
//                line=reader.readLine();
//                i++;            
//            }
//            double[][]stx = new double[a1][a2];
//                int a1=0;
//                int a2=0;
//            for(int m=1;m<str.length;m++){
//                str[m]=str[m].replaceAll()
//            }    
//                
//        }
//    }
    public static double legandr(double fi,int n,int m){
            double Exit = 0;
            double rad = Math.PI*fi/180;
            double rad1 = Math.PI/2-rad;
            double cosfi2 = Math.cos(rad);
            double sinfi2 = Math.sin(rad);
            if((n==m)&&(n==0)){
            Exit = 1;
            }else if((n==m)&&(n==1)){
            Exit = legandr(fi,n-1,m-1)*cosfi2*sqrt((2*n+1)/(2*n*0.5));
            }else if((n==m)&&(n>=2)){
            Exit = legandr(fi,n-1,m-1)*cosfi2*sqrt((2*n+1)/(2*n*1.0));
            }else if(n<m){
            Exit = 0;
            }else if(n>m){
            Exit = legandr(fi,n-1,m)*sinfi2*sqrt((4*pow(n,2)-1)/(pow(n,2)-pow(m,2)))-legandr(fi,n-2,m)*sqrt(((pow((n-1),2)-pow(m,2))*((2*n)+1))/((pow(n,2)-pow(m,2))*((2*n)-3)));
        }
        return Exit;  
        
    }
    public static double Hkvazi(double ro, double fi, double lia){
        double Exit1;
        ro = 1.0;
        double a = 6378137.0;
        double StoksaS = 2;
        double StoksaC = 2;
        double s;
        double s1;
        double summ=0;
        double summ1=0;
        for(int n=2;n<15;n++){
            s=pow((a/ro),n);
            summ+=s; 
                for(int m=0;m<n;m++){  
                s1=((StoksaC*cos(m*lia))+(StoksaS*sin(m*lia)))*legandr(fi,n,m);
                summ1+=s1;  
                }    
            }
            Exit1=summ*summ1;
            return Exit1;

//        double fM = 398600.4418*Math.pow(10,9);
//        double a = 6378136.0;
//        double nu = 9.780327*(1+0.0053024*Math.pow(Math.sin(fi),2)-0.0000058*Math.pow(Math.sin(2*fi),2))-3.086*Math.pow(10,-6)*ro;
//        
//       // double Hkvazi(ro,fi,lia) = (fM/ro-nu)*(-(a*(a-ro*Math.pow(a/ro,N)))/(ro*(a-ro)))*legandr*1/Math.sin(lia/2)*Math.sin(0.5*(n+1)*lia)*((StoksaS*cos(((n*lia)/2)))+(StoksaC*sin((n*lia)/2)));
//        
//        //return Exit1;
        
          
       
        
    }
}
    

