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
        
        int[] aux= {6,31,3,23,4,8,16};
        
        for(int i=0; i<7; i++){
            System.out.println(aux[i]);
        }
        
        
        Mergesort mer= new Mergesort();
        mer.sort(aux);
        
        for(int i=0; i<7; i++){
            System.out.println(aux[i]);
        }
    }
    
}
//Nueva modificacion