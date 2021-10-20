import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class FinalProject extends PApplet {
    PImage sprite;
    //PImage cursor;
    PFont font;
    float x, y, xSpd;
    PlayerCharacter pc;
    int stageCounter = 0; //What screen are you on
    TutorialStage stage;
    StartScreen startup;
    DayZone dayStage;
    int screenTracker;

    public static void main(String[] args)
    {
        String [] processingArgs = {"FinalProject"};
        PApplet.main(processingArgs);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
//        cursor = loadImage("frisk-cursor.jpg");
        sprite = loadImage("OriginalTestSprite.gif");
        x = 0.0F;
        y = 360;
        xSpd = 3.0F;

        pc = new PlayerCharacter(this, sprite);
        stage = new TutorialStage(this);
        startup = new StartScreen(this);
        dayStage = new DayZone(this);


    }

    public void draw()
    {
        background(0);

        //System.out.println(pc.walkSpd);
//        System.out.println(pc.dashSpd);

        //Speed Check
//        if(keyPressed == true)
//        {
//            if(key == 'X' || key == 'x')
//            {
//                System.out.println(pc.dashSpd);
//                pc.sprite = loadImage("testSprite.gif"); //ask how to display filename not the little @code
//                //System.out.println(pc.sprite);
//            }
//            else
//            {
//                System.out.println(pc.walkSpd);
//                //System.out.println(pc.sprite);
//            }
//        }

        //IsDashing check
        //System.out.println(pc.dashing());

//        //Default Screen and Ground
//        fill(250);
//        rect(0, 360, width, 140);

        //Cursor Code
//        fill(10);
//        rect(mouseX, mouseX, 50, 50);

//        translate(x, y);
//
//        imageMode(CENTER);
//        image(sprite, 0, 0);
//
//        x += xSpd;
//        if(x > width + sprite.width)
//        {
//            xSpd = -xSpd;
//        }

        //Start Menu Code
        startup.display();
        startup.startGame(stage, dayStage);
        stage.transition(pc);


//        //Stage Code
//        stage.display();
//        stage.transition(pc);
//
//        //PC code
//        pc.walk();
//        pc.jump();
//        pc.standOnPlatform();
//        pc.dash();
//
//        //Day Zone Code
//        dayStage.display();
//        dayStage.transition(pc);
//        dayStage.textFade();

    }

//Code for Start Screen.


}
