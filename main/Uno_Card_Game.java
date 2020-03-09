/*
 * 
 * 
 * 
 */
package main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * 
 */
public class Uno_Card_Game {

    /**
     * 
     */
    
  
    public static void main(String[] args) throws IOException {
        
        //a boolean value that determines if the deck will have action cards
        boolean actions = false;
        //the number of decks that will be shuffled together
        int decks = 1;
        //builds a Queue with 324, the maximum possible cards
        Queue playDeck = new Queue(324);
        Deck newDeck = new Deck();
        System.out.println("Starting game..."); 
        //first param is the number of decks, the second param is whether they have actions
        newDeck.buildDeck(decks, actions);
        System.out.println("Grabbing new deck");
        System.out.println("\nNow Shuffling\n");
        //shuffles the deck
        newDeck.shuffleDeck();

        playDeck.buildPlayDeck(newDeck);

        //keeps grabbing new hands until there are no more cards in the Queue
        while(!(playDeck.isEmpty()))
        {
            Hand newHand = new Hand();

            newHand.drawHand(playDeck);

            newHand.sortByColor();

            Output.OutputHand(newHand, playDeck.isEmpty(), playDeck);
        }     
    }
        
}
