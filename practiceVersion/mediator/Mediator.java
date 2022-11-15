package mediator;
import colleague.ColleagueAdvanced;
import colleague.IColleague;

/**
 * Mediator class implements IMediator interface, establishes functionality of mediator
 * November 11, 2022
 * SDEV 426
 * Mediator.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public class Mediator implements IMediator {
    IColleague colleague1;
    IColleague colleague2;
    IColleague currentlyTransmitting;

    @Override
    public void registerColleagues(IColleague colleague1, IColleague colleague2) {}

    @Override
    public IColleague getCurrentlyTransmitting() {
        return this.currentlyTransmitting;
    }

    @Override
    public void attemptTransmit(IColleague colleague) {}

    private void startTransmission(IColleague colleague) {}

    @Override
    public void stopTransmit(IColleague colleague) {}

    /**
     * Called by ColleagueAdvanced to give it special permission to stop transmission of other Colleague,
     * and then start its own transmission
     * @param colleagueAdvanced ColleagueAdvanced
     */
    @Override
    public void overrideTransmit(ColleagueAdvanced colleagueAdvanced) {}
}
