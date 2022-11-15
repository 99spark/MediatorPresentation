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

    public Colleague(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;}
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public IMediator getMediator() {
        return mediator;
    }
    @Override
    public void attemptStartTransmit() {
        mediator.attemptTransmit(this);
    }
    @Override
    public void startTransmit() {
        if (this.mediator.getCurrentlyTransmitting() == this) {
            System.out.println(this.name +  ": Transmitting.");
        } else {
            System.out.println("Cannot transmit at this time.");
        }}
    @Override
    public void stopTransmit() {
        if (this.mediator.getCurrentlyTransmitting() == this) {
            this.mediator.stopTransmit(this);
        } else {
            System.out.println(this.name + " stopped transmitting, or already not transmitting");
        }
    }
}
