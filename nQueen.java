import java.util.Scanner;
public class nQueen{
	static int row =0;
	static int column=0;
	static int arreglo [][];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numeros de casillas en el tablero?");
		n = sc.nextInt(); 
		drawBoard(n);
		solveQueen(n, row,column,arreglo);
	}

	//primer numero filas
	//segundo numero columnas

	static void drawBoard(int n){
		arreglo = new int [n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arreglo[i][j]=0;
			}
		}

	}

	//n tam del tablero
	static void solveQueen(int n, int row, int column, int[][] arreglo ){	
		
		while(row!=n && placeQueen(row, column, arreglo)){

			if(isValid(row, column, arreglo)){
				placeQueen(row, column, arreglo);
				printBoard(n,arreglo);
				System.out.println();

			}

			else{
				row++;
				solveQueen(n,row,column,arreglo);
				printBoard(n,arreglo);
				System.out.println();

			}
			column++;
			row=0;	
			
		}

		// backtrack(row,column,arreglo);
		row++;


	}

	// i can only have on queen per column, therefore i only need to check the rows and diagonals
	static boolean isValid(int row, int column, int arreglo[][]){
		// checo que no este en la misma fila
		for(int i=0;i<n;i++){
			if(arreglo[row][i]==1){
				return false;
			}
		}

		// checo que no este en la misma diagonal aunque creo que esto podria mejorar bastante 
		for(int i=0;i<n;i++){
			for(int j=0;j<column;j++){
				if(arreglo[i][j]==1&&Math.abs(row-i)==Math.abs(column-j)){
					return false;
				}
			}
		}

		return true;
	}

	static boolean placeQueen(int row, int column, int arreglo[][]){
		arreglo[row][column]=1;
		return true;
	}

	static void backtrack(int row, int column, int arreglo[][]){
		arreglo[row][column]=0;
		
	}

	static void printBoard(int n, int arreglo[][]){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(" "+arreglo[i][j]);
			}
			System.out.println();
		}
	}
}