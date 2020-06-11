package BlackJack;

import Card.Card;

import java.util.Scanner;

public class Player extends Participant{
    public Player(Stack stack,String name){
        super(stack,name);
    }
    @Override
    protected Integer selectAceScore(Integer aceCount, Integer score) {
        System.out.println("this is "+aceCount);
        Integer aceScore = aceCount;
        Scanner scanner = new Scanner(System.in);
        Integer answer;
        if(0<aceCount){
            if(isBurst(score+aceCount))
                return aceCount;
            this.getHand().printCards();
            System.out.println("Aceを除いた"+this.getName()+"のスコアは"+score+"です。");
        while(true) {
            System.out.print(aceCount+"枚のエースのうち何枚を11とカウントしますか。(0~"+aceCount+")>>");
            answer = Integer.parseInt(scanner.next());
            if (0 <= answer && answer <= aceCount) {
                aceScore = answer * 11 + (aceCount - answer);
                break;
            }
            else{
                System.out.print("\n正しい値を入力してください。(0~"+aceCount+")>>");
            }
        }
        }
        return aceScore;
    }

    @Override
    protected ContinueState selectContinue() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        ContinueState choice;
            while (true) {
                System.out.print(this.getName()+"のスコアは"+this.getScore()+"です。（持ち札）");
                this.getHand().printCards();
                System.out.println("ゲームを継続しますか？(y/n)");
                answer = scanner.next();
                if (answer.equals("y")) {
                    choice = ContinueState.CONTINUE;
                    break;
                } else if (answer.equals("n")) {
                    choice = ContinueState.STOP;
                    break;
                } else {
                    System.out.println("正しい値を入力してください。");
                }
            }
        return choice;
    }
}
