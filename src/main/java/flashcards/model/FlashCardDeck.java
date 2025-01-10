package flashcards.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class FlashCardDeck{

    private Stack<FlashCard> deck = new Stack<>();

    private Stack<FlashCard> shuffle1;

    private Stack<FlashCard> shuffle2;

    private Stack<FlashCard> correct;

    private Stack<FlashCard> incorrect;

    private Queue<FlashCard> skipped;

    private int size;

    private int totalCards;

    private String deckID;

    private String name;

    public String getDeckID() {
        return deckID;
    }

    public void setDeckID(String deckID) {
        this.deckID = deckID;
    }

    public void addFlashCard(FlashCard card) {
        deck.push(card);
    }

    public FlashCardDeck(String name) {
        this.name = name;

        deck = new Stack<>();

        shuffle1 = new Stack<>();

        shuffle2 = new Stack<>();

        correct = new Stack<>();

        incorrect = new Stack<>();

        skipped = new LinkedList<>();
    }

    public int getTotalCards(){
        return deck.size() + shuffle1.size() + shuffle2.size() + correct.size() + incorrect.size() + skipped.size();
    }

    public int getSize() {
        return deck.size();
    }

    public void shuffle() {
        resetDeck();
        Random rand = new Random();


        while (deck.size() > 0) {
            int n1 = rand.nextInt(100);
            int n2 = rand.nextInt(100);

            if (n1>n2) {
                shuffle1.push(deck.pop());
            } else if (n2<n1) {
                shuffle2.push(deck.pop());
            } else {
                correct.push(deck.pop());
            }
        }
        resetDeck();
    }



    private void resetDeck() {
        if (shuffle1.size() > 0) {
            resetDeckHelper(shuffle1);
        }
        if (shuffle2.size() > 0) {
            resetDeckHelper(shuffle2);
        }
        if (correct.size() > 0) {
            resetDeckHelper(correct);
        }
        if (incorrect.size() > 0 ) {
            resetDeckHelper(incorrect);
        }
        if (skipped.size() > 0) {
            while (skipped.size()>0) {
                deck.push(skipped.remove());
            }
        }
    }

    private void resetDeckHelper(Stack<FlashCard> cards) {
        for (int i = 0; i < cards.size() ; i++) {
            deck.push(cards.pop());
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
