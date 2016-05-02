/**
 * Created by silversurfer on 4/27/2016.
 */
public class Tet_O extends tetrominoes {


    @Override
    public void init() {
        reset();
        tetrominoes[2][1] = 1;
        tetrominoes[2][0] = 1;
        tetrominoes[3][0] = 1;
        tetrominoes[3][1] = 1;
        stage = 1;

    }


    @Override
    public void rotateLeft() {
        if (stage == 1) {
            System.out.println("Error 0:In stage 0 can't move rotate");

        } else if (stage == 0) {
            System.out.println("Error 0:In stage 0 can't move rotate");
        } else {
            System.out.println("Error 1:Rotate stage higher than possible");
        }
    }

    //This is used to rotate the tetromino clockwise
    @Override
    public void rotateRight() {
        if (stage == 1) {
            System.out.println("Error 0:In stage 0 can't move rotate");

        } else if (stage == 0) {
            System.out.println("Error 0:In stage 0 can't move rotate");
        } else {
            System.out.println("Error 1:Rotate stage higher than possible");
        }
    }

}