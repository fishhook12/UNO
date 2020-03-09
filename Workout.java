/*
 * Damian Reyes
 * R11466291
 * 
 */
package Main;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * 
 */
public class Workout {
    
  
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);
        //signifies workout is running
        boolean running = true;
        //variable used for actions card prompt
        boolean actions = false;
        //Initializes Deck Queue
        Queue playDeck = new Queue(324);
        //Initializes Deck
        Deck newDeck = new Deck();
        
        //number of decks to be used.
        int decks = 0;
        
        System.out.println("Weclome to the UNO workout session:");
        
        Workout:
        while(running){
            
            //User decides whether to play or not
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
            
            //Decides whether or not to use Action Cards
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
            
            // Builds Deck
            newDeck.buildDeck(decks, actions);
            System.out.println("Gathering Decks...");
            System.out.println("\nNow Shuffling\n");
            System.out.println("------------------------------------");
            
            //shuffles the deck
            newDeck.shuffleDeck();
            
            playDeck.buildPlayDeck(newDeck);
            
            
            //Runs through routine
            Routine:
            while(!playDeck.isEmpty()){
                
                //Intializes hands
                String inputHand = "0";
                Hand:
                while(!inputHand.equals("1") || !inputHand.equals("2")){
                    System.out.println("would you like to draw a hand?");
                    System.out.println("1. Draw");
                    System.out.println("2. End Routine");
                    inputHand = in.nextLine();
                    
                    //plays a hand normally
                    if(inputHand.equals("1")){
                        Hand newHand = new Hand();
                        newHand.drawHand(playDeck);
                        newHand.sortByColor();
                        Output.OutputHand(newHand, playDeck.isEmpty(), playDeck);
                    }
                    /**
                     * Passes an empty hand and true boolean to output to signify
                     *  that the user no longer wants to play and to post the final
                     * results of the workout
                     */
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
    }     
}