package IOBuffer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class BufferTest {
	public static void main(String[] args) {
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("�����ļ�");
			String name = sc.nextLine();
			
			//�������������ַ��������ļ�
			long startTime = System.currentTimeMillis();
			FileReader input = new FileReader(name);
			FileWriter output = new FileWriter("d:\\1.txt");
			int c;
			while( (c=input.read()) != -1 ) {
				output.write(c);
			}
			input.close();
			output.close();
			long endTime = System.currentTimeMillis();
			System.out.println("�������������ַ��������ļ�����ʱ�䣺" + (endTime - startTime) + "ms");
			
			//�����������ַ��������ļ�
			long startTime2 = System.currentTimeMillis();
			FileReader input2 = new FileReader(name);
			BufferedReader binput = new BufferedReader(input2);
			FileWriter output2 = new FileWriter("d:\\2.txt");
			BufferedWriter boutput = new BufferedWriter(output2);
			binput.close();
			boutput.close();
			long endTime2 = System.currentTimeMillis();
			System.out.println("�����������ַ��������ļ�����ʱ�䣺" + (endTime2 - startTime2) + "ms");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
