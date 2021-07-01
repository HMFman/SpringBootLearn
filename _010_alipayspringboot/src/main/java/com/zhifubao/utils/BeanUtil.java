package com.zhifubao.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HMF on 2021/07/01 09:51
 */
@Configuration
public class BeanUtil {
    // 创建支付宝所需要的对象
    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(
                AlipayUtil.gatewayUrl,
                AlipayUtil.app_id,
                AlipayUtil.merchant_private_key,
                "json",
                AlipayUtil.charset,
                AlipayUtil.alipay_public_key,
                AlipayUtil.sign_type
        );
    }

    // 支付信息的配置对象
    @Bean
    public AlipayTradePagePayRequest alipayTradePagePayRequest() {
        return new AlipayTradePagePayRequest();
    }
}
