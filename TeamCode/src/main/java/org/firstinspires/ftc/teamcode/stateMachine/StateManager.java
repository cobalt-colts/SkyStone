package org.firstinspires.ftc.teamcode.stateMachine;

import org.firstinspires.ftc.teamcode.SkyStone6547Qualifter;
import org.firstinspires.ftc.teamcode.stateMachine.Action;

import java.util.List;

public class StateManager {

    SkyStone6547Qualifter bot;
    List<Action> actions;
    //public AddState addState;
    public StateManager(SkyStone6547Qualifter bot, List<Action> actions)
    {
        this.bot = bot;
        this.actions = actions;
    }
    public void addAction(Action action)
    {
        actions.add(action);
    }
    public void runStates()
    {
        for (int i = 0; i < actions.size(); i++)
        {
            actions.get(i).runState();
        }
    }
    public boolean isDone()
    {
        for (Action action : actions)
        {
            if (!action.isDone()) return false;
        }
        return true;
    }
//    public void resetStates()
//    {
//        addState = new AddState(bot);
//    }


}
//class AddState {
//
//    List<Boolean> stateStatus = new ArrayList<>();
//    SkyStone6547Qualifter bot;
//    public AddState(SkyStone6547Qualifter bot)
//    {
//        this.bot = bot;
//        stateStatus.clear();
//    }
//    boolean allStatesDone()
//    {
//        for (Boolean bool : stateStatus)
//        {
//            if (!bool) return false;
//        }
//        return true;
//    }
//    public void addLinearSlide(int level) {addLinearSlide(level, true);}
//    public void addLinearSlide(int level, boolean important)
//    {
//        if (important) stateStatus.add(false);
//    }
//
//}
