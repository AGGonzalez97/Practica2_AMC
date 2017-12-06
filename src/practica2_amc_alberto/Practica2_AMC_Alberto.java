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
public class Practica2_AMC_Alberto {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("empezando main");
        
        
        Punto a= new Punto((double)1,(double)2);
        Punto b= new Punto((double)7,(double)2);
        Punto c= new Punto((double)8,(double)4);
        Punto d= new Punto((double)9,(double)2);
        Punto e= new Punto((double)15,(double)2);
        
        Punto[] tabla= {a,b,c,d,e};
        
        
        
        for(int i=0; i<5; i++){
            System.out.println(tabla[i].x);
        }
        
        /*
        Mergesort mer= new Mergesort();
        mer.sort(tabla);
        */
        
        Algoritmos al=new Algoritmos(tabla);
        al.SolucionRapida();
        
        System.out.println(al.s.dist);
        
        /*for(int i=0; i<5; i++){
            System.out.println(tabla[i].x);
        }*/
    }
}
//Nueva modificacion