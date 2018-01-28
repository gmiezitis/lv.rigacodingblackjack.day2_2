/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class Hand {

    ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList();

        //nav obligati <Card>
    }

    public void addCard(Card card) {

        cards.add(card);
    }
    public void clearCards(){
        cards.clear();
    }

    public Card[] getCards() {
        return cards.toArray(new Card[cards.size()]);

    }

    public int countPoints() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();

            if (card.getValueString().equals("A")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {

            total -= 10;
            aceCount--;
        }

        return total;
    }

}
