import java.util.Scanner;

public class game {
    

    Scanner scanner = new Scanner(System.in);
    //Array que ira fazer o papel de tabuleiro no jogo.
    //Array represent the game board.
    String[][] board = new String [3][3];

    private int player = 0; // 0 == o and 1 == x.
    // stop the game when someone wins or when it ends in a draw.
    private int stop = 1;
    //Counts how many rounds were played.
    private int count = 1;

    //Filling the array.
    public game(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " ";
            }
        }
    }

    // Object that will run the game.
    public void execulte(){
        do{
            window();
            checkPlayerTurn();
            moves();
            verifyMatch();
        }while (stop != 0);
    }
    
    public void window(){
        System.out.println("   0   1   2");
        System.out.println("0: " + board[0][0] + " | " + board[0][1] + " | "  + board[0][2]);
        System.out.println("1: " + board[1][0] + " | " + board[1][1] + " | "  + board[1][2]);
        System.out.println("2: " + board[2][0] + " | " + board[2][1] + " | "  + board[2][2]);
    }


    public int checkPlayerTurn(){
        if (player == 0){
           
            player = 1;
        
        }else {
            
            player = 0;
        }

        return player;
    }

    public void moves (){
        int lineMove, columnMove;

        do {
            System.out.println("Choose a line: ");
            lineMove = scanner.nextInt();
            System.out.println("Choose a column: ");
            columnMove = scanner.nextInt();


            if(lineMove >= 0 && lineMove < 3 && columnMove >= 0 && columnMove < 3 && board[lineMove][columnMove] == " "){
                fillBoard(lineMove, columnMove);
                break;
            }else{

                System.err.println("Invalid movement, try again!!");

            }
        }while (true);
        
    }

    public String fillBoard(int line, int column){
        if (player == 0){
            board[line][column] = "o";
        
        }else{
            board[line][column] = "x";
        }
        return board[line][column];
    }

    public void verifyMatch(){
        if (count < 9){

            for(int i = 0; i < 3; i++){
                if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != " "){
                    if (player == 0){
                        window();
                        System.out.println("The 'o' won!");
                        stop = 0;
                    }else{
                        window();
                        System.out.println("The 'x' won!");
                        stop = 0;
                    }

                }
            }

            for(int i = 0; i < 3; i++){
                if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != " "){
                    if (player == 0){
                        window();
                        System.out.println("The 'o' won!");
                        stop = 0;
                    }else{
                        window();
                        System.out.println("The 'x' won!");
                        stop = 0;
                    }

                }
            }

            if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != " ") || (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != " ")){
                if (player == 0){
                    window();
                    System.out.println("The 'o' won!");
                    stop = 0;
                }else{
                    window();
                    System.out.println("The 'x' won!");
                    stop = 0;
                }

            }

        }else{
            window();
            System.out.println("Draw!");
            stop = 0;
        }
        count++;
    }

}

