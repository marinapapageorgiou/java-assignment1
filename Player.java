import java.util.Scanner;
class Player
{
	private CasinoCustomer customer;             
	private  Hand playerhand;                       
	private double bet;
	
	public Player(CasinoCustomer customer){
		this.customer=customer;
		this.playerhand=new Hand();	
	}
	
	public Player(CasinoCustomer customer,Hand playerhand,double bet){
		this.customer=customer;
		this.playerhand=playerhand;
		this.bet=bet;
	}
	
	public CasinoCustomer getCustomer(){
		return this.customer;
	}
	
	public Hand getPlayerhand(){
		return this.playerhand;
	}
	
	public double getBet(){
		return bet;
	}
	
	public void winsBlackJack(){
		double x=this.bet*1.5;
		this.customer.collectBet(x);
		System.out.println("Blackjack! Player: "+this.customer+" collects: "+x);
	}
	
	public void wins(){
		System.out.println(this.customer + " wins the round and take "+this.bet+"$ !!!");
		this.customer.collectBet(this.bet);
		System.out.println(this.customer + " has " +this.customer.getCasinoCustomerMoney() + "$");
	}
	

	public void loses(){
		this.customer.payBet(this.bet);
		System.out.println(this.customer + " lose the round and pay "+this.bet+"$ !");
		System.out.println(this.customer + " has " +this.customer.getCasinoCustomerMoney() + "$");
	}
	
	public void placeBet(){           
		this.customer.printState();
		System.out.println("Give the bet:");
		Scanner input=new Scanner(System.in);
		this.bet=input.nextInt();
		while(this.bet<1 || !this.customer.canCover(this.bet)){
            if (this.bet<1){
				System.out.println("The bet must be more than 1 euro.");
			}else{
				 System.out.println("You haven't enough money for this bet.");
			}
			System.out.println("Give the bet:");
		    this.bet=input.nextInt();
		}
	}
	
	public void doubleBet(){
		this.bet=this.bet*2;
	}
	
	public boolean wantsToDouble(){
		if(this.customer.canCover(2*this.bet)){                      
			Scanner input=new Scanner(System.in);
			System.out.println("Do you want to double?:");
			String answer=input.next();
			if(answer.equals("yes")){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean wantsToSplit(){
		
		if(this.customer.canCover(2*this.bet) && this.playerhand.canSplit() ){
			Scanner input=new Scanner(System.in);
			System.out.println("Do you want to split?:");
			String answer=input.next();
			if(answer.equals("yes")){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String toString(){
		return ("Name: "+this.customer+" Hand: "+this.playerhand);
	}
	
	public static void main(String args[]){
		CasinoCustomer marina=new CasinoCustomer("Marina",50);
		Hand playerhand=new Hand();
		Card card1=new Card("Ace");
		playerhand.addCard(card1);

		Card card2=new Card("4");
		playerhand.addCard(card2);
	
		Player player=new Player(marina,playerhand,50);  
		player.placeBet();
		marina.printState();
		
		player.wantsToSplit();
		player.wantsToDouble();
		
		marina.printState();
		player.wins();
		marina.printState();
		player.winsBlackJack();
		marina.printState();
		player.loses();
		marina.printState();     
	}    
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757