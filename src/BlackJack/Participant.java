package BlackJack;

import Card.Card;
import Card.CardException;
import Card.Number;

import java.util.List;

public abstract class Participant {
    private String name;
    private Hand hand;
    private Integer score;
    private ContinueState continueState;
    private final Integer BURST_SCORE = 21;

    protected Participant(Stack stack,String name) {
        this.hand = new Hand();
        this.name = name;
        this.drawCardFrom(stack);
        this.drawCardFrom(stack);
        this.score = evaluateScore();
        this.continueState = ContinueState.CONTINUE;
    }
    protected String setName(String name){
        this.name = name;
        return this.name;
    }
    protected Hand getHand(){
        return this.hand;
    }
    protected String getName(){
        return this.name;
    }
    protected Integer evaluateScore() {
        Integer aceCount = 0;
        this.score = 0;
        for (Card card : this.hand.getCards()) {
            switch (card.getNumber()) {
                case Ace:
                    aceCount++;
                    break;
                case Two:
                    this.score = this.score + 2;
                    break;
                case Three:
                    this.score = this.score + 3;
                    break;
                case Four:
                    this.score = this.score + 4;
                    break;
                case Five:
                    this.score = this.score + 5;
                    break;
                case Six:
                    this.score = this.score + 6;
                    break;
                case Seven:
                    this.score = this.score + 7;
                    break;
                case Eight:
                    this.score = this.score + 8;
                    break;
                case Nine:
                    this.score = this.score + 9;
                    break;
                case Ten:
                case Queen:
                case Jack:
                case King:
                    this.score = this.score + 10;
                    break;
            }
        }
        score+=selectAceScore(aceCount,this.score);
        return score;
    }
    protected ContinueState updateContinueState(){
        if (this.isBurst()||this.getContinueState().equals(ContinueState.STOP))
            this.continueState = ContinueState.STOP;
        else
            this.continueState = selectContinue();
        return this.continueState;
    }
    protected abstract Integer selectAceScore(Integer aceCount, Integer score);
    protected abstract ContinueState selectContinue();
    protected Boolean isBurst() {
        if (this.score > BURST_SCORE)
            return true;
        else return false;
    }
    protected Boolean isBurst(Integer score) {
        if (score > BURST_SCORE)
            return true;
        else return false;
    }
    protected Card drawCardFrom(Stack stack) {
        return this.hand.drawCardFrom(stack);
    }
    protected ContinueState getContinueState(){
        return this.continueState;
    }
    protected Integer getScore(){
        return this.score;
    }
    //    public class
    public void printParticipant() {
        System.out.print(this.name+"("+this.score+") : ");
        this.hand.printCards();
    }
    public Boolean action(Stack stack) {
        if (this.updateContinueState().equals(ContinueState.STOP))
            return false;
        this.drawCardFrom(stack);
        this.evaluateScore();
        if (this.isBurst() || this.getContinueState().equals(ContinueState.STOP))
            return false;
        else return true;
    }
}
