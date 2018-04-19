webservice服务端:
	采用cxf框架(Apache CXF = Celtix + XFire),提供了对 JAX-WS(协议) 全面的支持,
并且可以根据实际项目的需要，采用代码优先（Code First）或者 WSDL 优先（WSDL First）来轻松地实现 Web Services 的发布和使用。
	0.maven构建,webservice与spring整合;
	1.@WebService注解标注发布webservice服务;
	2.JAXB能够内置支持List和Set集合，但是对于Map的支持需要自己处理。
	  @XmlJavaTypeAdapter(MapAdapter.class)标注，指定对该变量专门的适配器进行处理。
	     适配器继承XmlAdapter类，并覆盖了marshal和unmarshal方法，分别用于对象到XML的映射和XML到对象的映射。
	3.<jaxws:inInterceptors>配置拦截进行日志记录TODO,接口权限控制等
----------------------------------------------------------
客户端调用:
1.	客户端所需lib
	commons-discovery-0.2.jar
	javax-wsdl_1.5.1jar
	commons-logging_1.0.4.jar
	axis.jar
	jaxrpc.jar
	saaj.jar
	activation.jar
	mail.jar
2.使用eclipse向导生成Web Service客户端
	new-->other-->web service client
3.调用细节见cn.ilumos.test.HelloWorldTest
	


	