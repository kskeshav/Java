import java.util.Scanner;

public class Bank{
	public SavingsAccount addAccount(String name,int ann_i,int balance){
		SavingsAccount new_acc = new SavingsAccount(name,ann_i,balance);
		return new_acc;
	}
	public void printAccounts(int n,SavingsAccount[] savings_arr){
		for(int i = 0;i<=n;i++){
			System.out.println("Owner: " + savings_arr[i].getName() + " Balance: "+ savings_arr[i].getBalance() );
		}
	}
	public static void main(String[] args){
		Bank b = new Bank();
		SavingsAccount[] arr = new SavingsAccount[10];
		Scanner uinput = new Scanner(System.in);
		int i = -1,s = 0;
		while(s == 0){
			char query = uinput.next().charAt(0);
			if(query == 'N'){
				i+=1;
				String name = uinput.next();
				int ann_i = uinput.nextInt();
				int balance = uinput.nextInt();
				arr[i] = b.addAccount(name,ann_i,balance);
			}	
			else if(query == 'D'){
				int d = uinput.nextInt();
				arr[i].deposit(d);
			}
			else if(query == 'W'){
				int w = uinput.nextInt();
				int nw = arr[i].withdraw(w);
			}
			else if(query == 'X'){
				for (int j =0;j<=i ;j++ ) {
					arr[j].addInterest();					
				}
				s = 1;
			}
		}
		b.printAccounts(i,arr);
	}
}
