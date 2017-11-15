package IOBasicOperation;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;

public class BasicOperation {

	public static void main(String[] args) {
		
		try{
			
		//接收键盘输入的内容到src.txt
		Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        FileOutputStream fos = new FileOutputStream("src/src.txt");
        fos.write(name.getBytes());
        fos.close();
        
        //复制文件src.txt到dest.txt
        FileInputStream input = new FileInputStream("src/src.txt");
        FileOutputStream output = new FileOutputStream("src/dest.txt");
        int a;
        while((a = input.read()) != -1){
        	output.write(a);
        }
        input.close();
        output.close();
        
        //显示dest.txt
        /*FileReader fr=new FileReader("src/dest.txt");;
        int b;
        System.out.println("输出dest.txt文件的内容:");
        while((b = fr.read()) != -1){
        	System.out.println((char)b+"");
        }
        fr.close();*/
        
        String str="";
        FileInputStream in = new FileInputStream("src/dest.txt");  
        // size  为字串的长度 ，这里一次性读完  
        int size = in.available();  
        byte[] buffer = new byte[size];  
        in.read(buffer);  
        in.close();  
        str=new String(buffer,"GB2312");
        System.out.println(str);
        
        
        
        
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
