package hansomebo.proxy;

import hansomebo.common.impl.PrintServiceImpl;
import hansomebo.common.service.PrintService;
import hansomebo.proxy.dynamic.DynamicProxyCGLIB;
import hansomebo.proxy.dynamic.DynamicProxyJDK;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    @Test
    public void DynamicProxyJDKTest() {
        PrintService printServiceProxy = new DynamicProxyJDK<PrintService>(new PrintServiceImpl()).getProxyObject();
        printServiceProxy.PrintString("Test DynamicProxyJDK");
    }

    @Test
    public void DynamicProxyCGLIBTest() {
        PrintService printServiceProxy = new DynamicProxyCGLIB<PrintService>().getProxyObject(PrintServiceImpl.class);
        printServiceProxy.PrintString("Test DynamicProxyCGLIB");
    }
}
