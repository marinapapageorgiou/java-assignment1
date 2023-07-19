class  CasinoCustomer
{
	private String name;
	private double money;
	
	public CasinoCustomer(String name,double money){
		this.name=name;
		this.money=money;
	}
	
	public double getCasinoCustomerMoney() {
		return this.money;
	}
	
	public void payBet(double lostbet){
		this.money=this.money-lostbet;
	}
	
	public void collectBet(double winbet){
		this.money=this.money+winbet;
	}
	
	public boolean canCover(double bet){
		if(this.money>=bet){
			return true;
		}
		return false;
	}
	
	public boolean isBroke(){
		if(money<1){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "Name: "+name;
	}
	
	public void printState(){
		System.out.println("Name: "+this.name+" Money: "+this.money);
	}
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757