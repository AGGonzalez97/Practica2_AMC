/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;

/**
 *
 * @author usuario
 */
public class Solucion {
    Punto [] p;
    double dist;
    Solucion(){
        p = new Punto[3];
        
    }
   public static Solucion mejor(Solucion s1,Solucion s2){
       if(s1.dist < s2.dist) return s1;
       else return s2;
   }
   public static Solucion mejor(Solucion s1,Solucion s2, Solucion s3){
       if(s1.dist < s2.dist && s1.dist < s3.dist) return s1;
       else {
          if(s2.dist < s3.dist) return s2;
          else return s3;  
       }
          
   }
}
