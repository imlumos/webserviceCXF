package cn.ilumos.test;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.SOAPHeaderElement;
import org.junit.Test;

import com.ilumos.webservice.HelloWorldProxy;
import com.ilumos.webservice.MyRole;

/**
*@Description: webservice客户端axis2调用 
*@author JingWeiye
*@Date: 2018年4月19日上午11:38:51
*/
public class HelloWorldTest {
	private static final String          wsurl = "http://localhost:8086/webservice/helloWorld";
	private HelloWorldProxy client;

	public HelloWorldTest() {
		this.client = new HelloWorldProxy();
	}
	/**
	 * 客户端调用
	 * 
	 * @throws RemoteException
	 * @throws ServiceException
	 * @throws SOAPException
	 */
	@Test
	public void test() throws RemoteException, ServiceException, SOAPException{
		Service service=new Service();
		Call call = (Call) service.createCall();
		try {
			call.setTargetEndpointAddress("http://localhost:8086/webservice/helloWorld");//此处为webServices地址
			call.setOperationName(new QName("http://webservice.crsc.com/", "getRoles"));////getRoles为要调用的方法名  
//			call.addParameter(new QName("此处为命名空间，为WSDL文件中的targetNamespace地址",  
//		             "units"),XMLType.SOAP_STRING,ParameterMode.IN);//这里的units为传入参数的变量名字 
			call.setReturnType(new QName("http://webservice.crsc.com/", "getRoles"), MyRole[].class);//MyRole[]这里是重点，返回数组时主要在些配置，MyRole为返回的对象
			SOAPHeaderElement element = new SOAPHeaderElement(new QName("arg"));
			element.addChildElement("userName").setValue("zhangsan");
			element.addChildElement("password").setValue("123456");
			call.addHeader(element);
			 // 注册映射关系 
			QName qName2 = new QName("http://webservice.crsc.com/", "myRole");//此处的myRole为WSDL文件中complexType name的属性值 
			call.registerTypeMapping(MyRole.class, qName2,  
					new BeanSerializerFactory(MyRole.class, qName2),  
					new BeanDeserializerFactory(MyRole.class, qName2));//MyRole.class同上，这里不需要为数组  
			MyRole[]  invoke = (MyRole[]) call.invoke(new Object[]{});
			System.out.println(Arrays.toString(invoke));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
