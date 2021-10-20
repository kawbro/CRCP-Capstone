import processing.core.PApplet;

public class Platform {
    PApplet p;
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    protected float r;
    protected int color;

    public Platform()
    {
        p = null;
        x = 0;
        y = 0;
        w = 10;
        h = 10;
        r = 10;
        color = 0;
    }

    public Platform(PApplet p)
    {
        this.p = p;
//        x = p.random(p.width);
//        y = p.random(345);
//        w = p.random(10, 100);
//        h = p.random(10, 100);
//        r = 10;
//        color = p.color((int)p.random(255));

        x = 300;
        y = 325;
        w = 100;
        h = 20;
        r = 10;
        color = p.color((int)p.random(255));
    }

    public Platform(PApplet p, float x, float y, float w, float h, float r)
    {
        this.p = p;
        this.x = p.random(50, x);
//        this.y = p.random((p.height + h), y);
        this.y = p.random(100, y);
        this.w = p.random(10, w);
        this.h = p.random(10, h);
        this.r = r;
    }

    public void display()
    {
        //p.fill(color); set color of platform before displaying platform
        p.rect(x, y, w, h, r);
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public void generatePlatforms()
    {
//        Platform[] platforms = new Platform[4];
//
//        for(int i = 0; i < platforms.length; i++)
//        {
//            platforms[i] = new Platform(p, 400, 325, 100, 40, 10);
//        }
//
//        for(Platform platform: platforms)
//        {
//            //p.fill(0, 255, 0);
//            platform.display();
//        }
    }

    public void clear()
    {
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        r = 0;
    }
}
