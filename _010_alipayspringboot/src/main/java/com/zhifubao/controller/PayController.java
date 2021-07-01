package com.zhifubao.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zhifubao.utils.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HMF on 2021/07/01 09:53
 */
@Controller
public class PayController {
    // 因为方法使用了 @Bean 注解，所以返回的对象放在了Ioc容器中，在这里就可以直接注入了
    // 2.获得支付的客户端对象 AlipayClient，和配置支付信息的对象 AlipayTradePagePayRequest，即注入他们
    @Resource
    private AlipayClient alipayClient;

    @Resource
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    // 请求流程：前端页面点击付款按钮，提交到pay请求，即到后台这里，后台把数据传给支付宝
    // 处理支付请求
    // 1.接收页面传过来的数据：订单号、金额、名称、商品描述 ----- pay()方法的参数名 等于 表单中的 name 值

    /**
     * @param WIDout_trade_no 商品订单号
     * @param WIDsubject      订单名称
     * @param WIDtotal_amount 付款金额
     * @param WIDbody         商品描述
     */
    @RequestMapping("/pay")
    public void pay(String WIDout_trade_no, String WIDsubject, String WIDtotal_amount, String WIDbody, HttpServletResponse response) throws AlipayApiException, IOException {
        // 3.设置响应的地址（支付宝返回给商户的响应地址）
        alipayTradePagePayRequest.setNotifyUrl(AlipayUtil.notify_url);
        alipayTradePagePayRequest.setReturnUrl(AlipayUtil.return_url);

        // 4.设置请求的参数（传递给支付宝服务器的数据）
        alipayTradePagePayRequest.setBizContent(
                "{\"out_trade_no\":\"" + WIDout_trade_no + "\","
                        + "\"total_amount\":\"" + WIDtotal_amount + "\","
                        + "\"subject\":\"" + WIDsubject + "\","
                        + "\"body\":\"" + WIDbody + "\","
                        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}"
        );

        // 5.发送请求，返回响应结果
        String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();

        // 6.将响应结果返回显示给前端
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(result);
    }
}
