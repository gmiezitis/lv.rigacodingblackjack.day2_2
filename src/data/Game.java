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

    public Dealer dealer;

    public Player player;

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
    public void startNewGameUI(){
        deck = new Deck();
        deck.shuffle();
        
        player.removeCards();
        dealer.removeCards();
        
        giveCard(player, false);
        giveCard(player, false);
        giveCard(dealer, true);
        giveCard(dealer, true);
        
    }
    public void giveCard(Player player, boolean isBlind){
        Card card = deck.takeCard();
        card.isBlind = isBlind; 
        player.giveCard(card);
    }

    public boolean startNewGame() {
        boolean startNew = false;
        startNew = getAnswer("If start new game ? (y/n)?");

        if (startNew) {
            deck = new Deck();
            deck.shuffle();

            player.removeCards();
            dealer.removeCards();

            //player.giveCard(deck.takeCard());
            //player.giveCard(deck.takeCard());
            giveCard(player,false);
            giveCard(player,false);

            //dealer.giveCard(deck.takeCard());
            //dealer.giveCard(deck.takeCard());
            
            giveCard(dealer,true);
            giveCard(dealer,true);

            while (player.isInGame()) {
                player.giveCard(deck.takeCard());
            }
            dealerTurn();
            getResults();

        }
        return startNew;
    }
    public void dealerTurn(){
        while (dealer.isInGame()) {
                dealer.giveCard(deck.takeCard());
            }
    }
    private void getResults(){
        System.out.println(getResultText());
    }

    public String getResultText() {
        int playerPoints = player.getTotalPoints();
        int dealerPoints = dealer.getTotalPoints();

        System.out.println("Player points " + playerPoints);
        System.out.println("Dealer points " + dealerPoints);

        if (playerPoints > 21 && dealerPoints > 21) {
            return "No winners!";

        } else if (playerPoints > 21) {
            return "Dealer is winner ";

        } else if (dealerPoints > 21) {
            return "Player is winner ";

        } else if (playerPoints == dealerPoints) {
           return "Draw ";
        }else if(playerPoints > dealerPoints){
            return "Player is winner ";
        }else {
            return "Dealer is winner ";
        }
    }

}
