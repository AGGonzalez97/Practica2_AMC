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
    Algoritmos(Punto [] p){
        this.p = p;
    }
    Punto[] SolucionLenta(){
        Punto [] s = new Punto[3];
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
            return s;
    }
    
}
