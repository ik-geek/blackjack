package BlackJack;

import java.util.LinkedList;
import java.util.List;

public class Rule {
    public Rule(){}
    private ContinueState GameState(Dealer dealer,Player ... players){
        ContinueState game = ContinueState.STOP;
        if(dealer.getContinueState().equals(ContinueState.CONTINUE))
            game = ContinueState.CONTINUE;
        for(Player player:players){
            if(player.getContinueState().equals(ContinueState.CONTINUE))
                game = ContinueState.CONTINUE;
        }
        return game;
    }
    private List<Participant> getWinners(Dealer dealer, Player ... players){
        List<Participant> winnerList = new LinkedList<>();
        if(!dealer.isBurst()) {
            winnerList.add(dealer);
            for(Player player:players) {
                if (!player.isBurst() && player.getScore() > dealer.getScore()) {
                    winnerList.remove(dealer);
                    winnerList.add(player);
                }
            }
            return winnerList;
        }else{
            for(Player player: players){
                winnerList.add(player);
            }
            return winnerList;
        }
    }
    public List<Participant> judge(Dealer dealer,Player ... players){
        List<Participant> winners;
        if(GameState(dealer,players).equals(ContinueState.STOP)){
            winners = getWinners(dealer,players);
        }else return null;
        return winners;
    }
}
