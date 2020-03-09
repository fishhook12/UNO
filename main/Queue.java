/*
 * Grant Henderson
 */
package main;

/**
 *
 * A Queue that works on a Card array
 * tracks the front index, rear index, and the current size
 * capacity is the total size it can be
 */
public class Queue {
    
    int front, rear, size;
    int capacity;
    Card array[];

    //a Queue constructor that takes an int argument for the maximum size of the Queue
    public Queue(int capacity)
    {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new Card[this.capacity];
    }
    
    boolean isFull()
    {
        return(this.size == this.capacity);
    }
    boolean isEmpty()
    {
        return (this.size == 0);
    }
    //adds a Card to the back of the Queue
    void enqueue(Card item) 
    { 
        if (this.isFull()) return; 
        this.rear = (this.rear + 1)%this.capacity; 
        this.array[this.rear] = item; 
        this.size = this.size + 1;  
    }
    //returns the first item(Card) in the Queue
    Card dequeue() 
    { 
        Card item = this.array[this.front]; 
        this.front = (this.front + 1)%this.capacity; 
        this.size = this.size - 1; 
        return item; 
    }
    //fills the Queue with a Deck
    public void buildPlayDeck(Deck deck)
     {
        int i = 0;
        for(i=0; i< deck.deckSize() ; i++)
        {
            this.enqueue(deck.deck[i]);
        }
        return;
     }
}
