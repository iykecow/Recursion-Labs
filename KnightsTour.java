public class KnightsTour {
    
    private int [][] board;
    private int counter = 0;
    private int stuck = 0;
    private int finish = 0;

    private int xDim = 0;
    private int yDim = 0;

    private void knightMove(int [][] arr, int a, int x, int y, int left, int up) {

        System.out.println("COUNTER IS " + counter);
        // System.out.println("xDim IS " + xDim);
        // System.out.println("yDim IS " + yDim);

        if (counter==(xDim*yDim)-1) {
            System.out.println("YES");
            finish++;
            return;
        }

        if (x+left>xDim-1) {
            counter++;
            stuck++;
            return;
        }
        else if (y+up>yDim-1) {
            counter++;
            stuck++;
            return;
        }
        else if (y+up<0) {
            counter++;
            stuck++;
            return;
        }
        else if (x+left<0) {
            counter++;
            stuck++;
            return;
        }

        else if (arr[x+left][y+up]==10) {
            counter++;
            stuck++;
            return;
        }
        else {
            counter++;
            arr[x][y]++;
            arr[x+left][y+up]=9;
            // System.out.println("Hello World");
            new KnightsTour(arr);
        }
    }

    public KnightsTour(int [][] data)
    {
        board = data;

        xDim = board.length;
        yDim = board[0].length;


        // Notes: 
        //  0  = Square Knight hasn't gone to yet
        //  9  = Knight square
        //  10 = Already went to this square
        //  

        if (counter==0) {
            data[4][4] = 9;
        }

        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[0].length; j++) {

                if (data[i][j]==9) {
                    for (int k=0; k<8; k++) {
                        if (k==0) {
                            knightMove(data,k,i,j,3,-1);
                        }
                        if (k==1) {
                            knightMove(data,k,i,j,-3,1);
                        }
                        if (k==2) {
                            knightMove(data,k,i,j,3,1);
                        }
                        if (k==3) {
                            knightMove(data,k,i,j,-3,-1);
                        }
                        if (k==4) {
                            knightMove(data,k,i,j,1,-3);
                        }
                        if (k==5) {
                            knightMove(data,k,i,j,-1,3);
                        }
                        if (k==6) {
                            knightMove(data,k,i,j,1,3);
                        }
                        if (k==7) {
                            knightMove(data,k,i,j,-1,-3);
                        }

                        // System.out.println("DONE");
                    }
                }
            }
        }


        // for (int i=0; i<data.length; i++) {
        //     System.out.println("");

        //     for (int j=0; j<data[0].length; j++) {
        //         System.out.print(data[i][j]);
        //         System.out.print(" ");


        //     }
        // }

        System.out.println("Total number of runs: " + counter);
        System.out.println("Successful runs: " + (counter-stuck));
        System.out.println("Failed Runs: " + stuck);

    }
    
}
