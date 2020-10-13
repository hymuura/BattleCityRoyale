package bcr.entity;

public class Game implements Runnable{

    private Game game;
    private boolean running = true;
    private int movements = 10;

    public Game() {}

    @Override
    public void run() {
        game = new Game();
        while(movements>0){
            try{
                Thread.sleep(1000);
                System.out.println("hola");
                movements--;
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
