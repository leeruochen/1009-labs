public class PlayerFactory implements EntityFactory<Player> {
    @Override
    public Player createEntity(){
        return new Player();
    }
}
