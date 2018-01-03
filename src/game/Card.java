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
public class Card {
    
    private int suit, facevalue;
    private String[] cardSuit = {"Spades", "Diamonds", "Hearts", "Clubs"};
    private String[] cardValue = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public Card(int cSuit, int cValue)
    {
        suit = cSuit; 
        facevalue = cValue;
    }
    
    public int getValue()
    {
        return facevalue + 1;
    }
    
    public String getSuit()
    {
        return cardSuit[suit];
    }
    
   
    public String getImage()
    {
        String imageName = cardValue[facevalue] + cardSuit[suit] + ".png";

        return imageName;
}
  

   
}

    
