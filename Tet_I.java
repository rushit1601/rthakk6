/**
 * Created by silversurfer on 4/27/2016.
 */
public class Tet_I extends tetrominoes {


    @Override
    public void init() {
        int i;
        for (i = 0; i < 4; i++) {
            tetrominoes[i][0] = 1;
        }
        stage = 1;

    }

    @Override
    public void rotateLeft() {


    }
    //This is used to rotate the tetromino clockwise
    @Override
    public void rotateRight() {
        int i;
        if (stage == 1) {
            reset();
            for (i = 0; i < 4; i++) {
                tetrominoes[3][i] = 1;
            }
            stage = 2;

        } else if (stage == 2) {
            reset();
            for (i = 0; i < 4; i++) {
                tetrominoes[i][0] = 1;
            }
            stage = 1;

        } else if (stage == 0) {
            System.out.println("Error 0:In stage 0 can't move rotate");
        } else {
            System.out.println("Error 1:Rotate stage higher than possible");
        }
    }

}