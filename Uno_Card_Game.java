/*
 *Grant Henderson 11314979
 */
package main;

import java.util.Scanner;

/**
 *
 * 
 */
public class Main {

   
    public static void main(String[] args) {
        
       System.out.println("Welcome to the UNO Workout Game!");
       System.out.println("To begin please input how many decks you want to use.(1, 2, or 3)");
       Scanner sc = new Scanner(System.in);
       int input;
       //do while loop checks input
       do{
           
           input = sc.nextInt();
           if(input <0 || input >3)
           {
               System.out.println("That is not a valid input");
           }
        }while(input <0 || input >3);
        System.out.println("You will play with "+ input+ " deck(s)");
        //if there is more than 1 deck then ask if the decks will be played seperately or shuffled together
        if(input > 1)
        {
            System.out.println("Do you want to shuffle the decks or play with them seperately");
            System.out.println("0)Together  1)Seperate");
            do{
                input = sc.nextInt();
                if(input<0 || input >1)
                {
                    System.out.println("That is not a valid input");
                }
            }while(input <0 || input >1);
            if(input == 0) System.out.println("You will play with the decks shuffled\n");
            else System.out.println("You will play with the decks seperately\n");
        }
        System.out.println("Do you want to play with action cards?");
        System.out.println("0)No  1)Yes");
        do{
            input = sc.nextInt();
            if(input<0 || input >1)
            {
                System.out.println("That is not a valid input");
            }
        }while(input <0 || input >1);
        if(input == 0) System.out.println("Action cards will be removed.");
        if(input == 1) System.out.println("There will be action cards.");
        System.out.println("Starting game...");         
    }
    
}
