/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;

import java.util.ArrayList;
import static practica2_amc_alberto.Punto.distancia;
import static practica2_amc_alberto.Solucion.mejor;

/**
 *
 * @author Usuario
 */

public class Algoritmos {
    ArrayList<Punto> p;
    Solucion s;
    
    Algoritmos(Punto [] p,int tam){
        this.p= new ArrayList<Punto>();
        for (int i = 0; i < tam; i++) {
            this.p.add(p[i]);
        }
        
        s = new Solucion();
    }
    void SolucionLenta(){
        
        double cercania=distancia(p.get(0), p.get(1), p.get(2));
        int l = p.size();
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < l; k++) {
                        if(i==j || i==k || k==j){}
                        else {
                            double aux=distancia(p.get(i), p.get(j), p.get(k));
                            
                        if( aux < cercania){
                            cercania=aux;
                            s.dist= aux;
                            s.p[0]=p.get(i);
                            s.p[1]=p.get(j);        
                            s.p[2]=p.get(k);
                        }
                        }
                    }
                }
            }
            
    }
    void SolucionRapida(){
        ArrayList<Punto> x = p;
        s =DyV(x);
    }
    Solucion DyV(ArrayList<Punto> t){
            
            
                
            
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
            if(t.size() > 3){
                Solucion min1,min2;
                int l = t.size();
                ArrayList<Punto> c1= new ArrayList<Punto>();
                ArrayList<Punto> c2= new ArrayList<Punto>();
                double mitad = (t.get(l-1).x - t.get(0).x )/2 + t.get(0).x;
                System.out.println("la mitad es"+ mitad);
                for (int i = 0; i < l; i++) {
                    if(t.get(i).x < mitad){
                        c1.add(t.get(i));
                        
                    }
                    if(t.get(i).x >= mitad){
                        c2.add(t.get(i));
                       
                    }
                    
                }
                
                
                min1 =DyV( c1);
                min2 =DyV( c2);
                //coger con todos los puntos un area intermedia y hacer fuerza bruta entre esos puntos y quedarse con el menor distancia
                ArrayList<Punto> medio= new ArrayList<Punto>();
                
                for (int i = 0; i < l; i++) {
                    if( t.get(i).x < (mitad + mejor(min1,min2).dist) && t.get(i).x >= (mitad - mejor(min1,min2).dist)){
                        medio.add(t.get(i));
                        
                    }
                }
                int m = medio.size();
                Solucion min3 =new Solucion();
                min3.dist = distancia(medio.get(0), medio.get(1), medio.get(2));
                for (int i = 0; i < m; i++) {
                    for (int n = 0; n < m; n++) {
                        for (int o = 0; o < m; o++) {
                            if(!(medio.get(i).equals(medio.get(n)) || medio.get(o).equals(medio.get(n)) || medio.get(i).equals(medio.get(o)))){
                                if(distancia(medio.get(i), medio.get(n), medio.get(o)) < min3.dist){
                                    min3.p[0]=medio.get(i);
                                    min3.p[1]= medio.get(n);   
                                    min3.p[2]= medio.get(o);
                                    min3.dist = distancia(medio.get(i), medio.get(n), medio.get(o));
                                }
                            }
                        }
                    }
                }
                return mejor(min1,min2,min3);
                
            }else{
                if(t.size()==3){
                    Solucion sol = new Solucion();
                    sol.dist= distancia(t.get(0), t.get(1), t.get(2));
                    sol.p[0]=t.get(0);
                    sol.p[1]= t.get(1);
                    sol.p[2]= t.get(2);
                    return sol;
                }else return new Solucion();
                
        }
    }
}
