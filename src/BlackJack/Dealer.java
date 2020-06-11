package BlackJack;

public class Dealer extends Participant{
    public Dealer(Stack stack){
        super(stack,"DEALER");
    }
    @Override
    protected Integer selectAceScore(Integer aceCount, Integer score) {
        Integer aceScore = 0;
        for(int i=0;i<aceCount;i++){
            aceScore = i*11+(aceCount-i);
            if(isBurst(score+aceScore))
                return aceScore-10;
        }
        return aceScore;
    }
    @Override
    protected ContinueState selectContinue() {
            if(this.evaluateScore()<=17)
                return ContinueState.CONTINUE;
            else
                return ContinueState.STOP;
    }
}
