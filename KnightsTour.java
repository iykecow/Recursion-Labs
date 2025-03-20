public class KnightsTour {
    
    private int [][] board;
    private int counter = 0;
    private int stuck = 0;
    private int finish = 0;

    private int xDim = 0;
    private int yDim = 0;

    private void knightMove(int [][] arr, int a, int x, int y, int left, int up) {

        // System.out.println("COUNTER IS " + counter);
        // System.out.println("xDim IS " + xDim);
        // System.out.println("yDim IS " + yDim);

        if (counter==63) {
            System.out.println("YES");
            finish++;
            return;
        }

        if (x+left>xDim-1) {
            counter++;
            System.out.println("HERE");
            stuck++;
            return;
        }
        else if (y+up>yDim-1) {
            counter++;
            System.out.println("HERE");
            stuck++;
            return;
        }
        else if (y+up<0) {
            counter++;
            System.out.println("HERE");
            stuck++;
            return;
        }
        else if (x+left<0) {
            counter++;
            System.out.println("HERE");
            stuck++;
            return;
        }

        else if (arr[x+left][y+up]==10) {
            counter++;
            System.out.println("HERE");
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




    private int[][] knight_checker(int[][] data, int x, int y) {
        int[][] storage = new int [8][2];
        int tempstorage = 0;
        for (int i=0; i>storage.length; i++) {
        
            if ((x+1) < 8 && (y-2) > 0) {
                if (data[x+1][y-2]!=10) {
                    tempstorage++;
                }
            }
            if ((x-1) > 0 && (y+2) < 8) {
                if (data[x-1][y+2]!=10) {
                    tempstorage++;
                }
            }
            if ((x+1) < 8 && (y+2) < 8) {
                if (data[x+1][y+2]!=10) {
                    tempstorage++;
                }
            }
            if ((x-1) > 0 && (y-2) > 0) {
                if (data[x-1][y-2]!=10) {
                    tempstorage++;
                }
            }
            if ((x+2) < 8 && (y-1) > 0) {
                if (data[x+2][y-1]!=10) {
                    tempstorage++;
                }
            }
            if ((x-2) > 0 && (y+1) < 8) {
                if (data[x-2][y+1]!=10) {
                    tempstorage++;
                }
            }
            if ((x+2) < 8 && (y+1) < 8) {
                if (data[x+2][y+1]!=10) {
                    tempstorage++;
                }
            }
            if ((x-2) > 0 && (y-1) > 0) {
                if (data[x-2][y-1]!=10) {
                    tempstorage++;
                }
            }

            storage[i][1] = tempstorage;
            tempstorage = 0;
        }

        return storage;

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
        int[][] ashrag = knight_checker(data, 0,0);

        int smallest = 100;
        int currentsmallest = 9;

        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[0].length; j++) {
                if (data[i][j]==9) {
                    data[i][j]++;
                    int[][] tempcheck = knight_checker(data,i,j);

                    
                    for (int ii=0; ii<tempcheck.length; ii++) {
                        if (tempcheck[i][2]<smallest&&tempcheck[i][j]!=0) {
                            smallest = tempcheck[i][2];
                            currentsmallest = tempcheck[i][1];
                        }
                }
            }
        }

        // 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0
        // 0 0 2 0 3 0 0 0
        // 0 6 0 0 0 7 0 0
        // 0 0 0 9 0 0 0 0
        // 0 8 0 0 0 5 0 0
        // 0 0 4 0 1 0 0 0
        // 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0


            if (currentsmallest==1) {
                data[i+1][j-2]=9;
            }
            if (currentsmallest==2) {
                data[i-1][j+2]=9;
            }
            if (currentsmallest==3) {
                data[i+1][j+2]=9;
            }
            if (currentsmallest==4) {
                data[i-1][j-2]=9;
            }
            if (currentsmallest==5) {
                data[i+1][j-2]=9;
            }


        //         if (data[i][j]==9) {
        //             for (int k=0; k<8; k++) {
        //                 if (k==0) {
        //                     knightMove(data,k,i,j,2,-1);
        //                 }
        //                 if (k==1) {
        //                     knightMove(data,k,i,j,-2,1);
        //                 }
        //                 if (k==2) {
        //                     knightMove(data,k,i,j,2,1);
        //                 }
        //                 if (k==3) {
        //                     knightMove(data,k,i,j,-2,-1);
        //                 }
        //                 if (k==4) {
        //                     knightMove(data,k,i,j,1,-2);
        //                 }
        //                 if (k==5) {
        //                     knightMove(data,k,i,j,-1,2);
        //                 }
        //                 if (k==6) {
        //                     knightMove(data,k,i,j,1,2);
        //                 }
        //                 if (k==7) {
        //                     knightMove(data,k,i,j,-1,-2);
        //                 }

        //                 // System.out.println("DONE");
        //             }
        //         }
        //     }
        // }


        // for (int i=0; i<data.length; i++) {
        //     System.out.println("");

        //     for (int j=0; j<data[0].length; j++) {
        //         System.out.print(data[i][j]);
        //         System.out.print(" ");


        //     }
        // }

        // System.out.println("Total number of runs: " + counter);
        // System.out.println("Successful runs: " + (counter-stuck));
        // System.out.println("Failed Runs: " + stuck);

    }
    
}
