package colleague;
import mediator.IMediator;

/**
 * IColleague interface establishes functionality of basic Colleagues:
 * start and stop transmissions
 * November 11, 2022
 * SDEV 426
 * IColleague.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public interface IColleague {

    String getName();
    IMediator getMediator();
    void attemptStartTransmit();
    void startTransmit();
    void stopTransmit();
}
