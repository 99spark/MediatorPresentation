import colleague.Colleague;
import colleague.ColleagueAdvanced;
import colleague.IColleague;
import mediator.IMediator;
import mediator.Mediator;

/**
 * Test client
 * November 11, 2022
 * SDEV 426
 * ColleagueAdvanced.java
 * @author Alex Fischer, Kevin Price, Cameron Zipp
 * @version 1.0
 */
public class Main {

    /**
     * main method
     * @param args args
     */
    public static void main(String[] args) {

        // setup
        IMediator mediator = new Mediator();
        IColleague basicColleague = new Colleague(mediator, "basicColleague");
        ColleagueAdvanced advancedColleague = new ColleagueAdvanced(mediator, "advancedColleague");
        mediator.registerColleagues(basicColleague, advancedColleague);

        // run tests

        System.out.println("***Testing basicColleague transmitting when other is not transmitting***");
        basicColleague.attemptStartTransmit();
        System.out.println();

        System.out.println("***Testing advancedColleague overriding basic Colleague***");
        advancedColleague.overrideColleagueAndTransmit();
        System.out.println();

        System.out.println("***Testing basicColleague attempting to transmit when advancedColleague is running***");
        basicColleague.attemptStartTransmit();
        System.out.println();

        System.out.println("***Testing if advancedColleague can start new transmission when already transmitting***");
        advancedColleague.attemptStartTransmit();
        System.out.println();

        System.out.println("***Testing if advancedColleague can stop itself from transmitting***");
        advancedColleague.stopTransmit();
    }
}