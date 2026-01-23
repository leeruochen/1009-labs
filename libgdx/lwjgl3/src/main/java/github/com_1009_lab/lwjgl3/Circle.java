package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Circle extends Entity {
    private float radius;

    public Circle(float x, float y, float speed, String color, float radius) {
        super(x, y, speed, color);
        this.radius = radius;
    }

    public Circle() {
        x = 0;
        y = 0;
        speed = 0;
        color = "white";
        radius = 0;
    }

    public float getRadius() {return radius;}
    public void setRadius(float radius) {this.radius = radius;}

    public void draw(ShapeRenderer shapeRenderer) // method overriding
    {
        if (color.equals("red")) shapeRenderer.setColor(1, 0, 0, 1);
        else if (color.equals("green")) shapeRenderer.setColor(0, 1, 0, 1);
        else if (color.equals("blue")) shapeRenderer.setColor(0, 0, 1, 1);
        else shapeRenderer.setColor(1, 1, 1, 1); // Default to white

        shapeRenderer.circle(this.x, this.y, this.radius); // Draw circle at (x,y) with radius
    }

    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.UP)){y += speed;}
        if (Gdx.input.isKeyPressed(Keys.DOWN)){y -= speed;}
    }

    @Override
    public void update() {
        System.out.printf("In Circle of radius %f at %f, %f position.\n", radius, x, y);
    }
}
