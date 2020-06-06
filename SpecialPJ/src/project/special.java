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
		
		String[] dirs = alltxt.list();		// AAA파일에 담긴 txt 명을 모두 읽어들임
		
		
		wordMap[] WM = new wordMap[dirs.length];	// Map을 저장해줄 map class 배열 생성
		for(int i=0;i<dirs.length; i++) {			// 초기화
			WM[i] = new wordMap();
		}
		
		File forder = new File("C:/AAA_INDEX");
		forder.mkdirs();
		File file = new File("C:/AAA_INDEX/index.txt");	// INDEX 파일 path
		String select, word;
		int n;
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		List list = new ArrayList();
		
		System.out.println("동작을 선택하세요------------------1번 : 인덱싱  2번 : 검색  3번 : 종료");
		n = ssc.nextInt();
		switch(n){
			case 1 :
				
					String kind;
					int cnt;
					FileWriter fw = new FileWriter(file);
					Scanner sc;
					FileReader infile;
					for(int i=0;i<dirs.length;i++) {
						
						infile = new FileReader("C:/AAA/"+dirs[i]);	// 읽어들인 AAA폴더 안에 존재하는 txt 파일명
						sc = new Scanner(infile);			// C/AAA폴더 안에 있는  파일 명
						
						while(sc.hasNext()) {	// 단어 하나씩 읽어들임
							kind = sc.next();
							if(WM[i].word.containsKey(kind)) {	// 중복되는 단어인지 확인
								cnt = WM[i].word.get(kind);	// 중복되면 value 값이 빈도수 +1
								cnt++;
								WM[i].word.put(kind,cnt);	// 빈도수를 늘려서 다시 넣어줌
							}
							else
								WM[i].word.put(kind, 1);
						}
						
						// 한 번 while문이 종료되면 하나의 파일을 다 읽어들인 것.
							
						
						WM[i].text = dirs[i];	//읽어 들인 텍스트 파일 이름을 저장.
						
					}
					
					for(int i=0; i<dirs.length; i++) {
						System.out.println(WM[i].word);
						System.out.println(WM[i].text);
					}
					
					break;
			case 2 :
				if(file.exists()) {  // 인덱스 파일이 존재할때 단어 입력받고 탐색
					System.out.print("질의문을 입력하세요 ==> ");
					word = ssc.next();
					
				}
				else {				// 인덱스 파일이 없을 때
					System.out.print("인덱싱 먼저 수행해주세요. 인덱싱을 시작할까요?(y/n)");
					select = ssc.next();
					if(select == "y")
					{
										// 인덱싱 시작
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
