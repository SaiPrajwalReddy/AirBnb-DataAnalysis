package HotelDataAnalysis.AirBnb;

import java.io.Serializable;

import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;

public class InputDataParser implements Serializable{

	/**
	 * BeainIo class used for mapping a string to an object 
	 */
	private static final long serialVersionUID = 1314653710912870309L;
	private static Object syncObject = new Object();
	
	public Object unmarshall(String beanName,String rec) {
		
		Object entity = null;
		synchronized (syncObject) {

			StreamFactory factory = StreamFactory.newInstance();
			factory.loadResource("mapping.xml");						
			Unmarshaller unmarshaller = factory.createUnmarshaller(beanName);

			entity = unmarshaller.unmarshal(rec);
			return entity;
		}
	}

}
