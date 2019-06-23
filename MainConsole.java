import java.util.*;

public class Main{
	public static char[][] Arr1;
	public static char[][] Arr2;
    static int x,y=0;
	static int bomb = 10;
	static char Ch = 'Y';
	public static void PrintArr(char[][] arr) {
		
		for(int i=0;i<9;i++)
		{
			System.out.println();
				for(int j=0;j<9;j++)
				{
					System.out.print(arr[i][j]);
					System.out.print(" ");
				}
		}
	}
	public static void generateNumber(int x, int  y) {
		if(x-1>-1 && y-1>-1 && x-1<9 && y-1<9 && Arr2[x-1][y-1]!='X') {
			Arr2[x-1][y-1]++;
		}
		if(y-1>-1 && y-1<9 && Arr2[x][y-1]!='X') {
			Arr2[x][y-1]++;
		}
		if(x+1>-1 && y-1>-1 && x+1<9 && y-1<9 && Arr2[x+1][y-1]!='X') {
			Arr2[x+1][y-1]++;
		}
		if(x+1>-1 && x+1<9 && Arr2[x+1][y]!='X') {
			Arr2[x+1][y]++;
		}
		if(x-1>-1 && x-1<9 && Arr2[x-1][y]!='X') {
			Arr2[x-1][y]++;
		}
		if(x-1>-1 && y+1>-1 && x-1<9 && y+1<9 && Arr2[x-1][y+1]!='X') {
			Arr2[x-1][y+1]++;
		}
		if(y+1>-1 && y+1<9 && Arr2[x][y+1]!='X') {
			Arr2[x][y+1]++;
		}
		if(x+1>-1 && y+1>-1 && x+1<9 && y+1<9 && Arr2[x+1][y+1]!='X') {
			Arr2[x+1][y+1]++;
		}
	}

	public static void main(String[] args){
		Scanner scan= new Scanner(System.in);
		Random rand=new Random();
		while(Ch == 'Y' || Ch=='y') {
			
		Arr1 = new char[9][9];
		Arr2 = new char[9][9];
		int count=0;
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				Arr1[i][j] = 'O';
				Arr2[i][j]= '0';
			}
		}
		
		PrintArr(Arr1);
		System.out.print("\n\nEnter your move (row[1-9] column[1-9]): ");
		try{
		x= scan.nextInt();
		y=scan.nextInt();
		}
		catch(InputMismatchException e){
			System.out.print("Input is not a number: ");
			x= scan.nextInt();
		y=scan.nextInt();
		}
		
		try{
		x= scan.nextInt();
		y=scan.nextInt();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.print("Input is not a number: ");
			x= scan.nextInt();
		y=scan.nextInt();
		}
		while (bomb>0)
		{
			int bx,by=0;
			bx=rand.nextInt(9);
			by=rand.nextInt(9);
			if(bx!=x && by!=y && Arr2[bx][by] == '0')
			{
				Arr2[bx][by]='X';
				bomb--;
			}
		}
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(Arr2[i][j]=='X')
				{
					generateNumber(i,j);
				}
			}
		}
		while(count<71) {
			Arr1[x-1][y-1]=Arr2[x-1][y-1];
			PrintArr(Arr1);
			if(Arr1[x-1][y-1]=='X') {
				System.out.println("\nYou losed");
				System.out.print("Do you want to play again? (Y/N):");
				Ch=scan.next().charAt(0);
				if(Ch=='Y' || Ch=='y')
				{
					break;
				}	
				else {
					return;
				}
				
			}
			System.out.print("\n\nEnter your move (row[1-9] column[1-9]): ");
			x= scan.nextInt();
			y=scan.nextInt();
			count++;
		}
		}
		}
		
		
}
