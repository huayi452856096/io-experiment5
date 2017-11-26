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
			//�����ַ
			Scanner sc = new Scanner(System.in);
			System.out.println("�����ļ����ļ�������");
			String name = sc.nextLine();
			
			//ѡȡ�ļ����У�
			File path = new File(name);		
			String[] list;
			list = path.list();  	//list���鴢���˸�Ŀ¼�����е��ļ����ļ�����
			
			//�ж��ж��ٸ��ļ����ٸ��ļ���
			int filecount=0;
			for(int i=0; i<list.length; i++) {
				File t = new File(name+File.separator+list[i]);
				if(t.isFile() == true){ 	//�ж��Ƿ����ļ�
					filecount++;
				}
			}
			
			//�ļ�����
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
			
			//���ļ�������
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
			
			//�ϲ�����
			for(int i=0;i<list.length;i++){
				if(i < b){
					list[i] = dlist[i];
				}
				else if(i >= b){
					list[i] = flist[i-b];
				}
			}
			
			//������Ϣ�б�
			RandomAccessFile rf=new RandomAccessFile("d:\\abc.txt","rw");   
		    rf.seek(rf.length());  //��ָ���ƶ����ļ�ĩβ   
		    String str = "�ļ���\r\t����\r\t�޸�ʱ��\r\t��С\r\n";
		    rf.write(str.getBytes()); //�ַ���ĩβ��Ҫ���з�   
		        
			for(int i=0;i<list.length;i++){
				File t = new File(name+File.separator+list[i]);
				//ѡȡ�ļ�����޸�ʱ��
				Calendar cal = Calendar.getInstance();  
		        long time = t.lastModified();  
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
		        cal.setTimeInMillis(time);   
		       
				if(t.isFile()==true){
					String temp = list[i]+"\r\t"+"�ļ�"+"\r\t"+formatter.format(cal.getTime())+"\r\t"+t.length()+"b"+"\r\n";
					rf.write(temp.getBytes()); 
				}
				else{
					String temp = list[i]+"\r\t"+"�ļ���"+"\r\t"+formatter.format(cal.getTime())+"\r\n";
					rf.write(temp.getBytes());
				}
			}
			 rf.close();//�ر��ļ���   
			
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}



