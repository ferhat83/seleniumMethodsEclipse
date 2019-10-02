package practice;

public class ReverseString {

	public static void main(String[] args) {
		//1-reverse using array of char
		
//		String word = "dream";
//		String reverse="";
//		char [] charArray = word.toCharArray();
//		for(int i = charArray.length-1; i>=0; i--) {
//			reverse += charArray[i];
//			System.out.println(reverse); // to print all loop steps
//		}
//		System.out.println("the reverse word of dream is : " + reverse);
//		
		
		//2- reverse using for loop
		String toReverse = "dream";
		String reverseTo = ""; 
		for (int i = toReverse.length()-1; i>=0 ; i--) {
			reverseTo += toReverse.charAt(i);
		}
		System.out.println("the reverse word of dream is : "+ reverseTo);
		
		
	}

}
