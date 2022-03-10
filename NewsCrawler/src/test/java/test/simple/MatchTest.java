package test.simple;

public class MatchTest {

	public static void main(String[] args) {
		String key = "테스트";
		String text = "우리가 해야하는 테트 스트링";
		
		System.out.println(text.matches("(.*)"+key+"(.*)"));

	}

}
