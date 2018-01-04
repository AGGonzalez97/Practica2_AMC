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
               
                
                
                ArrayList<Punto> medioD= new ArrayList<Punto>();
                ArrayList<Punto> medioI= new ArrayList<Punto>();
                double dmin = mejor(min1,min2).dist;
                if(mejor(min1,min2).dist == -1) dmin = mitad;//PARA SOLUCIONAR EL 8 44 2222
                for (int i = 0; i < l; i++) {
                    if( t.get(i).x < (mitad + dmin) && t.get(i).x >= mitad){
                        medioD.add(t.get(i));
                        
                    }
                    if( t.get(i).x >= (mitad - dmin) && t.get(i).x < mitad){
                        medioI.add(t.get(i));
                        
                    }
                }
                int mI = medioI.size();
                int mD = medioD.size();
                Solucion min3 =new Solucion();
                if(mI > 0 && mD > 0 ){
                    
                    if(mI > 1){
                        
                        for (int i = 0; i < mI; i++) {
                            for (int n = 0; n < mI; n++) {
                                for (int o = 0; o < mD; o++) {
                                    if(!(medioI.get(i).equals(medioI.get(n)))) {
                                        if(distancia(medioI.get(i), medioI.get(n), medioD.get(o)) < min3.dist || min3.dist == -1){
                                            min3.p[0]=medioI.get(i);
                                            min3.p[1]= medioI.get(n);   
                                            min3.p[2]= medioD.get(o);
                                            min3.dist = distancia(medioI.get(i), medioI.get(n), medioD.get(o));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(mD > 1){
                        
                        for (int i = 0; i < mD; i++) {
                            for (int n = 0; n < mD; n++) {
                                for (int o = 0; o < mI; o++) {
                                    if(!(medioD.get(i).equals(medioD.get(n)))) {
                                        if(distancia(medioD.get(i), medioD.get(n), medioI.get(o)) < min3.dist || min3.dist == -1){
                                            min3.p[0]=medioD.get(i);
                                            min3.p[1]= medioD.get(n);   
                                            min3.p[2]= medioI.get(o);
                                            min3.dist = distancia(medioD.get(i), medioD.get(n), medioI.get(o));
                                        }
                                    }
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
