package bcr.game;

import bcr.entity.Map;

public class App {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        Map m = new Map();
        m.start();
        long end = System.currentTimeMillis();
        System.out.println("time: ");
        System.out.println(end-init);
        System.out.println(m.getFailed());
    }
}
