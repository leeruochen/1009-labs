package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Triangle extends Entity {
    private float size;

    public Triangle(float x, float y, float speed, String color, float size) {
        super(x, y, speed, color);
        this.size = size;
    }

    public Triangle() {
        x = 0;
        y = 0;
        speed = 0;
        color = "white";
        size = 0;
    }

    public float getSize() {return size;}
    public void setSize(float size) {this.size = size;}

    public void draw(ShapeRenderer shapeRenderer)
    {
        if (color.equals("red")) shapeRenderer.setColor(1, 0, 0, 1);
        else if (color.equals("green")) shapeRenderer.setColor(0, 1, 0, 1);
        else if (color.equals("blue")) shapeRenderer.setColor(0, 0, 1, 1);
        else shapeRenderer.setColor(1, 1, 1, 1); // Default to white

        float[] vertices = {this.x, this.y, this.x + this.size / 2, this.y + this.size, this.x + this.size, this.y}; // Triangle vertices
        shapeRenderer.triangle(vertices[0], vertices[1], vertices[2], vertices[3], vertices[4], vertices[5]);
    }

    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.A)){x -= speed;}
        if (Gdx.input.isKeyPressed(Keys.D)){x += speed;}
    }
}
