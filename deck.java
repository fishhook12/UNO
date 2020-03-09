//Cole Brandon
import java.util.Random;

public class DeckOfCards
{
    public String colors;
    private String faceUpCard;
    private Random randomShuffledCard;
    public int value;

    public DeckOfCards(int val, String col)
    {
        value = val;
        colors = col; 
    }

    public DeckOfCards()
    {
        randomShuffledCard = new Random();  //creates cards
        value = randomShuffledCard.nextInt(28);
        if (value >= 14) //gives each card a value 1-14
            value -= 14;
        randomShuffledCard = new Random();  //assugbs the card a color
        switch(randomShuffledCard.nextInt(4) )
        {
            case 0: colors = "Red"; 
                break;
            case 1: colors = "Green"; 
                break;
            case 2: colors = "Blue"; 
                break;
            case 3: colors = "Yellow"; 
                break;
        }
        if (value >= 13)  //checks if it is a wild card 13 and up is going to be wild
            colors = "No Color";
    }

    public String showFace() //shows the card face up to the players
    {
        faceUpCard = "[";
        if (colors != "No Color")
        {
            faceUpCard += this.colors + " ";
        }

        switch(this.value)
        {
            default: faceUpCard += String.valueOf(this.value); 
                break;
            case 10: faceUpCard += "Skip"; 
                break;
            case 11: faceUpCard += "Reverse"; 
                break;
            case 12: faceUpCard += "Draw Two"; 
                break;
            case 13: faceUpCard += "Wild"; 
                break;
            case 14: faceUpCard += "Wild Draw Four"; 
                break;
        }
        faceUpCard += "]";
        return faceUpCard;
    }

   
    public boolean canItPlaceOn(DeckOfCards canItPlace, String card)//checks to see if the card being played is able to be played on top of the card 
    {
        if (this.colors == card)
            return true;
        else if (this.value == canItPlace.value)
            return true;
        else if (this.colors == "none") //if the most recent card played was a wild card
            return true;
        return false;
    }
}
