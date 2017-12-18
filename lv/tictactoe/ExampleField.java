package lv.tictactoe;

public class ExampleField {
    public void printExample() {
        System.out.println();
        int[][] example = {{1, 4, 7},
                           {2, 5, 8},
                           {3, 6, 9}};
        for (int i=0;i<example.length;i++){
            for (int j=0;j<example[i].length; j++){
                System.out.print(example[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Enter valid number as in example");
        System.out.println();
    }
}


