/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1w2oopintro;

/**
 *
 * @author MUON
 */
public class Q1W2OOPIntro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student puimpWoman = new Student("puimpWoman");
        puimpWoman.introduce();
        Student puimpWoman2 = new Student("puimpWomanII");
        puimpWoman2.introduce();
        System.out.println(puimpWoman.getId());
        System.out.println(puimpWoman2.getId());
    }
    
}
