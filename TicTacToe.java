package TicTacToe;
import java.util.*;
public class TicTacToe {
	private Board board;
	private Player player1,player2;
	
	public static void main(String args[])
	{
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	
	public void startGame(){
		Scanner sc=new Scanner(System.in);
		//PLayer input
		player1=takePlayerInput(1);
		player2=takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol())
		{
			System.out.println("Symbol Same !! Choose another symbol");
			char symbol=sc.next().charAt(0);
			player2.setSymbol(symbol);
		}
		//Create Board
		board=new Board(player1.getSymbol(),player2.getSymbol());
		
		//Conduct Game
		int status=Board.INCOMPLETE;
		boolean player1Turn=true;
		while(status==Board.INCOMPLETE || status==Board.INVALID)
		{
			if(player1Turn) 
			{
				System.out.println("Player-1 :"+player1.getName()+"'s name");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				if(status!=Board.INVALID)
				{
					player1Turn=false;
					board.print();
				}
				else
				{
					System.out.println("Invalid Move!! Try Again");
				}
				
			}
			else 
			{
				System.out.println("Player-2 :"+player2.getName()+"'s name");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				if(status!=Board.INVALID)
				{
					player1Turn=true;
					board.print();
				}
				else
				{
					System.out.println("Invalid Move!! Try Again");
				}
			}
			
		}
		if(status==Board.PLAYER_1_WINS)
			System.out.println("Hurray! "+player1.getName()+" Win's");
		else if(status==Board.PLAYER_2_WINS)
			System.out.println("Hurray! "+player2.getName()+" Win's");
		else
			System.out.println("Ohhh...! It's a DRAW");
	}
	private Player takePlayerInput(int num)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Player "+ num + " Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Player "+ num + " Symbol: ");
		char symbol=sc.next().charAt(0);
		Player p=new Player(name,symbol);
		return p;
	}
}
