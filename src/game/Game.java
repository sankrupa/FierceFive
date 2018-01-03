/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;


/**
 *
 * @author User-PC
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Deck dc = new Deck();
       dc.shuffle();
     //  dc.printDeck();
       
       StartScreen  start = new StartScreen();
       start.setVisible(true);

        
    }
    
}
