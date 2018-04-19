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
*@Description: webservice�ͻ���axis2���� 
*@author JingWeiye
*@Date: 2018��4��19������11:38:51
*/
public class HelloWorldTest {
	private static final String          wsurl = "http://localhost:8086/webservice/helloWorld";
	private HelloWorldProxy client;

	public HelloWorldTest() {
		this.client = new HelloWorldProxy();
	}
	/**
	 * �ͻ��˵���
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
			call.setTargetEndpointAddress("http://localhost:8086/webservice/helloWorld");//�˴�ΪwebServices��ַ
			call.setOperationName(new QName("http://webservice.crsc.com/", "getRoles"));////getRolesΪҪ���õķ�����  
//			call.addParameter(new QName("�˴�Ϊ�����ռ䣬ΪWSDL�ļ��е�targetNamespace��ַ",  
//		             "units"),XMLType.SOAP_STRING,ParameterMode.IN);//�����unitsΪ��������ı������� 
			call.setReturnType(new QName("http://webservice.crsc.com/", "getRoles"), MyRole[].class);//MyRole[]�������ص㣬��������ʱ��Ҫ��Щ���ã�MyRoleΪ���صĶ���
			SOAPHeaderElement element = new SOAPHeaderElement(new QName("arg"));
			element.addChildElement("userName").setValue("zhangsan");
			element.addChildElement("password").setValue("123456");
			call.addHeader(element);
			 // ע��ӳ���ϵ 
			QName qName2 = new QName("http://webservice.crsc.com/", "myRole");//�˴���myRoleΪWSDL�ļ���complexType name������ֵ 
			call.registerTypeMapping(MyRole.class, qName2,  
					new BeanSerializerFactory(MyRole.class, qName2),  
					new BeanDeserializerFactory(MyRole.class, qName2));//MyRole.classͬ�ϣ����ﲻ��ҪΪ����  
			MyRole[]  invoke = (MyRole[]) call.invoke(new Object[]{});
			System.out.println(Arrays.toString(invoke));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
