package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Entity {
    protected float x;
    protected float y;
    protected float speed;
    protected String color;

    public Entity(float x, float y, float speed, String color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public Entity() {
        x = 0;
        y = 0;
        speed = 0;
        color = "white";
    }
    
    public float getX() {return x;}
    public void setX(float x) {this.x = x;}
    public float getY() {return y;}
    public void setY(float y) {this.y = y;}
    public float getSpeed() {return speed;}
    public void setSpeed(float speed) {this.speed = speed;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public void draw(ShapeRenderer shapeRenderer){};
    public void draw(SpriteBatch spriteBatch){};

    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)){x -= speed;}
        if (Gdx.input.isKeyPressed(Keys.RIGHT)){x += speed;}
    }
}
