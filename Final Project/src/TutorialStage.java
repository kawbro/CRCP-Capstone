import processing.core.PApplet;
import processing.core.PFont;

public class TutorialStage extends Stage {
    //PImage sprite;
    PFont font;
    int screenTracker;
    //pc = new PlayerCharacter(this.p, sprite);
    PlayerCharacter pc = new PlayerCharacter(p, sprite);
    String tutorText = "";

    public TutorialStage()
    {
        super();
    }

    public TutorialStage(PApplet p)
    {
        super(p);
        font = p.loadFont("ComicSansMS-32.vlw");
    }

//    public TutorialStage(PApplet p , PlayerCharacter pc)
//    {
//        super(p);
//        font = p.loadFont("ComicSansMS-32.vlw");
//        this.pc = new PlayerCharacter(p, sprite);
//    }

    public void display()
    {
        p.background(55, 198, 237);
        drawGround();
        p.textFont(font);
        p.fill(250);
        p.textAlign(p.CENTER, p.TOP);


        if(screenTracker <= 3)
        {
            if(screenTracker == 0)
            {
                tutorText = "Welcome to the tutorial. Here you wil learn the controls. Use the left and right arrow keys to move.";
                p.text(tutorText, 0, 0, p.width, p.height);
            }

            else if(screenTracker == 1)
            {
                tutorText = "Tap the UP arrow key to jump.";
                p.text(tutorText, 0, 0, p.width, p.height);
            }

            else if(screenTracker == 2)
            {
                tutorText = "You can jump and move on platforms.";
                p.text(tutorText, 0, 0, p.width, p.height);

                Platform tutorStep = new Platform(p);
                p.fill(0, 255, 0);
                tutorStep.display();
            }
        }

//        else
//        {
//            displayNextStage();
//        }
    }

    public void transition(PlayerCharacter pc)
    {
        if(pc.getX() >= (p.width - 1))
        {
            pc.x = 0;
            pc.y = 355;
            screenTracker++;
            display();
            pc.display(pc.x, pc.y);
        }
    }

    public void drawGround()
    {
        p.fill(0, 255, 0);
        p.rect(0, 360, p.width, 140); //Ground constant
    }

    public void displayNextStage()
    {
        DayZone day1 = new DayZone(p);
        day1.display();
        day1.transition(pc);
    }
}
