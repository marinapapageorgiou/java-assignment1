import java.util.Scanner;
import java.util.ArrayList;
class Round
{
	private Dealer dealer;
	private ArrayList<Player> myList = new ArrayList<Player>(); 
	private ArrayList<Player> ekkremotita = new ArrayList<Player>(); 
	
	
	public Round(River game){
		this.dealer=new Dealer(game);
	}
	
	public void addPlayer(CasinoCustomer customer){
		Player player=new Player(customer);
		this.myList.add(player);
	}
	
	public void playRound(){
		
		//----------------Pontaroun oi paiktes-----------------------
		for(int i=0;i<this.myList.size();i++){
			this.myList.get(i).placeBet();
		}
		
		//----------------O dealer moirazei apo ena xarti se kathe paikth--------
		for(int i=0;i<this.myList.size();i++){
			this.dealer.deal(this.myList.get(i));         
		}
		
		this.dealer.draw();
		//----------------Typwnei to xeri tou dealer-----------------
		System.out.println(this.dealer);
		
		//---------------O dealer moirazei to 2 xarti se kathe paikth--------
		for(int i=0;i<this.myList.size();i++){
			this.dealer.deal(this.myList.get(i));         
		}
		this.dealer.draw();
		
		//-----------typwnei ta xeria twn paiktwn--------------------
		for(int i=0;i<this.myList.size();i++){
			System.out.println(this.myList.get(i));
		}
		
		if (this.dealer.getDealerhand().isBlackjack()){
			for(int i=0;i<this.myList.size();i++){
				if(!this.myList.get(i).getPlayerhand().isBlackjack()){
					this.myList.get(i).loses();
				}
			}	
		}else if(!this.dealer.getDealerhand().isBlackjack()){
			for(int i=0;i<this.myList.size();i++){
				if(this.myList.get(i).getPlayerhand().isBlackjack()){
					this.myList.get(i).winsBlackJack();
				}else{
					playPlayer(this.myList.get(i));       
				}
	
			}
				
			System.out.println(dealer);
			while (this.dealer.getDealerhand().getPoints()<17) {
				this.dealer.draw();
				System.out.println(dealer);
			}
				
			System.out.println("--------------------------");
				
			if (this.dealer.getDealerhand().getPoints()>21) {
				for(int i=0;i<this.myList.size();i++){
					if (!this.myList.get(i).getPlayerhand().isBust() &&!this.myList.get(i).getPlayerhand().isBlackjack()) {
						this.myList.get(i).wins();
					}
				}
			}else {
				for (int i=0;i<this.ekkremotita.size();i++) {
					this.dealer.settle(this.ekkremotita.get(i));
				}
			}		
		}
	}         
	
	private void playPlayer(Player player){
		System.out.println("------------------------------------");
		System.out.println(player);
		if (player.getPlayerhand().canSplit()){		
			if(player.wantsToSplit()){ 
				playSplitHand(player);
			} else {
				playNormalHand(player);
			}
		}else if(player.wantsToDouble()){
					playDoubledHand(player);
					
		}else{
			playNormalHand(player);
		}
	}
	
	
	private void playNormalHand(Player player){
		String answer;
		
		System.out.println(player);
		System.out.println("Hit? (yes/no)");
		Scanner input=new Scanner(System.in);
		answer=input.next();
		
		while(answer.equals("yes") && !player.getPlayerhand().isBust()){       
			this.dealer.deal(player);          
			System.out.println(player.getPlayerhand());  
				
			if(!player.getPlayerhand().isBust()){
				System.out.println("Hit? (yes/no)");
				answer=input.next();
			}
		}    
		
		if(player.getPlayerhand().isBust()){
			player.loses();
			System.out.println(player.getPlayerhand());     
		}else{
			this.ekkremotita.add(player);
		}
	}
	
	private void playDoubledHand(Player player){
		player.doubleBet();

		this.dealer.deal(player);
		System.out.println(player.getPlayerhand());   
		
		if(player.getPlayerhand().isBust()){
			player.loses(); 
		}else{
			this.ekkremotita.add(player);
		}
	}
	
	private void playSplitHand(Player player){
		Hand[] doubleHand;
		doubleHand = player.getPlayerhand().split(player.getPlayerhand());
		
		System.out.println("doublehand 1: "+ doubleHand[0]);
		System.out.println("doublehand 2: "+doubleHand[1]);

		
		Player player1=new Player(player.getCustomer(),doubleHand[0],player.getBet());       
		Player player2=new Player(player.getCustomer(),doubleHand[1],player.getBet());      
		
		playNormalHand(player1);
		playNormalHand(player2);
	}
	
	
	
	public static void main(String args[]){
		River river=new River(6);
		Round round=new Round(river);
		
		CasinoCustomer marina=new CasinoCustomer("Marina",100);
		round.addPlayer(marina);
		
		CasinoCustomer dimitra=new CasinoCustomer("Dimitra",200);
	    round.addPlayer(dimitra);
		
		round.playRound();
	}
}                

//NAME: MARINA PAPAGEORGIOU
//AM: 4757