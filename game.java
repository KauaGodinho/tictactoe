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

    private int playAgain = 1;
    private String title = "Jogo da Velha";
    private int lenTitle = title.length() + 4;
    private int menuChoose = 0;

    //Filling the array.
    public game(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " ";
            }
        }
    }

    public void clearBoard(){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void homeMenu(){
        for (int i = 0; i < lenTitle; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Imprimindo o título com asteriscos
        System.out.println("* " + title + " *");

        // Imprimindo a linha de asteriscos novamente
        for (int i = 0; i < lenTitle; i++) {
            System.out.print("*");
        }
        System.out.println();
        do{
            System.out.println("1. Start");
            System.out.println("0. Exit");

            menuChoose = scanner.nextInt();

            switch (menuChoose) {
                case 1:
                    break;
            
                case 0:
                    playAgain = 0;
                    stop = 0;
                    break;

                default:
                    System.out.println("Choose a valid option!");
            }
        }while(menuChoose != 0 && menuChoose != 1);
    }
 

    // Object that will run the game.
    public void execulte(){
        homeMenu();
        do{
            clearBoard();
            stop = 1;
            player = 0;
            count = 1;
            if (playAgain == 1) {
                do{
                    window();
                    checkPlayerTurn();
                    moves();
                    verifyMatch();
                }while (stop != 0);
            }
                
            
            do{
                System.out.println("\nWould you like to play again? type 0 to exit or type 1 to continue.");
                playAgain = scanner.nextInt();
                switch(playAgain){
                    
                    case 0:
                        break;

                    case 1:
                        break;

                    default:
                        System.out.println("Invalide option, type 0 to exit or type 1 to continue"); 
                        break;     
                }
            }while(playAgain != 1 && playAgain != 0);
                
        }while(playAgain == 1 );
        
        
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
            playAgain = scanner.nextInt();
            stop = 0;
        }
        count++;
    }

}

