/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;

import static java.lang.Math.sqrt;

/**
 *
 * @author Usuario
 */
public class Punto {
    public float x,y;
    Punto(int x, int y ){
        this.x = x;
        this.y = y;
        
    }
    public static double distancia(Punto p1, Punto p2, Punto p3){
        return (distancia(p1,p2)+distancia(p2, p3)+distancia(p3,p1));
        
        
        
    }
    public static double distancia(Punto p1, Punto p2){
        return sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
    
    
    
}

