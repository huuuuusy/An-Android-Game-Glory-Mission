package hku.game;

/**
 * Created by 28573 on 7/11/2017.
 */
public class count {

    public static int[] images = new int[25];

    count(int[] images){
        images = new int[25];
    }

    public static void addImages(int i){
        images[i] = images[i]+1;
    }

    public static int getImages(int i){
        return images[i];
    }

    public static void cleanImages(){
        images = new int[25];
    }

}
