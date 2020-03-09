/*
 * Damian Reyes
 * R11466291
 * 
 */
package Main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * 
 */
public class Workout {

    /**
     * 
     */
    
  
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        boolean running = true;
        boolean actions = false;
        Queue playDeck = new Queue(324);
        Deck newDeck = new Deck();
        
        //number of decks to be used.
        int decks = 0;
        
        System.out.println("Weclome to the UNO workout session:");
        
        Workout:
        while(running){
            String startInput = "0";
            Start:
            while (!startInput.equals("1")||!startInput.equals("2")){
                System.out.println("Would you like to start?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                startInput = in.nextLine();
                if(startInput.equals("1")){
                    break;
                }
                else if(startInput.equals("2")){
                    running  = false;
                    break;
                }
                else {
                    System.out.println("That is not a valid input.");
                    continue Workout;
                }
            }
            
            //Decides how many decks will be used.
            String deckInput = "0";
            Deck:
            while(!deckInput.equals("1") || !deckInput.equals("2") || 
                    !deckInput.equals("3")){
                System.out.println("How many decks would you like to use? (1-3)");
                deckInput = in.nextLine();
                switch (deckInput) {
                    case "1":
                        decks = 1;
                        break Deck;
                    case "2":
                        decks = 2;
                        break Deck;
                    case "3":
                        decks = 3;
                        break Deck;
                    default:
                        System.out.println("That is not a valid input");
                        break;
                }
            }
            
            String actionInput = "0";
            Action:
            while (!actionInput.equals("1") || !actionInput.equals("2")){
                            System.out.println("Would you like to use action cards?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            actionInput = in.nextLine();
                if(actionInput.equals("1")){
                    actions = true;
                    break;
                }
                else if(actionInput.equals("2")){
                    actions = false;
                    break;
                }
                else{
                    System.out.println("That is not a valid input");
                    break;
                }
                
            }
            
            newDeck.buildDeck(decks, actions);
            System.out.println("Gathering Decks...");
            System.out.println("\nNow Shuffling\n");
            System.out.println("------------------------------------");
            
            //shuffles the deck
            newDeck.shuffleDeck();
            
            playDeck.buildPlayDeck(newDeck);
            
            
            
            Routine:
            while(!playDeck.isEmpty()){
                String inputHand = "0";
                Hand:
                while(!inputHand.equals("1") || !inputHand.equals("2")){
                    System.out.println("would you like to draw a hand?");
                    System.out.println("1. Draw");
                    System.out.println("2. End Routine");
                    inputHand = in.nextLine();
                    if(inputHand.equals("1")){
                        Hand newHand = new Hand();
                        newHand.drawHand(playDeck);
                        newHand.sortByColor();
                        Output.OutputHand(newHand, playDeck.isEmpty(), playDeck);
                    }
                    else if(inputHand.equals("2")){
                        Hand newHand = new Hand();
                        System.out.println("Thanks for Playing!");
                        Output.OutputHand(newHand, true, playDeck);
                        break Workout;
                    }
                    else{
                        System.out.println("That is not a valid input.");
                    }
                }
            }
            
            
            
            
            
        }
        
        /*/a boolean value that determines if the deck will have action card
        //the number of decks that will be shuffled together
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
        }   */  
    }
        
}