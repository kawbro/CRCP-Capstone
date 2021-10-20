import processing.core.PApplet;
import processing.core.PImage;

public abstract class Stage {
    PApplet p;
    PImage sprite;
    protected int stageTracker;
    protected PlayerCharacter pc;


    public Stage()
    {
        p = null;
        sprite = null;
        stageTracker = 0;
        pc = new PlayerCharacter();
    }

    public Stage(PApplet p)
    {
        this.p = p;
        sprite = p.loadImage("OriginalTestSprite.gif");
        p.fill(255);
        p.rect(0, 360, p.width, 140); //Ground constant
        stageTracker = 0;
        pc = new PlayerCharacter(this.p, sprite);
    }

    public abstract void display();

    public abstract void transition(PlayerCharacter pc);

    public abstract void drawGround();

    public abstract void displayNextStage();
}
