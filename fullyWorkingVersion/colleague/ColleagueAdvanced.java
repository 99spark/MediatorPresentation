package colleague;
import mediator.IMediator;

/**
 * ColleagueAdvanced class implements extends Colleague. Contains basic functionality
 * of starting and stopping a transmission. IS capable of overriding any other Colleague
 * November 11, 2022
 * SDEV 426
 * ColleagueAdvanced.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public class ColleagueAdvanced extends Colleague  {

    /**
     * Constructor
     * @param mediator IMediator, mediator object
     * @param name String, name of this Colleague
     */
    public ColleagueAdvanced(IMediator mediator, String name) {
        super(mediator, name);
    }

    /**
     * Override the transmission of any other mediator and start a transmission
     */
    public void overrideColleagueAndTransmit() {
        System.out.println("Advanced Colleague " + getName() + " is overriding other Colleague");
        getMediator().overrideTransmit(this);
    }
}
