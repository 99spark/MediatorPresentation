package colleague;
import mediator.IMediator;

/**
 * Colleague class implements IColleague. Contains basic functionality
 * of starting and stopping a transmission. IS not capable of overriding any other Colleague
 * November 11, 2022
 * SDEV 426
 * Colleague.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public class Colleague implements IColleague {

    private IMediator mediator;
    private String name;

    /**
     * Constructor
     * @param mediator IMediator, mediator object
     * @param name String, name of this Colleague
     */
    public Colleague(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * name getter
     * @return String, name of this Colleague
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * mediator getter
     * @return Mediator, mediator object
     */
    @Override
    public IMediator getMediator() {
        return mediator;
    }

    /**
     * Called by user to request permission from mediator to transmit
     */
    @Override
    public void attemptStartTransmit() {
        mediator.attemptTransmit(this);
    }

    /**
     * Called by mediator after ensuring that the Colleague is allowed to transmit
     */
    @Override
    public void startTransmit() {
        if (this.mediator.getCurrentlyTransmitting() == this) {
            System.out.println(this.name +  ": Transmitting.");
        } else {
            System.out.println("Cannot transmit at this time.");
        }
    }

    /**
     * Called by user to stop a transmission and notify the mediator, also
     * called by mediator to ensure the action went through the mediator
     */
    @Override
    public void stopTransmit() {
        if (this.mediator.getCurrentlyTransmitting() == this) {
            this.mediator.stopTransmit(this);
        } else {
            System.out.println(this.name + " stopped transmitting, or already not transmitting");
        }
    }
}
