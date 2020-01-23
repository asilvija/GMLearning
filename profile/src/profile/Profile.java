package profile;

public class Profile {


	public int sumTo(int limit) {
	
		int sum = 0;
		
		for (int value = 0; value <= limit; value++) {
			sum = new Calc().accumulate(sum, value);
		}
		
		return sum;
	}
	
	public int sumTo1(int limit) {
	    
        int sum = 0;
        
        for (int value = 0; value <= limit; value++) {
            sum += value;
        }
        
        return sum;
    }
	
	public int sumToOptimized(double limit) {
	    
	    int res = (int)(limit*((limit+1)/2));
        return res;
	}
}
