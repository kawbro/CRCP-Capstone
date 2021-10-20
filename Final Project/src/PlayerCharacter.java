import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import static processing.core.PConstants.*;

public class PlayerCharacter {
    PApplet p;
    PImage sprite;
    float walkSpd;
    float dashSpd;
    float jumpHeight;
    float x;
    float y;
    float startY;
    boolean onPlatform;

    Platform platform;

    public PlayerCharacter()
    {
        p = null;
        sprite = null;
        walkSpd = 250.0F; //2.0f
        dashSpd = 500.0F; //4.0f
        jumpHeight = 100.0F;
        x = 0.0F;
        y = 355;
        onPlatform = false;
    }

    public PlayerCharacter(PApplet p, PImage sprite)
    {
        this.p = p;
        this.sprite = sprite;
        walkSpd = 2.0F;
        dashSpd = 10.0F;
        jumpHeight = 100.0F;
        x = 0.0F;
        y = 355;
        onPlatform = false;

        platform = new Platform(this.p);
    }

    public void display()
    {
        p.imageMode(PConstants.CENTER);
        p.image(sprite, 0, 0);
    }

    public void display(float x, float y)
    {
        p.imageMode(PConstants.CENTER);
        p.image(sprite, x, y);
    }

    public void walk() {
        if (p.keyPressed == true)
        {
            //How to get it to use this case and actually read if the key pressed is X.
            if (dashing() == true)
            {
                if (p.key == CODED)
                {
                    if (p.keyCode == RIGHT && x < p.width)
                    {
//                    float rightX = x + walkSpd;
                        x += dashSpd;
                        display(x, y);
                        System.out.println("Yay dash");
                    }

                    if (p.keyCode == LEFT && x >= 0)
                    {
//                    float leftX = x - walkSpd;
                        x -= dashSpd;
                        display(x, y);
                        System.out.println("Yay dash");
                    }
                }
            }
            else //if not dashing
            {
                if (p.key == CODED)
                {
                    if (p.keyCode == RIGHT && x < p.width)
                    {
//                    float rightX = x + walkSpd;
                        x += walkSpd;
                        display(x, y);
                        System.out.println("No dash");
                    }

                    if (p.keyCode == LEFT && x >= 0)
                    {
//                    float leftX = x - walkSpd;
                        x -= walkSpd;
                        display(x, y);
                        System.out.println("No dash");
                    }
                }
            }
            display(x, y);
        }
    }

    public void dash()
    {
        if(p.keyPressed == true)
        {
            if(p.key == 'x' || p.key == 'X')
            {
                //for adjustable code/diff. characters
                //walkSpd = walkSpd * 20.0F;

//                if (p.keyCode == RIGHT && x < p.width)
//                {
////                    float rightX = x + walkSpd;
                    sprite = p.loadImage("testSprite.gif");
                    x += dashSpd;
                    display(x, y);
//                }
//
//                if (p.keyCode == LEFT && x >= 0)
//                {
////                    float leftX = x - walkSpd;
//                    x -= dashSpd;
//                    display(x, y);
//                }
            }
        }
    }

    public boolean dashing()
    {
        if(p.keyPressed == true)
        {
            if(p.key == 'x' || p.key == 'X')
            {
                return true;
            }
        }

        return false;
    }

    public void jump()
    {
        
        //needs to be an arc rather than based on if up is held, platform sensitivity still necessary
        if(onPlatform == false)
        {
            startY = 355;
        }
        else
        {
            startY = platform.y;
        }
//        float startY = 355;
        float jumpSpd = 5;
        float maxJumpHeight = startY - jumpHeight;
        if(p.keyPressed == true)
        {
            if (p.key == CODED)
            {
//                if(p.keyCode == UP && p.keyCode == RIGHT && y >= 0 && y >= maxJumpHeight)
//                {
//                    y -= jumpSpd;
//                    x += walkSpd;
//                    display(x, y);
//                }
//
//                else if(p.keyCode == UP && p.keyCode == LEFT && y >= 0 && y >= maxJumpHeight)
//                {
//                    y -= jumpSpd;
//                    x -= walkSpd;
//                    display(x, y);
//                }
                if (p.keyCode == UP && y >= 0 && y >= maxJumpHeight)
                {
                    y -= jumpSpd;
                    display(x, y);
                }
            }

        }

        else if(y < startY)
        {

            {
                y += jumpSpd;
                display(x, y);
            }
        }

        display(x, y);
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void interact()
    {
        //check if PC is over something else (Door, Ladder, etc)
        //check if interact key (X) is pressed
        //if Yes to both, change stage
    }

    public void standOnPlatform()
    {
        if(y < platform.y && x >= platform.x && x <= (platform.x + platform.w))
        {
            onPlatform = true;
            startY = platform.y;
        }

        else if(x < platform.x || x > (platform.x + platform.w))//not on/over a platform opposite.
        {
            onPlatform = false;
            startY = 355;
        }
    }
}
/*
Needs:
    - Method to move (Left/Right)
    - Method to jump (and fall)
    - Method to interact
    - Method to display on screen
 */