
public class EnumTest {

	private enum TYPE{
		AAA,
		BBB,
		CCC
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TYPE type = TYPE.AAA;
		System.out.println(type.toString().contains("A"));
		System.out.println(type.toString());
	}

}
