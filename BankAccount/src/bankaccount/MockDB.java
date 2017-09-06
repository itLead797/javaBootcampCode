package bankaccount;

public class MockDB implements BankDB {

	@Override
	public int[] getData(int account) {
		int[] data;
		switch(account) {
		case 1111 :
			data = new int[] {0,0,0,100,500}; 
			break;
		case 2222 :
			data = new int[] {0,0,0,100,500}; 
			break;
		case 3333 :
			data = new int[] {0,0,0,100,500}; 
			break;
		case 4444 :
			data = new int[] {0,0,0,100,500}; 
			break;
		case 5555 :
			data = new int[] {0,0,0,100,500}; 
			break;
		default :
			data = null;
		}
		return data;
	}

	@Override
	public void putData(int account, int[] data) {
	}

}
