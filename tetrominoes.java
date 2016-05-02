/**
 * Created by silversurfer on 4/27/2016.
 */
public abstract class tetrominoes {

    int tetrominoes[][] =new int[4][4];
    int stage;

    public void tetrominoes() {
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                tetrominoes[i][j] = 0;
            }
        }
        stage=0;
    }

    public abstract void init();

    public void reset(){
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                tetrominoes[i][j] = 0;
            }
        }
    }

    public abstract void rotateLeft();

    //This is used to rotate the tetromino clockwise
    public abstract void rotateRight();

    public void print(){
        int i, j;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(""+tetrominoes[i][j]);
            }
            System.out.println();
        }
    }

}
