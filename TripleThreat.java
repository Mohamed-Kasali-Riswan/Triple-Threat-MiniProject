import java.util.Scanner;

public class candyCrush {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initializing Values to the Game
		char[][]a=new char[9][1];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j]='_';
			}
		}
		
		boolean end=true;
		boolean winOccurence=false;
		
		//Welcome Description
		System.out.println("\t\t\t\t\tWELCOME TO CANDY CRUSH LITE");
		System.out.println("Press 1 to start the Game:");
		
		switch(sc.nextInt())
		{
		case 1:{
			//gaming
			while(end)
			{
				System.out.print("\nEnter 'A/a' to Roll & Zero to Exit:");
				char input=sc.next().charAt(0);
				if(input=='A' || input=='a')
				{
					if(a[0][0]=='_')
					{
						char b[][]=rollAndInsert(a);
						display(b);
						winOccurence=checkOccurence(b);
						if(winOccurence)
						{
							System.out.println("Congrats! You WON the Game...");
							end=false;
							break;
						}

					}
					else
					{
						System.out.println("Super..You had a Great Play , see you next Time!");
						end=false;
						break;
					}
				}
				else if(input=='0') 
				{
					System.out.println("You got exited from the Game");
					end=false;
					break;
				}
			}
			break;
			}
		default:{
			System.out.println("OOPS Run Again & Enter 1 to start the GAME");
			break;
		}
		}
		
	}
	

	public static void display(char a[][])
	{
		System.out.println("\n\tDisplay");
		System.out.println("\t-------\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println("\t   "+a[i][j]);;
			}
		}
	}
	
	public static char[][] rollAndInsert(char ans[][])
	{
		//rolling
		char answer[]= {'R','G','B','Y','Z'};
		int index = (int)(Math.random() * answer.length); // Ensure index is within the bounds of the answer array
	    char indexx = answer[index];	
				
			for (int i = ans.length-1; i >= 0 ; i--) 
			{
				if(ans[i][0]=='_')
				{
					ans[i][0]=indexx;
					break;
				}
			}
		return ans;
	}
	
	public static boolean checkOccurence(char a[][])
	{
		for (int i = a.length-1; i > 1; i--) 
		{
			if(a[i][0]==a[i-1][0] && a[i-1][0]==a[i-2][0] && a[i][0]!='_')
			{
					return true;	
			}
		}
		return false;
	}
}















