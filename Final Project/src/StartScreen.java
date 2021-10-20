import processing.core.PApplet;
import processing.core.PFont;

public class StartScreen {
    PApplet p;
    PFont font;
    //PImage cursor;
    TutorialStage training;
    //PlayerCharacter pc;
    boolean clicked;
    DayZone daytime;


    public StartScreen(PApplet p)
    {
        this.p = p;
        font = p.loadFont("BellMTBold-40.vlw");
       // cursor = p.loadImage("fairy.cur");
        //training = new TutorialStage(p); //put at null after you get display working
        training = null;
        daytime = null;
        clicked = false;
        //pc = new PlayerCharacter();
    }

//    public StartScreen(PApplet p, TutorialStage t)
//    {
//        this.p = p;
//        font = p.loadFont("BellMTBold-40.vlw");
//        t = new TutorialStage(p);
//    }

    public void display()
    {
        p.background(0);
        p.textFont(font);

        //Cursor
        //p.image(cursor, p.mouseX, p.mouseY, 50, 50);
//        p.fill(50);
//        p.rect(p.mouseX, p.mouseY, 50, 50);

        //Title
        p.fill(250);
        p.textAlign(p.CENTER, p.TOP);
        String title = "Simple Game by Kale Wicks";
        p.text(title, 0, 0, p.width, p.height);


        //Buttons (Start, Options, Exit/Quit)
        p.textAlign(p.CENTER, p.CENTER);
        p.fill(250);
        String start = "Start";
        String options = "Options";
        String exit = "Exit";
        p.text(start, 0, 0, p.width, p.height);
        p.text(options, 0, 50, p.width, p.height);
        p.text(exit, 0, 100, p.width, p.height);

        //System.out.println(p.mouseX);
        //System.out.println(p.mouseY);
        if(p.mouseX >= 210 && p.mouseX <= 294 && p.mouseY >= 233 && p.mouseY <= 265)
        {
            p.fill(0, 255, 0);
            p.text(start, 0, 0, p.width, p.height);
        }

        if(p.mouseX >= 180 && p.mouseX <= 318 && p.mouseY >= 285 && p.mouseY <= 323)
        {
            p.fill(255, 234, 0);
            p.text(options, 0, 50, p.width, p.height);
        }

        if(p.mouseX >= 213 && p.mouseX <= 287 && p.mouseY >= 335 && p.mouseY <= 362)
        {
            p.fill(255, 0, 0);
            p.text(exit, 0, 100, p.width, p.height);
        }

    }

    public void startGame(TutorialStage training, DayZone daytime) //, DayZone daytime
    {
        //this.daytime = daytime;
        if(clicked == true)
        {
            training.display();
            training.transition(training.pc);
            training.pc.display(training.pc.x, training.pc.y);
            training.pc.walk();
            training.pc.jump();
            training.pc.standOnPlatform();

            if(training.screenTracker >= 3)
            {
                //training.screenTracker
                daytime.display();
                daytime.transition(daytime.pc);
                daytime.pc.display(daytime.pc.x, daytime.pc.y);
                daytime.pc.walk();
                daytime.pc.jump();
                daytime.pc.standOnPlatform();
            }
        }

        mouseClicked();
    }


    public void mouseClicked()
    {
        if(p.mouseX >= 210 && p.mouseX <= 294 && p.mouseY >= 233 && p.mouseY <= 265)
        {
            if(p.mousePressed == true)
            {
                clicked = true;
            }
        }

        if(p.mouseX >= 213 && p.mouseX <= 287 && p.mouseY >= 335 && p.mouseY <= 362)
        {
            if(p.mousePressed == true)
            {
                p.exit();
            }
        }

    }
}

/*
Needs to display first.
Needs to have clickable start button, quit button, and options button.
 */