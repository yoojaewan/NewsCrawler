package test.simple;

public class MatchTest {

	public static void main(String[] args) {
		String key = "�׽�Ʈ";
		String text = "�츮�� �ؾ��ϴ� ��Ʈ ��Ʈ��";
		
		System.out.println(text.matches("(.*)"+key+"(.*)"));

	}

}
