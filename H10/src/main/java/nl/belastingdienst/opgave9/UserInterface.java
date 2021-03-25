package nl.belastingdienst.opgave9;

import java.util.HashSet;
import java.util.Set;

public class UserInterface {
    private final Set<Card> cardCollection = new HashSet<>();

    public void add(Card card) {
        cardCollection.add(card);
    }

    public void printCards() {
        for(Card card : cardCollection) {
            System.out.println(card.toString());
        }
    }

    public void printRegularCards() {
        for(Card card : cardCollection) {
            if(card instanceof RegularCard) {
                System.out.println(card.toString());
            }
        }
    }

    public void printGoldCards() {
        for(Card card : cardCollection) {
            if(card instanceof GoldCard) {
                System.out.println(card.toString());
            }
        }
    }

}
