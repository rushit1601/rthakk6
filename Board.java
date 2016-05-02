/**
 * Created by Rushit Thakker on 4/28/2016.
 * The Board class is a Instanciated using singleton design pattern
 *
 *
 *
 */

import javax.swing.*;
public class Board {

    private static Board Instace = new Board();//This is the instace of the board
    int [][] board_arr=new int[20][12];
    public final static int ONE_SECOND = 10;
    Timer time;
    tetrominoes tmp;
    int currlevel=1,origin_x,origin_y;
    int delay=(50-(currlevel*2))/60;
    int Score=0,total_rows_cleared;
    pair_of_int tmp_int=new pair_of_int();
    int [][] tmp_brd=new int [20][12];



    private Board(){

    }

    //We want to restrict the user to only one instance of the board hence
    //we create one instance in the class and then return that to the user.
    public static Board getInstance(){
        return Instace;
    }


    //Reset's the entire board to start
    public void reset_b(){
        int i, j;
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 10; j++) {
                board_arr[i][j] = 0;
            }
        }
    }
    //We print the board on the console for debugging purposes
    public void print_b(){
        int i, j;
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(""+board_arr[i][j]);
            }
            System.out.println();
        }
    }

    //initialinzing the board to be empty
    public void init_b(){
        int i, j;
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 10; j++) {
                board_arr[i][j] = 0;
            }
        }

    }

    //inserting tetromino into the board
    public void insert(tetrominoes t,int start){
        int i, j;
        if(start>8){
            return;
        }
        tmp=t;
        origin_y=0;
        origin_x=start;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                if(board_arr[i][j+start]!=1) {
                    board_arr[i][j+start] = tmp.tetrominoes[i][j];
                }
                else{
                    //Game over since we can't insert anymore tetrominos
                }
            }
        }
    }

    //We are moving the tetrimino across the
    public void clear_tet(){
        int i,j;

        for (i=0 ; i<4 ; i++) {
            for (j = 0; j<4; j++) {

                if( (i+origin_y)!=20) {
                    if (board_arr[i+origin_y][j+origin_x] == 1) {
                        board_arr[i+origin_y][j+origin_x]=0;
                    }

                }

            }

        }

    }


    //Proceed will move the block forward based on the timer
    //It also encapsulates clearing of rows and gravity
    public void proceeding(){
        boolean progress=true;
        int rows_cleared;
        time=new Timer(ONE_SECOND,null);
        System.out.println("begin proceed");
        time.addActionListener(e -> {
            int i,j;
            //System.out.println("++++++++++++++++++ at origin_y:"+origin_y);
            //this.print_b();
            //System.out.println("++++++++++++++++++");
            this.clear_tet();
            ++origin_y;
            //System.out.println("++++++++++++++++++ at origin_y:"+origin_y);
            //this.print_b();
            //System.out.println("++++++++++++++++++");


            for (i=0 ; i<4 ; i++) {
                for (j = 0; j<4; j++) {

                        if( (i+origin_y)<20) {
                            //if (board_arr[i + 1][j] == 0) {
                                board_arr[i+origin_y][j+origin_x]=tmp.tetrominoes[i][j];
                            //}

                        }
                }

            }

        });

        int i=0;
        time.start();
        while(progress) {
            i++;
            if(i==5){
                //rotate();
            }


            if(reached()){
                time.stop();
                progress=false;
                this.lock();
                tmp_int=this.clear_row();
                this.naive_gravity(tmp_int);

            }

        }

        System.out.println("end proceed");
    }

    /*
    System.out.println("++++++++++++++++++");
    this.print_b();
    System.out.println("++++++++++++++++++");
    */
    //To check if we have reached the bottom of the board or top of another tetromino
    public boolean reached(){
        int i,j;

        for (i = 19; i!=0; i--) {
            for (j = 9; j!=0; j--) {

                if(board_arr[i][j]==1) {

                    if( (i+1)==20) {
                        return true;//We have reached the bottom of our board
                    }

                    if (board_arr[i+1][j]==9){
                        return true;//We have reached the top of another tetromino
                    }
                }

            }
        }

        return false;
    }

    //
    public void rotate(){
        this.tmp.rotateLeft();
    }

    //We lock the tetromino once it hits the bottom of our board
    public void lock(){
        int i,j;
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 10; j++) {
                if(board_arr[i][j]==1) {
                    board_arr[i][j]=9 ;
                }
            }
        }
    }

    //If a row are filled then we clear those rows and add the score
    public pair_of_int clear_row(){
        int i,j,rows_cleared=0,bottom_row=-1;

        for (i = 19; i!=0; i--) {

            if(row_filled(i)){
                rows_cleared++;
                for(j=0;j<10;j++){
                    board_arr[i][j]=0 ;
                }
                if(i>bottom_row){
                    bottom_row=i;
                }

            }
        }
        System.out.println("Setting val bottom_row:"+bottom_row+" Setting val rows_cls:"+rows_cleared);
        total_rows_cleared=total_rows_cleared+rows_cleared;
        tmp_int.setval(19-bottom_row,rows_cleared);
        return tmp_int;
    }
    //We check if the row is filled the function will return true
    public boolean row_filled(int y){
        int j;
        for(j=0;j<10;j++){
            if(board_arr[y][j]==9){

            }else{
                return false;
            }
        }
        return true;
    }

    //Updates the score based on total number of rows cleared
    public void score_upate(int rows){
        if(rows==1){
            Score=Score+40;
        }else if(rows==2){
            Score=Score+100;
        }else if(rows==3){
            Score=Score+300;
        }else if(rows==4){
            Score=Score+2100;
        }
    }

    //Add row insert's new blank rows into the board
    //This is used after the gravity function moves all the objects down
    public void add_row(int val){

    }

    //This form of gravity moves every thing before the cleared lines down
    public void naive_gravity(pair_of_int rows_cleared){
        int from,i,j;
        from=rows_cleared.get_1()+rows_cleared.get_2();
        System.out.println("++++++++++++++++++");
        System.out.println("form:"+from);
        System.out.println("++++++++++++++++++");

        if(rows_cleared.get_1()!=-1) {
            for (i = 19; i!=0; i--) {
                for (j = 11; j!=-1; j--) {
                    if (i - from > 0) {
                        board_arr[i][j] = board_arr[i - from][j];
                    }
                }
            }
        }
        //Add row left
    }


    public void flood_gravity(){

    }

}