public class RoachPop{
	private long r;
	public RoachPop(long a){
		this.r = a;
	}
	public void breed(){
		this.r *= 2;
	}
	public void spray(long per){
		this.r = this.r - this.r * per / 100;
	}
	public long getR(){
		return this.r;
	}

}