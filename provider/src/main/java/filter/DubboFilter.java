package filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuiyt
 * @date 2019/12/11
 */
@Slf4j
@Activate(group = {Constants.PROVIDER})
public class DubboFilter implements Filter {

    private static Set<String> ignoreServices = new HashSet<>();
    private static Set<String> ignoreMethods = new HashSet<>();

    static {
        ignoreServices.add("com.foundersc.itc.product.service.ProductDrNVSyncRemoteService");

        ignoreMethods.add("queryFundCodesByType");
        ignoreMethods.add("queryAANVByDateAndFundCodes");
        ignoreMethods.add("queryAANVByFundCodeAndDates");
        ignoreMethods.add("queryTradeDateBetween");
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (ignore(invocation)) {
            return invoker.invoke(invocation);
        }

        long start = System.currentTimeMillis();
        Result result = invoker.invoke(invocation);
        long end = System.currentTimeMillis();

        //如果发生异常 则打印异常日志
        if (result.hasException() && invoker.getInterface() != GenericService.class) {
            log.error("dubbo provider exception: {} ", result.getException());
        } else {
            String response = result.getValue().toString();
            System.out.println("rsss" + response);
        }
        return result;
    }

    private boolean ignore(Invocation invocation) {
        return ignoreServices.contains(invocation.getInvoker().getInterface().getName()) || ignoreMethods.contains(invocation.getMethodName());
    }

}
