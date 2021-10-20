import processing.core.PApplet;
import processing.core.PFont;

public class DayZone extends Stage {

    //PImage sprite;
    PFont font;
    int screenTracker;
    //pc = new PlayerCharacter(this.p, sprite);
    PlayerCharacter pc = new PlayerCharacter(p, sprite);
    String dayText = "";
    String dayText1 = "";
    String dayText2 = "";
    String dayText3 = "";
    String dayText4 = "";
    String dayText5 = "";
    float a0, a1, a2, a3, a4, a5;
    Platform [] platforms = new Platform[4];
    Platform dayPlats = new Platform();

    public DayZone()
    {
        super();
    }

    public DayZone(PApplet p)
    {
        super(p);
        font = p.loadFont("BellMTItalic-40.vlw");
        this.a0 = 255;
        this.a1 = 255;
        this.a2 = 255;
        this.a3 = 255;
        this.a4 = 255;
        this.a5 = 255;
    }

    public void display()
    {
        p.background(55, 198, 237);
        drawGround();

        p.fill(250, 250, 0);
        p.arc(p.width, 0, 150, 150, p.HALF_PI, (p.PI + p.QUARTER_PI));


        p.textFont(font);
        p.fill(250, a0);
        p.textAlign(p.CENTER, p.CENTER);



        if(screenTracker <= 7) // 10 - 3 = 7
        {
            if(screenTracker <= 0)
            {
                p.fill(250, a0);
                dayText = "DAY ZONE " + (screenTracker + 1);
                p.text(dayText, 0, 0, p.width, p.height);
                textFade();


//                dayPlats.generatePlatforms();
//                for(int i = 0; i < platforms.length; i++)
//                {
//                    platforms[i] = new Platform(p, 400, 325, 100, 40, 10);
//                }
//
//                for(Platform platform: platforms)
//                {
////                    p.fill(250);
//                    platform.display();
//                }
            }

            else if(screenTracker == 1)
            {
                p.fill(250, a1);
                dayText1 = "DAY ZONE " + (screenTracker + 1);
                p.text(dayText1, 0, 0, p.width, p.height);
                textFade();


                //display();
            }

            else if(screenTracker == 2)
            {
                p.fill(250, a2);
                dayText2 = "DAY ZONE " + (screenTracker + 1);
                p.text(dayText2, 0, 0, p.width, p.height);
                textFade();


                //display();
            }

            else if(screenTracker == 3)
            {
                p.fill(250, a3);
                dayText3 = "DAY ZONE " + (screenTracker + 1);
                p.text(dayText3, 0, 0, p.width, p.height);
                textFade();

                //display();
            }

            else if(screenTracker == 4)
            {
                p.fill(250, a4);
                dayText4 = "DAY ZONE " + (screenTracker + 1);
                p.text(dayText4, 0, 0, p.width, p.height);
                textFade();

                //display();
            }

            else if(screenTracker >= 5)
            {
//                p.fill(250, a5);
//                dayText5 = "DAY ZONE " + screenTracker;
//                p.text(dayText5, 0, 0, p.width, p.height);
//                textFade();
//
//                //display();

                p.background(0);
                p.fill(255);
                dayText = "This is the end. Press x to exit.";
                p.text(dayText, 0, 0, p.width, p.height);
                //display();

                if(p.keyCode == 'x' || p.keyCode == 'X')
                {
                    p.exit();
                }
            }

//            else if(screenTracker > 5)
//            {
//                p.background(0);
//                p.fill(255);
//                dayText = "This is the end. Press x to exit.";
//                p.text(dayText, 0, 0, p.width, p.height);
//                //display();
//
//                if(p.keyCode == 'x' || p.keyCode == 'X')
//                {
//                    p.exit();
//                }
//            }

//            else if(screenTracker == 7)
//            {
//                p.background(0);
//                p.fill(255);
//                dayText = "This is the end. Press a key to exit.";
//                p.text(dayText, 0, 0, p.width, p.height);
//                System.out.println(screenTracker);
//                //display();
//
//                if(p.keyPressed)
//                {
//                    p.exit();
//                }
//
//            }
//
//            else if (screenTracker > 7)
//            {
//                System.out.println(screenTracker);
//                p.exit();
//            }
        }
    }

    public void transition(PlayerCharacter pc)
    {
        if(pc.getX() >= (p.width - 1))
        {
            pc.x = 0;
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

    }

    public void textFade()
    {
        if(screenTracker <= 0)
        {
            a0 -= 2.0F;
        }
        if(screenTracker == 1)
        {
            a1 -= 2.0F;
        }
        if(screenTracker == 2)
        {
            a2 -= 2.0F;
        }
        if(screenTracker == 3)
        {
            a3 -= 2.0F;
        }
        if(screenTracker == 4)
        {
            a4 -= 2.0F;
        }
        if(screenTracker == 5)
        {
            a5 -= 2.0F;
        }
    }
}
