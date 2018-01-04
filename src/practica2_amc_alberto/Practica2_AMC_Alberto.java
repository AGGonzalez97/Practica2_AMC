/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_amc_alberto;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class Practica2_AMC_Alberto {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        System.out.println("empezando main");
        Punto []tabla=new Punto[200];
        
        Random rn=new Random(100);
        
        for(int i=0;i<200;i++)
        {
            tabla[i]= new Punto(rn.nextDouble(),rn.nextDouble());
        }
        
        
        Mergesort mer= new Mergesort();
        mer.sort(tabla);
        
        
        Algoritmos al=new Algoritmos(tabla,200);
        al.SolucionRapida();
        
        System.out.println(al.s.dist);
        
        /*for(int i=0; i<5; i++){
            System.out.println(tabla[i].x);
        }*/
        
        
     
    }
    }

//Nueva modificacion