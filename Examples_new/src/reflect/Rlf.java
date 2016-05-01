package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

public class Rlf {

	/**
	 * @param args
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
		
			HashMap<String,String> nameVal = new HashMap<String,String>();
			
			ExBEan exBEan = new ExBEan();
	        Field[] declaredFields = exBEan.getClass().getDeclaredFields();
			for(Field field:declaredFields) {
				String name = field.getName();
				Method method = exBEan.getClass().getMethod(methodGetFromAttrName(name));
				Object invokeRes = method.invoke(exBEan, new Object[0]);
				nameVal.put(name, String.valueOf(invokeRes)); 
			}
			
			System.out.println("sizeMap:"+nameVal.size());
			
			Constructor<?>[] constructors = exBEan.getClass().getConstructors();
			 Constructor<?> constructor = constructors[0];
			TypeVariable<?>[] typeParameters = constructor.getTypeParameters();
			 //ExBEan newInstance = exBEan.getClass().newInstance();
			Class<?> forName = Class.forName("reflect.ExBEan");
			Object newInstance = forName.newInstance();
			if(newInstance instanceof reflect.ExBEan) {
				System.out.println("OK:");
				
			}
		}



private static String methodGetFromAttrName(String attrName) {
	if(attrName == null )
		throw new NullPointerException("ReflectionUtil.methodFromAttrName null attribute");
	
	if (attrName.length() == 0) return attrName;
	return "get" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
}

}
