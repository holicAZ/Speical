package project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
							
						
						WM[i].text = dirs[i];	// �о� ���� �ؽ�Ʈ ���� �̸��� ����.
						
					}
					
					for(int i=0; i<dirs.length; i++) {	//	�޾Ƶ鿴���� Ȯ�� �ӽ� ������
						System.out.println(WM[i].word);
						System.out.println(WM[i].text);
					}
					
					for(int i=0; i< dirs.length; i++) {
						Set<Entry<String, Integer>> set = WM[i].word.entrySet();
						Iterator<Entry<String, Integer>> itr = set.iterator();
						while(itr.hasNext()) {
							Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next(); //�̺κ� ���� �ʿ���
							//https://vaert.tistory.com/107 ����
						}
						map.put(WM[i].word);
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
