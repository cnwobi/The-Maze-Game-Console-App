package mazegame.control;

import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Player;

public class DungeonMaster {
    private IMazeClient gameClient;
    private IMazeData gameData;
    private Player thePlayer;
    private CommandHandler playerTurnHandler;


    public DungeonMaster(IMazeData gameData, IMazeClient gameClient) {
        this.gameData = gameData;
        this.gameClient = gameClient;
        playerTurnHandler = new CommandHandler();

    }

    public void printWelcome() {
        gameClient.playerMessage(gameData.getWelcomeMessage());
    }

    public void setupPlayer() {
        gameClient.playerMessage("\nYour eyes are glassy your head is pounding that sadist of a lecturer has you pulling an “all-nighter” to get your assignment in. \nDespite being on your 8th can of “Guarana Max” your eyes start to close and you drift off to sleep at the keyboard…….");
        gameClient.getReply("\n<<Hit enter to continue>>");
        gameClient.playerMessage("You open your eyes but don’t believe what you see, you must be dreaming! \nInstead of finding yourself in front of your computer you appear to be lying in a clearing surrounded by a dark, menacing looking forest. \nA campfire burns to your left and opposite you with legs crossed sits another person who begins to speak…");
        gameClient.getReply("\n<<Hit enter to continue>>");
        gameClient.playerMessage("“Greetings stranger my name is Jonesy. I had almost given up hope, but my prayers appear to have been answered”\n" +
                "You are too freaked out to say anything back.\n");
        gameClient.getReply("\n<<Hit enter to continue>>");
        String playerName = gameClient.getReply("'What name do you choose to be known by?', Jonesy asks (Please enter your name)");
        gameClient.playerMessage("\nJonesy continues, “You see " + playerName + ",I used to be a software engineering student just like you, but my evil lecturer sucked the life force out of me \nand I am condemned to suffer under his dominion for eternity.”");
        gameClient.playerMessage("You say “I’m hallucinating, must be the Guarana!”\n");
        gameClient.getReply("\n<<Hit enter to continue>>");
        gameClient.playerMessage("Jonesy replies, “If you are hallucinating then it is one you will never wake up from! Your only hope of returning to your normal life is to defeat my old lecturer Gregor the Butcheror”\n" +
                "“How do I do that?” you ask.\n" +
                "“Many have tried and all have failed, Gregor lives in a well guarded castle to the north, the only entrance being a drawbridge. The drawbridge is locked and only opens when the guards spot a party approaching who carries the ITECH3201 banner.”\n\n" +
                "“How can I get a ITECH3201 banner”, you ask.\n");
        gameClient.getReply("\n<<Hit enter to continue>>");
        gameClient.playerMessage("“Gregor’s henchman Philip the Enforcer and his gang of thugs can be found at the Inn of the Boar each night, if you defeat Philip and his gang you can take the banner and gain access to the castle, but be warned defeating Philip is tough he never travels alone. I suggest you find some well armed friends before taking him on.”\n" +
                "“But where do I find the Inn of the Boar?”\n");
        gameClient.getReply("\n<<Hit enter to continue>>");
        gameClient.playerMessage("“The Inn is located in the town of Mount Helenis south of here, but the woods are not safe as Gregor’s thugs are everywhere. Take my sword as I am too week to use it”\n" +
                "With that Jonesy tosses a sword to your feet and you bend down to pick it up. When you look up again Jonesy is gone!\n");
        thePlayer = Player.getInstance(playerName,45,21,20);
        thePlayer.setCurrentLocation(gameData.getStartingLocation());

        gameClient.playerMessage("You find yourself looking at ");
        gameClient.playerMessage(gameData.getStartingLocation().getDescription());

        //gameClient.getReply("<<Hit Enter to exit>>");
    }

    public void runGame() {
        printWelcome();
        setupPlayer();
        while (handlePlayerTurn()) {

        }
        gameClient.getReply("\n\n<<Hit enter to exit>>");
    }

    public boolean handlePlayerTurn() {
        CommandResponse playerResponse = playerTurnHandler.processTurn(gameClient.getCommand(), thePlayer);
        gameClient.playerMessage((playerResponse.getMessage()));
        return !playerResponse.isFinishedGame();
    }

}
