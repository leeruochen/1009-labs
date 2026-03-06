public class EnemyFactory implements EntityFactory<Enemy> {
    @Override
    public Enemy createEntity(){
        return new Enemy();
    }
}
