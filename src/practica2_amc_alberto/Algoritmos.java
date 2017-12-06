/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;

import static practica2_amc_alberto.Punto.distancia;
import static practica2_amc_alberto.Solucion.mejor;

/**
 *
 * @author Usuario
 */

public class Algoritmos {
    Punto [] p;
    Solucion s;
    Algoritmos(Punto [] p){
        this.p = p;
        s = new Solucion();
    }
    void SolucionLenta(){
        
        double cercania=distancia(p[0],p[1],p[2]);
        int l = p.length;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < l; k++) {
                        if(i==j || i==k || k==j){}
                        else {
                            double aux=distancia(p[i],p[j],p[k]);
                            
                        if( aux < cercania){
                            cercania=aux;
                            s.dist= aux;
                            s.p[0]=p[i];
                            s.p[1]=p[j];        
                            s.p[2]=p[k];
                        }
                        }
                    }
                }
            }
            
    }
    void SolucionRapida(){
        Punto [] x = p;
        s =DyV(x);
    }
    Solucion DyV(Punto [] s){
            
            
                
            
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
                int l = s.length;
                Punto [] c1= new Punto[l];
                Punto [] c2= new Punto[l];
                double mitad = (s[l-1].x - s[0].x )/2;
                int j=0;int k = 0;
                for (int i = 0; i < l; i++) {
                    if(s[i].x< mitad){
                        c1[j]=s[i];
                        j++;
                    }
                    if(s[i].x>= mitad){
                        c2[k]=s[i];
                        k++;
                    }
                    
                }
                min1 =DyV( c1);
                min2 =DyV( c2);
                //coger con todos los puntos un area intermedia y hacer fuerza bruta entre esos puntos y quedarse con el menor distancia
                Punto [] medio = new Punto[l];
                k = 0;
                for (int i = 0; i < l; i++) {
                    if( s[i].x < (mitad + mejor(min1,min2).dist) && s[i].x >= (mitad - mejor(min1,min2).dist)){
                        medio[k]=s[i];
                        k++;
                    }
                }
                int m = medio.length;
                Solucion min3 =new Solucion();
                min3.dist = distancia(medio[0],medio[1],medio[2]);
                for (int i = 0; i < m; i++) {
                    for (int n = 0; n < m; n++) {
                        for (int o = 0; o < m; o++) {
                            if(!(medio[i].equals(medio[n]) || medio[o].equals(medio[n]) || medio[i].equals(medio[o]))){
                                if(distancia(medio[i],medio[n],medio[o]) < min3.dist){
                                    min3.p[0]=medio[i];
                                    min3.p[1]= medio[n];   
                                    min3.p[2]= medio[o];
                                    min3.dist = distancia(medio[i],medio[n],medio[o]);
                                }
                            }
                        }
                    }
                }
                return mejor(min1,min2,min3);
                
            }else{
                if(s.length==3){
                    Solucion sol = new Solucion();
                    sol.dist= distancia(s[0],s[1],s[2]);
                    sol.p[0]=s[0];
                    sol.p[1]= s[1];
                    sol.p[2]= s[2];
                    return sol;
                }else return new Solucion();
                
        }
    }
}
