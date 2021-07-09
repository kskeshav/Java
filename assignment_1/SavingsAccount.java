public class SavingsAccount{
	private String acc_name;
	private int acc_annual_i_r;
	private int acc_balance;
	public SavingsAccount(String name, int annual_i_r, int balance){
		acc_name = name;
		acc_annual_i_r = annual_i_r;
		acc_balance = balance;
	}
	int getBalance(){
		return acc_balance;
	}
	public void deposit(int amount){
		acc_balance += amount;
	}
	public int withdraw(int wa){
		if(wa<=acc_balance){
			acc_balance -= wa;
			return wa;
		}
		else{
			return 0;	
		}
	}
	public void addInterest(){
		acc_balance += (acc_balance*acc_annual_i_r)/1200;	
	}
	public String getName(){
		return acc_name;
	}
	/*
	public static void main(String[] args) {
		SavingsAccount acc1 = new SavingsAccount("Newton",15,10000);
		System.out.println("acc balance = " + acc1.getBalance());
		System.out.println("1ts withdrawal = " + acc1.withdraw(5000));
		acc1.deposit(1000);
		System.out.println("1ts withdrawal = " + acc1.withdraw(2000));
		acc1.addInterest();
		System.out.println("Account owned by " + acc1.getName() + " has a balance of " + acc1.getBalance());
	}
	*/

}