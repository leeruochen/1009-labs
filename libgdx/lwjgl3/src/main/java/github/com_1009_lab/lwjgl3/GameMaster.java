package github.com_1009_lab.lwjgl3;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input.Keys;
// import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMaster extends ApplicationAdapter {
    private TextureObject[] droplets;
    private TextureObject bucket;
    private SpriteBatch batch;

    @Override
    public void create() {
        droplets = new TextureObject[10];

        for (int i = 0; i < droplets.length; i++) {
            int randomX = (int)(Math.random() * (Gdx.graphics.getWidth() - 64));
            int randomY = (int)(Math.random() * (Gdx.graphics.getHeight() - 64));

            droplets[i] = new TextureObject("droplet.png", randomX, randomY);
        }

        bucket = new TextureObject("bucket.png", 100, 0);
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        batch.begin();
            batch.draw(bucket.getTexture(), bucket.getX(), bucket.getY(), bucket.getTexture().getWidth(), bucket.getTexture().getHeight());

            for (int i = 0; i < droplets.length; i++) {
                batch.draw(droplets[i].getTexture(), droplets[i].getX(), droplets[i].getY(), droplets[i].getTexture().getWidth(), droplets[i].getTexture().getHeight());
            }
        batch.end();
    }
}