package IOGetMenu;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.String;
import java.text.SimpleDateFormat;  
import java.util.Calendar; 
import java.io.RandomAccessFile;

public class GetMenu {
	public static void main(String[] args) {
		try{
			//输入地址
			Scanner sc = new Scanner(System.in);
			System.out.println("输入文件或文件夹名：");
			String name = sc.nextLine();
			
			//选取文件（夹）
			File path = new File(name);		
			String[] list;
			list = path.list();  	//list数组储存了改目录下所有的文件和文件夹名
			
			//判断有多少个文件多少个文件夹
			int filecount=0;
			for(int i=0; i<list.length; i++) {
				File t = new File(name+File.separator+list[i]);
				if(t.isFile() == true){ 	//判断是否是文件
					filecount++;
				}
			}
			
			//文件分类
			String[] flist = new String[filecount];
			String[] dlist = new String[list.length - filecount];
			int a=0,b=0;
			for(int i=0;i<list.length;i++){
				File t = new File(name+File.separator+list[i]);
				if(t.isFile() == true){ 
					flist[a] = list[i];
					a++;
				}
				else{
					dlist[b] = list[i];
					b++;
				}
			}
			
			//按文件名排序
			if((a == filecount )&& ((a+b)==list.length)){
				for(int i=1;i<a;i++){
					for(int j=0;j<a-i;j++){
						if(flist[j].compareTo(flist[j+1]) > 0){
							String temp = flist[j];
							flist[j] = flist[j+1];
							flist[j+1] = temp;
						}
					}
				}
				for(int i=1;i<b;i++){
					for(int j=0;j<b-i;j++){
						if(dlist[j].compareTo(dlist[j+1]) > 0){
							String temp = dlist[j];
							dlist[j] = dlist[j+1];
							dlist[j+1] = temp;
						}
					}
				}
			}
			
			//合并数组
			for(int i=0;i<list.length;i++){
				if(i < b){
					list[i] = dlist[i];
				}
				else if(i >= b){
					list[i] = flist[i-b];
				}
			}
			
			//生成信息列表
			RandomAccessFile rf=new RandomAccessFile("d:\\abc.txt","rw");   
		    rf.seek(rf.length());  //将指针移动到文件末尾   
		    String str = "文件名\r\t类型\r\t修改时间\r\t大小\r\n";
		    rf.write(str.getBytes()); //字符串末尾需要换行符   
		        
			for(int i=0;i<list.length;i++){
				File t = new File(name+File.separator+list[i]);
				//选取文件最后修改时间
				Calendar cal = Calendar.getInstance();  
		        long time = t.lastModified();  
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		        cal.setTimeInMillis(time);   
		       
				if(t.isFile()==true){
					String temp = list[i]+"\r\t"+"文件"+"\r\t"+formatter.format(cal.getTime())+"\r\t"+t.length()+"b"+"\r\n";
					rf.write(temp.getBytes()); 
				}
				else{
					String temp = list[i]+"\r\t"+"文件夹"+"\r\t"+formatter.format(cal.getTime())+"\r\n";
					rf.write(temp.getBytes());
				}
			}
			 rf.close();//关闭文件流   
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}



