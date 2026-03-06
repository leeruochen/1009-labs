import java.util.HashMap;
import java.util.Map;

public class EntityManager {
    private final Map<Class<? extends Entity>, EntityFactory< ? extends Entity>> factories = new HashMap<>();

    public <T extends Entity> void registerFactory(Class<T> type, EntityFactory<T> factory) {
        // what <T extends Entity> does is, tells this specific method that it is going to use a type T,
        // but T isnt known yet, but it will extend Entity
        // then as for Class<T> and EntityFactory<T>, it tells the method that the type of the factory and the class must be the same as T, which is a subclass of Entity
        factories.put(type, factory);
    }

    public <T extends Entity> T createEntity(Class<T> type) {
        EntityFactory<?> factory = factories.get(type); // retrieve the factory for the given type
        if (factory == null) {
            throw new IllegalArgumentException("Unknown entity type:" + type.getSimpleName());
        }
        return type.cast(factory.createEntity());
    }
}
