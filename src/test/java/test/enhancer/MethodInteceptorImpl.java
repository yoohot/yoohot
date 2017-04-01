package test.enhancer;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodInteceptorImpl implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//System.out.println("obj"+obj);
		
	    System.err.println("Before invoke " + method);
	    System.out.println(proxy);
        Object result = proxy.invokeSuper(obj, args);
        // result = method.invoke(obj, args);
        System.err.println("After invoke " + method);
        return result;
	}

}
