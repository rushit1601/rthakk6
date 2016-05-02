/**
 * Created by silversurfer on 4/27/2016.
 */
public class Tet_J extends tetrominoes {


    @Override
    public void init() {
        reset();
        tetrominoes[2][0] = 1;
        tetrominoes[3][0] = 1;
        tetrominoes[3][1] = 1;
        tetrominoes[3][2] = 1;
        stage = 1;

    }

    @Override
    public void rotateLeft() {

        if(stage == 1) {
            reset();
            tetrominoes[3][0] = 1;
            tetrominoes[1][1] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[3][1] = 1;
            stage = 4;
        }else if(stage == 4){
            reset();
            tetrominoes[3][2] = 1;
            tetrominoes[2][0] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[2][2] = 1;
            stage = 3;
        }else if(stage == 3){
            reset();
            tetrominoes[1][2] = 1;
            tetrominoes[1][1] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[3][1] = 1;
            stage = 2;
        }else if(stage == 2){
            reset();
            tetrominoes[2][0] = 1;
            tetrominoes[3][0] = 1;
            tetrominoes[3][1] = 1;
            tetrominoes[3][2] = 1;
            stage = 1;
        } else {
            System.out.println("Error 1:Rotate stage higher than possible");
        }


    }

    //This is used to rotate the tetromino clockwise
    @Override
    public void rotateRight() {
        if (stage == 1) {
            reset();
            tetrominoes[1][2] = 1;
            tetrominoes[1][1] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[3][1] = 1;
            stage = 2;

        } else if (stage == 2) {
            reset();
            tetrominoes[3][2] = 1;
            tetrominoes[2][0] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[2][2] = 1;
            stage = 3;

        } else if (stage == 3) {
            reset();
            tetrominoes[3][0] = 1;
            tetrominoes[1][1] = 1;
            tetrominoes[2][1] = 1;
            tetrominoes[3][1] = 1;
            stage = 4;
        } else if(stage == 4) {
            reset();
            //System.out.println("Stage"+stage);
            tetrominoes[2][0] = 1;
            tetrominoes[3][0] = 1;
            tetrominoes[3][1] = 1;
            tetrominoes[3][2] = 1;
            stage = 1;
        } else {
            System.out.println("Error 1:Rotate stage higher than possible");
        }

    }
}