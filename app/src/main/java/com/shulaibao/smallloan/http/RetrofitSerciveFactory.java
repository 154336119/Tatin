package com.shulaibao.smallloan.http;

import com.shulaibao.smallloan.http.service.ContractService;
import com.shulaibao.smallloan.http.dns.DnsFactory;
import com.shulaibao.smallloan.http.service.BasicTextService;
import com.shulaibao.smallloan.http.service.ComService;
import com.shulaibao.smallloan.http.service.MessageService;
import com.shulaibao.smallloan.http.service.client.RetrofitBasicTxtClient;
import com.shulaibao.smallloan.http.service.client.RetrofitMsgClient;
import com.shulaibao.smallloan.http.service.client.RetrofitComClient;
import com.shulaibao.smallloan.http.service.client.RetrofitContractClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/20.
 */
public class RetrofitSerciveFactory {
    private static ConcurrentMap<Class,Object> mService = new ConcurrentHashMap();

    /**
     * 提供ComService服务
     * @return
     */
    public static ComService provideComService(){
       return provideService(DnsFactory.getInstance().getDns().getCommonBaseUrl(),ComService.class);
    }
    /**
     * 获取纯文本服务
     * @return
     */
    public static BasicTextService provideBasicTextComService(){
       return provideService(DnsFactory.getInstance().getDns().getBasicText(),BasicTextService.class);
    }

    /**
     *  合同服务
     * @return
     */
    public static ContractService provideContractService() {
        return provideService(DnsFactory.getInstance().getDns().getContractBaseUrl(), ContractService.class);
    }

    /**
     *  消息服务
     * @return
     */
    public static MessageService provideMessageService() {
        return provideService(DnsFactory.getInstance().getDns().getContractBaseUrl(), MessageService.class);
    }

    /**
     *
     * @param baseUrl
     * @param clz
     * @param <T>
     * @return
     */
    private static  <T>T provideService(String baseUrl,Class clz){
        Object object = mService.get(clz);
        if(object == null){
            object = mService.get(clz);
            if(object==null){
                if(baseUrl.equals(DnsFactory.getInstance().getDns().getCommonBaseUrl())){
                    object = RetrofitComClient.getInstance(baseUrl).createService(ComService.class);
                }else if(baseUrl.equals(DnsFactory.getInstance().getDns().getContractBaseUrl())){
                    object = RetrofitContractClient.getInstance(baseUrl).createService(ContractService.class);
                }else if(baseUrl.equals(DnsFactory.getInstance().getDns().getBasicText())){
                    object = RetrofitBasicTxtClient.getInstance(baseUrl).createService(BasicTextService.class);
                }else if(baseUrl.equals(DnsFactory.getInstance().getDns().getMsgUrl())){
                    object = RetrofitMsgClient.getInstance(baseUrl).createService(MessageService.class);
                }
            }
            mService.put(clz,object);
        }
        return (T)object;
    }
}
