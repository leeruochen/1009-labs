package github.com_1009_lab.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureObject {
    private Texture texture;
    private int x;
    private int y;

    public TextureObject(String filePath) {
        texture = new Texture(Gdx.files.internal(filePath));
    }

    public TextureObject(String filePath, int xPos, int yPos) {
        texture = new Texture(Gdx.files.internal(filePath));
        x = xPos;
        y = yPos;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}