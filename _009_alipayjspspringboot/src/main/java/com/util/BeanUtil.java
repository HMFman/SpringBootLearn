package com.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zhifubao.AppUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HMF on 2021/06/30 15:58
 */

@Configuration
public class BeanUtil {
    // 创建支付宝所需要的对象
    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(
                AppUtil.gatewayUrl,
                AppUtil.app_id,
                AppUtil.merchant_private_key,
                "json",
                AppUtil.charset,
                AppUtil.alipay_public_key,
                AppUtil.sign_type
        );
    }

    // 支付信息的配置对象
    @Bean
    public AlipayTradePagePayRequest alipayTradePagePayRequest() {
        return new AlipayTradePagePayRequest();
    }
}
