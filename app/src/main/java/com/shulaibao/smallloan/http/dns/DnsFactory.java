package com.shulaibao.smallloan.http.dns;


import com.shulaibao.smallloan.Base;

/**
 * 描述：
 * Created by Lee
 * on 2017/3/1.
 */

public class DnsFactory{
    private Dns mDns;
    private static DnsFactory mDnsFactory;
    public static DnsFactory getInstance(){
        if(mDnsFactory == null){
            mDnsFactory = new DnsFactory();
        }
        return mDnsFactory;
    }
    public Dns getDns(){
        if(mDns == null){
            if(Base.getEnvironment() == Base.DEBUG){
                mDns  = new DebugDns();
            }else if(Base.getEnvironment() == Base.LIVE){
                mDns  = new LiveDns();
            }else if(Base.getEnvironment() == Base.RELEASE){
                mDns  = new ReleaseDns();
            }
        }
        return mDns;
    }
    public void clearDns(){
        mDns = null;
    }
}
