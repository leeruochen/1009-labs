public class bruh {
    public static void main(String[] args) {
        System.out.println("Welcome to SOLID Entity Manager");
        EntityManager entityManager = new EntityManager();

        entityManager.registerFactory(Player.class, new PlayerFactory());
        entityManager.registerFactory(Enemy.class, new EnemyFactory());

        Player player = entityManager.createEntity(Player.class);
        Enemy enemy = entityManager.createEntity(Enemy.class);

        player.printType();
        enemy.printType();
    }
}
