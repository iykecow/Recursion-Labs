public class KnightsTour {
    
    private int [][] board;
    private int counter = 0;
    private int stuck = 0;

    private void function(int [][] arr, int a, int x, int y, int left, int up) {
        if (a==0) {
            if (arr[x-+left][y+up]==10) {
                stuck++;
                return;
            }
            else {
                counter++;
                arr[x][y]++;
                arr[x+left][y+up]=9;
                new KnightsTour(arr);
            }
        }
    }

    public KnightsTour(int [][] data)
    {
        board = data;

        // Notes: 
        //  0 = Knight can't go to this square
        //  9 = Knight
        //  All other numbers are square the knight CAN go to.
        //  

        if (counter==0) {
            data[4][4] = 9;
        }

        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[0].length; j++) {

                if (data[i][j]==9) {
                    for (int k=0; k<8; k++) {
                        if (k==0) {
                            function(data,k,i,j,3,-1);
                        }
                        if (k==1) {
                            function(data,k,i,j,-3,1);
                        }
                        if (k==2) {
                            function(data,k,i,j,3,1);
                        }
                        if (k==3) {
                            function(data,k,i,j,-3,-1);
                        }
                        if (k==4) {
                            function(data,k,i,j,1,-3);
                        }
                        if (k==5) {
                            function(data,k,i,j,-1,3);
                        }
                        if (k==6) {
                            function(data,k,i,j,1,3);
                        }
                        if (k==7) {
                            function(data,k,i,j,-1,-3);
                        }
                    }

                    data[i+3][j-1]=1;
                    data[i+3][j-1]=1;

                    data[i+3][j+1]=1;
                    data[i-3][j-1]=1;

                    data[i-1][j+3]=1;
                    data[i+1][j-3]=1;

                    data[i+1][j+3]=1;
                    data[i-1][j-3]=1;

                }
            }
        }


        for (int i=0; i<data.length; i++) {
            System.out.println("");

            for (int j=0; j<data[0].length; j++) {
                System.out.print(data[i][j]);
                System.out.print(" ");


            }
        }

        System.out.println("Total number of runs: " + counter);
        System.out.println("Successful runs: " + (counter-stuck));
        System.out.println("Failed Runs: " + stuck);

    }
    
}
