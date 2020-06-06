package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.*;

class wordMap {
	TreeMap<String, Integer> word = new TreeMap<String, Integer>();
	public String text;
}

public class special {
	public static void main(String[] args)throws Exception {
		
		Scanner ssc = new Scanner(System.in);
		
		
		File alltxt = new File("C:/AAA");
		
		String[] dirs = alltxt.list();		// AAA���Ͽ� ��� txt ���� ��� �о����
		
		
		wordMap[] WM = new wordMap[dirs.length];	// Map�� �������� map class �迭 ����
		for(int i=0;i<dirs.length; i++) {			// �ʱ�ȭ
			WM[i] = new wordMap();
		}
		
		File forder = new File("C:/AAA_INDEX");
		forder.mkdirs();
		File file = new File("C:/AAA_INDEX/index.txt");	// INDEX ���� path
		String select, word;
		int n;
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		List list = new ArrayList();
		
		System.out.println("������ �����ϼ���------------------1�� : �ε���  2�� : �˻�  3�� : ����");
		n = ssc.nextInt();
		switch(n){
			case 1 :
				
					String kind;
					int cnt;
					FileWriter fw = new FileWriter(file);
					Scanner sc;
					FileReader infile;
					for(int i=0;i<dirs.length;i++) {
						
						infile = new FileReader("C:/AAA/"+dirs[i]);	// �о���� AAA���� �ȿ� �����ϴ� txt ���ϸ�
						sc = new Scanner(infile);			// C/AAA���� �ȿ� �ִ�  ���� ��
						
						while(sc.hasNext()) {	// �ܾ� �ϳ��� �о����
							kind = sc.next();
							if(WM[i].word.containsKey(kind)) {	// �ߺ��Ǵ� �ܾ����� Ȯ��
								cnt = WM[i].word.get(kind);	// �ߺ��Ǹ� value ���� �󵵼� +1
								cnt++;
								WM[i].word.put(kind,cnt);	// �󵵼��� �÷��� �ٽ� �־���
							}
							else
								WM[i].word.put(kind, 1);
						}
						
						// �� �� while���� ����Ǹ� �ϳ��� ������ �� �о���� ��.
							
						
						WM[i].text = dirs[i];	//�о� ���� �ؽ�Ʈ ���� �̸��� ����.
						
					}
					
					for(int i=0; i<dirs.length; i++) {
						System.out.println(WM[i].word);
						System.out.println(WM[i].text);
					}
					
					break;
			case 2 :
				if(file.exists()) {  // �ε��� ������ �����Ҷ� �ܾ� �Է¹ް� Ž��
					System.out.print("���ǹ��� �Է��ϼ��� ==> ");
					word = ssc.next();
					
				}
				else {				// �ε��� ������ ���� ��
					System.out.print("�ε��� ���� �������ּ���. �ε����� �����ұ��?(y/n)");
					select = ssc.next();
					if(select == "y")
					{
										// �ε��� ����
					}
					else
						return ;
				} 
				break;
			case 3 :
				break;
		}
		
		
		
		
	}

	
}
