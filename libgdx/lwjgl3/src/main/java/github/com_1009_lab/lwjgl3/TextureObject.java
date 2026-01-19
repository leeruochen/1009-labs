package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends Entity {
    private Texture texture;

    public TextureObject(String filePath) {
        texture = new Texture(Gdx.files.internal(filePath));
    }

    public TextureObject(String filePath, float x, float y) {
        super(x, y, 5.0f, "white"); // speed and color are not used here
        texture = new Texture(Gdx.files.internal(filePath));
    }

    public Texture getTexture() {return texture;}
    public void setTexture(Texture texture) {this.texture = texture;}

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, texture.getWidth(), texture.getHeight());
    }
}