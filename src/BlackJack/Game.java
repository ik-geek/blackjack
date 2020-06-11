package BlackJack;

import Card.CardException;

import java.util.List;

public class Game {
    public static void main(String args[]){
        try {
            Stack stack = new Stack();
            Dealer dealer = new Dealer(stack);
            Player player1 = new Player(stack,"player1");
            Player player2 = new Player(stack,"player2");
            Player player3 = new Player(stack,"player3");
            Rule rule = new Rule();
            List<Participant> winners;
            Integer number = 0;
            System.out.println("--");
            while (true) {
                dealer.action(stack);
                player1.action(stack);
                System.out.println("--");
                player2.action(stack);
                System.out.println("--");
                player3.action(stack);
                System.out.println("--");
                winners = rule.judge(dealer,player1,player2,player3);
                if(winners==null)
                    continue;
                else break;
            }
            printAllParticipant(dealer,player1,player2,player3);
            for(Participant winner: winners){
                System.out.println("== winner["+(++number)+"]==");
                winner.printParticipant();
            }
        }catch (CardException e){
            e.printStackTrace();
        }
    }
    public static void printAllParticipant(Participant... participants){
        for(Participant participant: participants){
            participant.printParticipant();
        }
    }
}
