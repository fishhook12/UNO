/*
 * Grant Henderson
 * 
 */
package main;

import java.util.Arrays;
import java.util.*;
import java.lang.Math;
import java.util.Random;
/**
 *
 *The deck class contains an array of type Card
 * 
 */
public class Deck {
      
    public Card[] deck = new Card[324];
    
    //deck constructor
    //builds a deck with maximum possible cards, 324
    public Deck()
    {
        deck = new Card[324];
    }
    
    
    //method that takes two arguments, the number of decks being put together, and a boolean to determine
    //if the deck uses action cards
    public void buildDeck(int decks, boolean actions)
    {
        int d = 1;
        int i = 0;
        int j = 0;
        int deckIndex = 0;
        //for each color
        for(d = 1; d <= decks ; d++)
        {
            if(actions)
            {
                for(i=0; i < 4 ; i++ )
                {
                        j=0;
                        this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                        deckIndex++;
                        //twice for each number
                        for(j=1; j<13; j++)
                        {
                           this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                           deckIndex++;
                           this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                           deckIndex++;
                        }
                        //only add 1 zero per deck
                }
                for(j=13; j < 15; j++)
                {
                        this.deck[deckIndex]= new Card("black",Card.possibleTypes[j]);
                        deckIndex++;
                        this.deck[deckIndex]= new Card("black",Card.possibleTypes[j]);
                        deckIndex++;
                        this.deck[deckIndex]= new Card("black",Card.possibleTypes[j]);
                        deckIndex++;
                        this.deck[deckIndex]= new Card("black",Card.possibleTypes[j]);
                        deckIndex++;
                }
            }
            else
            {
                 for(i=0; i < 4 ; i++ )
                {
                    j=0;
                    this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                    deckIndex++;
                    //twice for each number
                    for(j=1; j<10; j++)
                    {
                        this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                        deckIndex++;
                        this.deck[deckIndex]= new Card(Card.possibleColors[i],Card.possibleTypes[j]);
                        deckIndex++;
                    }
                }  
            }
        }
    }
    //method that prints the deck out, to make sure the deck is building properly
     public void printDeck()
     {
         int i;
         for(i=0 ; i < this.deckSize() ; i++)
         {
               System.out.print(this.deck[i].cardColor + " ");
               System.out.println(this.deck[i].cardType);
         }
     }
    //a method that shuffles the deck
    //by selecting a random number, this number will be used as an index
    //then for each card, swap it with the randomized index value
    public void shuffleDeck()
    {
        Random random = new Random();
        int rand;
        int i;
        Card temp;
        for(i = 0; i< this.deckSize(); i++)
        {
           rand = Math.abs((random.nextInt())%this.deckSize());
           temp = this.deck[i];
           this.deck[i] = this.deck[rand];
           this.deck[rand] = temp;             
        }
   
         
     }
    /*
     public Queue buildPlayDeck()
     {
        Queue playDeck = new Queue(this.deckSize());
        int i = 0;
        for(i=0; i< this.deckSize() ; i++)
        {
                playDeck.enqueue(this.deck[i]);
        }
        return playDeck;
     }
    */
    //method that returns the current amount of cards in a deck
     public int deckSize()
     {
         int i;
         int size = 0;
         for(i=0 ; i< 324; i++)
         {
             if(this.deck[i] != null)
             {
                 size ++;
             }
             else
             {
                 return size;
             }
         }
         return size;
     }
     //a method to determine if game is over
     //param decks, takes an integer to determine the amount of decks the game will hae
     //param playDeck, checks to see whether the current deck is empty
     //if it is the last deck and it is empty, the game is over
     public static boolean gameOver(int decks, Queue playDeck)
     {
         if(playDeck.isEmpty() && decks <= 1)
             return true;
         else
             return false;
     }
}
