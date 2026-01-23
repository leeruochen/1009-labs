package github.com_1009_lab.lwjgl3;

import java.util.List;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;

public class EntityManager {
    private List<Entity> entitiyList;
    
    public EntityManager() {
        entitiyList = new ArrayList<Entity>();
    }

    public void addEntities(Entity entity) {
        entitiyList.add(entity);
    }

    public void draw(SpriteBatch batch) {
        for (Entity entity : entitiyList) {
            entity.draw(batch);
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        for (Entity entity : entitiyList) {
            entity.draw(shapeRenderer);
        }
    }

    public void movement() {
        for (Entity entity : entitiyList) {
            entity.movement();
        }
    }
}
