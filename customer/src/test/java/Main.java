/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-17
 */

public class Main {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("ping");
            }
        };
        t.run();
        System.out.println("pong");

    }
}
