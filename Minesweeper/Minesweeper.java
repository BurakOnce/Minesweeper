import java.util.Random;

/*
 * This program generates a minesweeper board
 */

public class Minesweeper {

   
    int rows; // number of rows of the board
    int cols; // number of columns of the board
    int numMines;
    int x,y;
     boolean[][] mineField;
   
       
    
    /*
     * Class Constructor
     * 
     * @param int rows Number of rows of the board
     * 
     * @param int cols Number of columns of the board
     * 
     * @param int numMines Number of mines to be placed on the board
     * 
     */
    Minesweeper(int rows, int cols, int numMines) {
        this.rows=rows;
        this.cols=cols;
        this.numMines=numMines;
        
         boolean[][] mineField = new boolean[rows][cols];
        generateBoard();
        
    }

    /*
     * Generates the mineField
     * 
     * @param int numMines Number of mines to be placed on the mineField
     * 
     * @return boolean[][] Game board with mines placed at random position
     */
    public void generateBoard() {
       
       
       for(int i=0 ; i<numMines ; i++){
          
        Random r = new Random();
       x = r.nextInt(rows);
       y = r.nextInt(cols);
       
        if(mineField[x][y]==true){
            
        }
        else{
             mineField[x][y]=true;
        }
       
         
       }
          
       //TODO
    }

    /*
     * Creates the game
     * 
     * @return int[][] The board with cell values computed
     */
    public int[][] generateClues() {
        
         int[][] clues = new int[rows][cols];
        
          for(int i=0 ;i<rows ; i++){
                for(int p=0 ;p<cols ; p++){
                    
            if(mineField[i][p]==true)
            clues[i][p]=-1;
             
            else
            clues[i][p]=countMines(i,p) ;
            
        }
            
        }
    
        return null;
    }

    /*
     * counts the number of adjacent mines to a given cell position
     * 
     * @param int r row position
     * 
     * @param int c column position
     * 
     * @return int number of mines in the surrounding cells
     */
    public int countMines(int r, int c) {
        int count = 0;
        
        if(r-1 < 0 && c-1 < 0)
        {
                    if(mineField[r][c+1]==true)
                     count++;
                     if(mineField[r+1][c]==true)
                     count++;
                     if(mineField[r+1][c+1]==true)
                     count++;
        }
        else if(r-1 < 0 && c >= 0)
        {
                    if(mineField[r][c-1]==true)
                     count++;
                     if(mineField[r][c+1]==true)
                     count++;
                     if(mineField[r+1][c-1]==true)
                     count++;
                     if(mineField[r+1][c]==true)
                     count++;
                     if(mineField[r+1][c+1]==true)
                     count++;
        }
        else if(r-1 < 0 && c+1 > cols)
        {
                    if(mineField[r][c-1]==true)
                     count++;
                     if(mineField[r+1][c-1]==true)
                     count++;
                     if(mineField[r+1][c]==true)
                     count++;
        }
        else if(r-1 >= 0 && c-1 < 0)
        {
                    if(mineField[r][c+1]==true)
                     count++;
                     if(mineField[r-1][c]==true)
                     count++;
                     if(mineField[r-1][c+1]==true)
                     count++;
                     if(mineField[r+1][c+1]==true)
                     count++;
                     if(mineField[r+1][c]==true)
                     count++;
        }
        else if(r-1 >= 0 && c+1 > cols)
        {
                    if(mineField[r][c-1]==true)
                     count++;
                     if(mineField[r-1][c]==true)
                     count++;
                     if(mineField[r-1][c-1]==true)
                     count++;
                     if(mineField[r+1][c-1]==true)
                     count++;
                     if(mineField[r+1][c]==true)
                     count++;
        }
        else if(r+1 > rows && c-1 < 0)
        {
                    if(mineField[r][c+1]==true)
                     count++;
                     if(mineField[r-1][c+1]==true)
                     count++;
                     if(mineField[r-1][c]==true)
                     count++;
        }
        else if(r+1 > rows && c-1 >= 0)
        {
                    if(mineField[r][c-1]==true)
                     count++;
                     if(mineField[r][c+1]==true)
                     count++;
                     if(mineField[r-1][c-1]==true)
                     count++;
                     if(mineField[r-1][c]==true)
                     count++;
                     if(mineField[r-1][c+1]==true)
                     count++;
        }    
        else if(r+1 > rows && c+1 > cols)
        {
                    if(mineField[r][c-1]==true)
                     count++;
                     if(mineField[r-1][c-1]==true)
                     count++;
                     if(mineField[r-1][c]==true)
                     count++;
        }
      
      
     
        
        
       
    
        return count;
    }

    /*
     * prints the game mine is represented by *
     * 
     * @param int[][] game The game board
     */
    public static void printClues(int[][] clues) {
        
       for(int i=0 ;i<3 ; i++){
                for(int p=0 ;p<3 ; p++){
                    
             System.out.println(clues[i][p]);
        }
        
        }
     
    }



    public static void main(String[] args) {

      Minesweeper m = new Minesweeper(2, 2, 2);
        System.out.print(m.mineField);


    }

}
