/*
 * Grant Henderson
    
 */
package main;


import java.lang.String;

/**
 *The card class holds two values a cardColor and a cardType, it also has an array of all possible card types and colors for
 *building a deck.
 */
public class Card {
    
   String cardColor = new String();
   String cardType = new String();
   static String[] possibleColors = {"red","blue","green","yellow", "black"};
   static String[] possibleTypes = {"0","1","2","3","4","5","6","7","8","9","draw two", "reverse", "skip","wild", "wild draw four"};
    
   
   //Card constructor
    public Card(String Color , String Type)
    {
       this.cardColor = Color;
       this.cardType = Type;
    }
    
    //method that returns the card color
    public String getColor()
    {
        return cardColor;
    }
    /*
    * method for returning a value to compare the colors
    */
    public int getColorSort()
    {
         if(this.cardColor == "red")
            return 1;
        else if(this.cardColor == "blue")
            return 2;
        else if(this.cardColor == "yellow")
            return 3;
        else if(this.cardColor == "green")
            return 4;
        else if(this.cardColor == "black")
            return 5;
        return 0;
    }
    
    //method that returns the card type
    public String getCardType()
    {
        return cardType;
    }
    //method that returns a string that reflects the workout for each color of card
    public String cardWorkout()
    {
        if(this.cardColor == "red")
            return "situps";
        else if(this.cardColor == "blue")
            return "push ups";
        else if(this.cardColor == "yellow")
            return "squat";
        else if(this.cardColor == "green")
            return "lounges";
        else if(this.cardColor == "black")
            return "burpees";
        return "error";
    }
    //method to sort cards by either their rank, or by some negative number if the card is an action card, the cardType is converted into an int and returned
    public int getValue()
    {
        if(this.isAction())
        {
            if(this.cardType == "draw two") return -1;
            else if(this.cardType == "reverse") return -2;
            else if(this.cardType == "skip") return -3;
            else if(this.cardType == "wild") return -4;
            else if(this.cardType == "wild draw four") return -5;
        }
        int i = Integer.parseInt(this.cardType);
        return i;
    }
    //method that prints the card
    public void printCard()
    {
         System.out.print(cardColor+ " ");
         System.out.println(cardType);
    }
    //a method to see if the card is an action card
    public Boolean isAction()
    {
        if (this.cardType == "wild"
            || this.cardType == "draw two"
            || this.cardType == "wild draw four"
            || this.cardType == "skip"
            || this.cardType == "reverse" ) 
            return true;
        else return false;
    }  
}

