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
    public void registerColleagues(IColleague colleague1, IColleague colleague2) {
        this.colleague1 = colleague1;
        this.colleague2 = colleague2;}
    @Override
    public IColleague getCurrentlyTransmitting() {
        return this.currentlyTransmitting;
    }
    @Override
    public void attemptTransmit(IColleague colleague) {
        if (this.currentlyTransmitting == null || this.currentlyTransmitting == colleague) {
            startTransmission(colleague);
        } else {
            System.out.println(colleague.getName() + ": Cannot transmit, other colleague transmitting.");
        }}
    private void startTransmission(IColleague colleague) {
        this.currentlyTransmitting = colleague;
        colleague.startTransmit();}
    @Override
    public void stopTransmit(IColleague colleague) {
        if (this.currentlyTransmitting == colleague) {
            IColleague other = this.currentlyTransmitting;
            this.currentlyTransmitting = null;
            other.stopTransmit();
        } else {
            System.out.println(colleague.getName() + ": Cannot stop transmission, other colleague transmitting.");
        }
    }

    /**
     * Called by ColleagueAdvanced to give it special permission to stop transmission of other Colleague,
     * and then start its own transmission
     * @param colleagueAdvanced ColleagueAdvanced
     */
    @Override
    public void overrideTransmit(ColleagueAdvanced colleagueAdvanced) {
        IColleague other = this.currentlyTransmitting;
        this.currentlyTransmitting = colleagueAdvanced;
        other.stopTransmit();
        this.currentlyTransmitting.startTransmit();
    }
}
