package collection.dequeue;

import java.util.List;;

public class TestClass {

	
	B b =new B();
	T t = new T();


	public void addData1(List <? super D> dataList)
	{
		Object object = dataList.get(0);
		//b =dataList.get(0);
		
		dataList.add(t);
		//dataList.add(b);
	}
	
	public void addData1(List <? extends D> dataList)
	{
		b= dataList.get(0);
		//b =dataList.get(0);
		
		dataList.add(new Object());
		//dataList.add(b);
	}
	
}
