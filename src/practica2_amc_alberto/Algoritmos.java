/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;

import static practica2_amc_alberto.Punto.distancia;

/**
 *
 * @author Usuario
 */

public class Algoritmos {
    Punto [] p;
    Punto [] s;
    Algoritmos(Punto [] p){
        this.p = p;
        s = new Punto[3];
    }
    void SolucionLenta(){
        
        double cercania=-1;
        int l = p.length;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < l; k++) {
                        if(distancia(p[i],p[j],p[k]) < cercania || cercania == -1){
                            cercania = distancia(p[i],p[j],p[k]);
                            s[0]=p[i];
                            s[1]=p[j];
                            s[2]=p[k];
                        }
                    }
                }
            }
            
    }
    void SolucionRapida(){
        return DyV(this.p);
    }
    Solucion DyV(Punto [] p,Punto [] s){
            
            
                
            
            /*case(2):{
                double minimo = -1;
                int l = p.length;
                for (int i = 0; i < l; i++) {
                    if(!(p[i].equals(s[1]) || p[i].equals(s[0]))){
                        if(distancia(s[0],s[1],p[0]) < minimo || minimo == -1){
                            minimo = distancia(s[0],s[1],p[0]);
                        }
                    }
                }
                return minimo;
                
            }
            case(1):{
                //Hacer fuerza bruta supondria un coste cuadrático
            }*/
            if(s.length>3){
                Solucion min1,min2;
                int l = p.length;
                Punto [] c1= new Punto[l];
                Punto [] c2= new Punto[l];
                double mitad = (p[l-1].x - p[0].x )/2;
                int j=0;int k = 0;
                for (int i = 0; i < l; i++) {
                    if(p[i].x< mitad){
                        c1[j]=p[i];
                        j++;
                    }
                    if(p[i].x>= mitad){
                        c2[k]=p[i];
                        k++;
                    }
                    
                }
                min1 =DyV(p, c1);
                min2 =DyV(p, c2);
                //coger con todos los puntos un area intermedia y hacer fuerza bruta entre esos puntos y quedarse con el menor distancia
                for (int i = 0; i < l; i++) {
                    if(p[i].x< mitad && p[i].x > (mitad - dmin)){
                        c1[j]=p[i];
                        j++;
                    }
                    if(p[i].x< mitad && p[i].x > (mitad - dmin)){
                        c2[k]=p[i];
                        k++;
                    }
                    
                }
                
                
            }else{
                if(s.length==3){
                    Solucion sol = new Solucion();
                    sol.dist= distancia(s[0],s[1],s[2]);
                    sol.p[0]=s[0];
                    sol.p[1]= s[1];
                    sol.p[2]= s[2];
                    return sol;
                }
                
        }
    }
}
