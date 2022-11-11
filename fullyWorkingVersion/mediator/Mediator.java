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

    /**
     * Register two colleagues
     * @param colleague1 IColleague object
     * @param colleague2 IColleague object
     */
    @Override
    public void registerColleagues(IColleague colleague1, IColleague colleague2) {
        this.colleague1 = colleague1;
        this.colleague2 = colleague2;
    }

    /**
     * Getter, returns IColleague object that is currently transmitting
     * @return IColleague, the currently transmitting IColleague, or null if none are transmitting
     */
    @Override
    public IColleague getCurrentlyTransmitting() {
        return this.currentlyTransmitting;
    }

    /**
     * Called by IColleague to request permission from mediator to transmit
     * @param colleague IColleague, IColleague object attempting to start a transmission by calling this method
     */
    @Override
    public void attemptTransmit(IColleague colleague) {
        if (this.currentlyTransmitting == null || this.currentlyTransmitting == colleague) {
            startTransmission(colleague);
        } else {
            System.out.println(colleague.getName() + ": Cannot transmit, other colleague transmitting.");
        }
    }

    /**
     * Called in Mediator after checks have been made ensuring that the Colleague attempting
     * to transmit is allowed, or has already overridden the current transmission
     * @param colleague
     */
    private void startTransmission(IColleague colleague) {
        this.currentlyTransmitting = colleague;
        colleague.startTransmit();
    }

    /**
     * Check if Colleague that called this method is allowed to stop a transmission,
     * stops if it was already transmitting
     * @param colleague IColleague, this of the IColleague that called this method
     */
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
