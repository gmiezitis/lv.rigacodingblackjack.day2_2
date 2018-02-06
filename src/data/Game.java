/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class Game {

    private Dealer dealer;

    private Player player;

    private Deck deck;

    private static Scanner input = new Scanner(System.in);

    public Game() {
        dealer = new Dealer();
        player = new Player();
        deck = new Deck();
    }

    public static boolean getAnswer(String question) {
        System.out.print(question);

        char value = input.next().charAt(0);
        value = Character.toLowerCase(value);
        return value == 'y';

    }

    public boolean startNewGame() {
        boolean startNew = false;
        startNew = getAnswer("If start new game ? (y/n)?");

        if (startNew) {
            deck = new Deck();
            deck.shuffle();

            player.removeCards();
            dealer.removeCards();

            player.giveCard(deck.takeCard());
            player.giveCard(deck.takeCard());

            dealer.giveCard(deck.takeCard());
            dealer.giveCard(deck.takeCard());

            while (player.isInGame()) {
                player.giveCard(deck.takeCard());
            }
            while (dealer.isInGame()) {
                dealer.giveCard(deck.takeCard());
            }
            getResults();

        }
        return startNew;
    }

    private void getResults() {
        int playerPoints = player.getTotalPoints();
        int dealerPoints = dealer.getTotalPoints();

        System.out.println("Player points " + playerPoints);
        System.out.println("Dealer points " + dealerPoints);

        if (playerPoints > 21 && dealerPoints > 21) {
            System.out.println("No winners!");

        } else if (playerPoints > 21) {
            System.out.println("Dealer is winner ");

        } else if (dealerPoints > 21) {
            System.out.println("Player is winner ");

        } else if (playerPoints == dealerPoints) {
            System.out.println("Draw ");
        }else if(playerPoints > dealerPoints){
            System.out.println("Player is winner ");
        }else {
            System.out.println("Dealer is winner ");
        }
    }

}
