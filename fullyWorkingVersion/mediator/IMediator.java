package mediator;
import colleague.ColleagueAdvanced;
import colleague.IColleague;

/**
 * IMediator interface establishes functionality of mediator
 * November 11, 2022
 * SDEV 426
 * IMediator.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public interface IMediator {

    void registerColleagues(IColleague colleague1, IColleague colleague2);
    IColleague getCurrentlyTransmitting();
    void attemptTransmit(IColleague colleague);
    void stopTransmit(IColleague colleague);
    void overrideTransmit(ColleagueAdvanced colleagueAdvanced);
}
