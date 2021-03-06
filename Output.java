/* Brady Lowe
    Object oriented Programing Section 1
    R11527629   
    Project 1
 */
package unooutput;
import java.lang.*;
import java.io.*;
public class Output {
    
    /*Variable Inititalizations for first hand of game*/
    
    static private int HandNo = 0;
    static private int PushupsMax = 0;
    static private int SitupsMax = 0;
    static private int LungesMax = 0;
    static private int SquatsMax = 0;
    static private int BurpeesMax = 0;
    static private int TotalPushups = 0;
    static private int TotalSitups = 0;
    static private int TotalBurpees = 0;
    static private int TotalSquats = 0;
    static private int TotalLunges = 0;
    static private int PushupsSkipped = 0;
    static private int SitupsSkipped = 0;
    static private int LungesSkipped = 0;
    static private int SquatsSkipped = 0;
    static private int BurpeesSkipped = 0;
    static boolean FileIsOpen = false;


    /* 
       method for Outputting and calculating the total repetitions for the hand
       the method is passed an array containing the hand, as well as a boolean flag 
       for determining if it is the last hand
    */
   public void OutputHand(String Hand[][], boolean LastHand)throws IOException{
        int i;
        int Pushups,Situps,Squats,Lunges,Burpees,GreenMultiplier, BlueMultiplier,RedMultiplier,YellowMultiplier, OverallMultiplier;
        Pushups=Situps=Squats=Lunges=Burpees = 0;
        GreenMultiplier=BlueMultiplier=RedMultiplier=YellowMultiplier = OverallMultiplier = 1;
        boolean RedSkip, BlueSkip, YellowSkip, GreenSkip, MinuteBreak;
        RedSkip = BlueSkip= YellowSkip= GreenSkip= MinuteBreak = false;
        
        Writer osw = new FileWriter("UnoOutput.html", FileIsOpen);                          // appends to the file only if the file is open and start of game
        FileIsOpen = true;
        HandNo += 1;
        
        System.out.println("Hand "+HandNo +"\n");
        osw.write("Hand "+HandNo +"<br><br>");
        for (i =0;i<Hand.length; i++ )
        {
           System.out.print(Hand[i][0]+": "+Hand[i][1]+", ");
           osw.write(Hand[i][0]+": "+Hand[i][1]+", ");
           
           if (!isAction(Hand[i][1]))
           {
           switch(Hand[i][0])
           {
               case "red":
                  Situps += Integer.parseInt(Hand[i][1]);                                        // converts cards to ints for calculating total repetitions for hand
                  break;
                  
               case "blue":
                   Pushups += Integer.parseInt(Hand[i][1]);
                   break;
               case "yellow":
                   Squats += Integer.parseInt(Hand[i][1]);
                   break;
               case "green": 
                   Lunges += Integer.parseInt(Hand[i][1]);
                   break;     
               
           }
           }
           else 
           {
               if("skip".equals(Hand[i][1]) || "reverse".equals(Hand[i][1]))
               {
               switch(Hand[i][0])
               {
               case "red":
                  RedSkip = true;                                                   
                  break;
                  
               case "blue":
                   BlueSkip = true;
                   break;
               case "yellow":
                   YellowSkip = true;
                   break;
               case "green": 
                   GreenSkip = true;
                   break; 
               }
               }
               else if("draw two".equals(Hand[i][1]))
               {
                   switch(Hand[i][0])
               {
               case "red":
                  RedMultiplier = RedMultiplier * 2;
                  break;
                  
               case "blue":
                   BlueMultiplier = BlueMultiplier * 2;
                   break;
               case "yellow":
                   YellowMultiplier = YellowMultiplier * 2;
                   break;
               case "green": 
                   GreenMultiplier = GreenMultiplier * 2;
                   break; 
               }
               }
               else if("wild".equals(Hand[i][1]))
                   Burpees += 10;
               else if("wild draw four".equals(Hand[i][1]))
               {
                   Burpees +=10;
                   OverallMultiplier = OverallMultiplier *4;
               }
           }
           
           if("0".equals(Hand[i][1]))
               MinuteBreak = true;
        } 
        Pushups = Pushups*BlueMultiplier*OverallMultiplier;                         // find the total calculated repetions after applying action cards
        Squats = Squats*YellowMultiplier*OverallMultiplier;
        Situps = Situps*RedMultiplier*OverallMultiplier;
        Lunges = Lunges*GreenMultiplier*OverallMultiplier;
        Burpees = Burpees*OverallMultiplier;
        
        if(BlueSkip){
            PushupsSkipped += Pushups;
            Pushups = 0;
        }
        if(YellowSkip){
            SquatsSkipped += Squats;
            Squats = 0;
        }
        if(RedSkip){
            SitupsSkipped += Situps;
            Situps = 0;
        }
        if(GreenSkip){
            LungesSkipped += Lunges;
            Lunges = 0;
        }
        TotalRepetitions(Pushups,Squats,Lunges,Situps,Burpees);
       
        System.out.println("\n\nPushups: "+Pushups+"\n" + "Squat: " + Squats + "\n" + "Situps: "+Situps + "\n"
                + "Lunges: " + Lunges + "\n" +"Burpees: " + Burpees);
        osw.write("<br><br>Pushups: "+Pushups+"<br>" + "Squat: " + Squats + "<br>" + "Situps: "+Situps + "<br>"
                + "Lunges: " + Lunges + "<br>" +"Burpees: " + Burpees+"<br><br>");
        if(MinuteBreak)
            System.out.println("\n\nMinute Break!\n");
        
         if (LastHand)
        {
            System.out.println("\nEnd of Game\n\nTotal Repetitions: \nPushups: " + TotalPushups + "\nSquats: " 
                    + TotalSquats +"\nSitups: "+TotalSitups + "\nLunges: "+TotalLunges+"\nBurpees: "+TotalBurpees);
            System.out.println("\nMax Repetitions: \nPushups: " + PushupsMax + "\nSquats: " 
                    + SquatsMax +"\nSitups: "+SitupsMax + "\nLunges: "+LungesMax+"\nBurpees: "+BurpeesMax);
            System.out.println("\nSkipped Repetitions: \nPushups: " + PushupsSkipped + "\nSquats: " 
                    + SquatsSkipped +"\nSitups: "+SitupsSkipped + "\nLunges: "+LungesSkipped);
            osw.write("<br>End of Game<br><br>Total Repetitions: <br>Pushups: " + TotalPushups + "<br>Squats: " 
                    + TotalSquats +"<br>Situps: "+TotalSitups + "<br>Lunges: "+TotalLunges+"<br>Burpees: "+TotalBurpees+"<br>");
            osw.write("<br>Max Repetitions: <br>Pushups: " + PushupsMax + "<br>Squats: " 
                    + SquatsMax +"<br>Situps: "+SitupsMax + "<br>Lunges: "+LungesMax+"<br>Burpees: "+BurpeesMax+"<br>");
            osw.write("<br>Skipped Repetitions: <br>Pushups: " + PushupsSkipped + "<br>Squats: " 
                    + SquatsSkipped +"<br>Situps: "+SitupsSkipped + "<br>Lunges: "+LungesSkipped);
            FileIsOpen = false;
        }
         osw.flush();
         osw.close();
    }
    /*
   method for tracking the total repetitions throughout the game as well as the maximum amount of reps done in one hand
   */
   public void TotalRepetitions(int Pushups, int Squats, int Lunges, int Situps, int Burpees)
    {
        TotalPushups += Pushups;
        TotalSquats += Squats;
        TotalLunges += Lunges;
        TotalSitups += Situps;
        TotalBurpees += Burpees;
        
        if(Pushups > PushupsMax)
            PushupsMax = Pushups;
        if(Squats>SquatsMax)
            SquatsMax = Squats;
        if(Situps > SitupsMax)
            SitupsMax = Situps;
        if(Lunges > LungesMax)
            LungesMax = Lunges;
        if(Burpees > BurpeesMax)
            BurpeesMax = Burpees;
        
    }
    public Boolean isAction(String Card)
    {
        if ("wild".equals(Card)
            || "draw two".equals(Card)
            || "wild draw four".equals(Card)
            || "skip".equals(Card)
            || "reverse".equals(Card) ) 
            return true;
        else return false;
    }  
}
