/**
 * Created by silversurfer on 4/27/2016.
 */
public class Main {

    public static void main(String [] args) {
        tetrominoes I = new Tet_O();
        tetrominoes L = new Tet_O();
        tetrominoes O = new Tet_O();
        tetrominoes O1 = new Tet_O();
        tetrominoes O2 = new Tet_O();
        tetrominoes Z = new Tet_Z();
        Z.init();
        O2.init();
        O1.init();
        O.init();
        L.init();
        I.init();
        Board b1=Board.getInstance();
        System.out.println("1 board instance");
        b1.init_b();
        b1.print_b();
        System.out.println("******************");
        System.out.println("2 board instance");
        b1.insert(I,0);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();
        System.out.println("2 board instance");
        b1.insert(L,2);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();
        System.out.println("2 board instance");
        b1.insert(O,4);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();
        System.out.println("2 board instance");
        b1.insert(L,6);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();
        System.out.println("2 board instance");
        b1.insert(Z,0);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();
        System.out.println("2 board instance");
        b1.insert(O,8);
        b1.print_b();
        System.out.println("******************");
        System.out.println("3 board instance");
        b1.proceeding();
        b1.print_b();



    }
}
