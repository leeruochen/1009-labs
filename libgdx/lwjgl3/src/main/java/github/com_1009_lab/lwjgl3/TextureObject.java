package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends Entity {
    private Texture texture;
    private boolean isUser;

    public TextureObject(String filePath) {
        texture = new Texture(Gdx.files.internal(filePath));
        this.isUser = false;
    }

    public TextureObject(String filePath, float x, float y, boolean isUser, float speed) {
        super(x, y, speed, "white"); // speed and color are not used here
        texture = new Texture(Gdx.files.internal(filePath));
        this.isUser = isUser;
    }

    public Texture getTexture() {return texture;}
    public void setTexture(Texture texture) {this.texture = texture;}

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, texture.getWidth(), texture.getHeight());
    }

    public void movement () {
        if (isUser) {
            if (Gdx.input.isKeyPressed(Keys.LEFT)){x -= speed;}
            if (Gdx.input.isKeyPressed(Keys.RIGHT)){x += speed;}
        } else {
            y -= speed;

            if (y < 0) {
                y = Gdx.graphics.getHeight();
                x = (float)(Math.random() * (Gdx.graphics.getWidth() - texture.getWidth()));
                if (speed < 5.0f) speed += 0.5f;
            }
        }
    }

    @Override
    public void update() {
        System.out.printf("In TextureObject of %s at %f, %f position.\n", texture.toString(), x, y);
    }
}