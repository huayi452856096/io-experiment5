package SerializableTest;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ObjectIOTest {

	public static void main(String[] args) {
		try{
			
		//读取文件list.txt
		Scanner sc = new Scanner(new FileInputStream("d://list.txt"),"utf-8");
		List<Student> list = new ArrayList<Student>();
		while(sc.hasNext()) {
			Student tmp = new Student();
			tmp.setID(sc.next());
			tmp.setName(sc.next());
			tmp.setSex(sc.next());
			list.add(tmp);
		}
		
		//排序
		for(int i=1;i<list.size();i++){
			for(int j=0;j<list.size()-i;j++){
				if(list.get(j).getID().compareTo(list.get(j+1).getID()) > 0){
					Student temp = new Student();
					temp.setID(list.get(j+1).getID());
					temp.setName(list.get(j+1).getName());
					temp.setSex(list.get(j+1).getSex());
					
					list.get(j+1).setID(list.get(j).getID());
					list.get(j+1).setName(list.get(j).getName());
					list.get(j+1).setSex(list.get(j).getSex());
					
					list.get(j).setID(temp.getID());
					list.get(j).setName(temp.getName());
					list.get(j).setSex(temp.getSex());
	
				}
			}
		}
		System.out.println("已经按照学号排序！！");
		System.out.println("-------------------------------------------------");
		//for(Student s:list){System.out.println(s.getID()+s.getName());}
		
		//序列化
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("src/student.bin"));
		for(int i=0;i<list.size();i++){
			oo.writeObject(list.get(i));
			//System.out.println(list.get(i).getID()+list.get(i).getName()+list.get(i).getSex());
		}
		oo.close();
		
		//反序列化
		
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream("src/student.bin"));
		for(int i=0;i<list.size();i++){
			Student stu1 = (Student)oi.readObject();
			System.out.println(stu1.getID()+stu1.getName()+stu1.getSex());
		}
		
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
