package com.zhifubao;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by HMF on 2021/06/30 15:24
 */
public class AppUtil {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117681749";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEEufwlkfSfx2gPUYsWp/cig19wkTNNjuIxX0g6UQVGVcsqVH5MCHm5OSyIvY/1+48PZwGBE7b1IcGaYfeLGI205NV98Nt3FA5c2YhZSbCIvqwzmaIH1Zxa4m/TOExGZgVUf4gwUzdtnNUPZNZarAvhkMAU+Ka+pQprzL592KrMTHSvGD8ON91WnWzXuqE7vArWG80792OV+7BEuwuBoaiotZC63KUhILEPZ8CYxt2keSUh1rUmO8UMl4QdAHFGfTvRP+3/kcLSthqzxsWKS4ognOIBNH8DbeqLAKIbuPJq267UZOXfC8n9nPMbAEizb9efHMrWBUmwyZK+LGcapFJAgMBAAECggEAZPfnJUBeTAgt5/CwEvx9Nia8RaYc3x1UyizgiiaKi+7BfD09k9k+MbxPMfgUdZ5oXNlkzBzDBMAnMbm/yxP3SZ7aBmDRoM1K74DPVTx1Mvl22XARZoM+nJrvxbXKerTsVXBHbVcZom33ITGp0jQD2XE1C60VkhF675smx35eiiyKMpMIBT00afxjSbralxMfkBsmwtvMOHy/ET1QB/lOA9qy01mUfmr87pq4T1fuqz5fggh0ZFi/dbv5+UrGnu5BIlDtlAvfJrYPubENFJi8YGcW0W/XkV1JPsFvt1RWmNcE1SWBQd7mLXqbx+MZUwUGNlN4/GM72ZFWsXdTllGPYQKBgQDCCnJaLVylweepoD8iXPSc3XBIHGFNIFQiZozqJa0OYWOl27lefsHp/ZdpYsgW3Ei0h6OTWMZzSTA4xuLdUeiISrjmf0bS0un0Dzjrl6da6pOc2CNWPxZly24b9LVyva1mGzL3b8TgoZBEuuIOifvOYdjCo9sVZ81eKUeP6ckkTQKBgQCuPxIAjXOQBrr9LViEV5xbZt5bvBdU8U46A/Hikk0dZpLhZgntnsAjJTgVTMnNG06+OjOhKGMgXrgJsG3bKOKX8DrgkmHcyjMZB04qzi00ooXXPxQSwCkLB9w1Umna7oMUGcl+GpLLIAzh6U/Qnh8+MiYEl7xQz3U71Ci7MPbO7QKBgCEVcuXZMiC47OzI+7q6KqLMRqak4BosVuv+nCwX/GelRz4yNmrcJeflavl29DKhoGvXbJZk3oEti2FC189wdbs3MktqjALKH0WTitrwYoJn2H83gt7jpsf4ZW+yy3UizfvIy2nQzrqWEWkGjCB6ekp3+GNHWMVPi35wf1kUPU1JAoGAWU9cc8oMvHqmpxPx9ctOCg8803oh31jbhqL0/PON8Q7dJAh/+DpRMvJlv40fNjDT+G6ufeDMhg/mdpjmhdl74vKvyuFcpaVB8YcsCoao5vySa1Qafs3de5joxq/aL+vmZYweGbOXH+PqlnRWg5A4ZVGg6OO5ExZyeVryEZg0OLUCgYAhHr7SSUtbKiL+y1o5X/xdorVTD6Oh9T/uj6awp8n/x/BG8WuwzaDhxlCzOZUNetKSw9O3EwRCOWx8PFDl1F3EOaYIweezCP9fc8GwuDY25FO02CLsSGymQBq4Dva4P4AnUTE3GVFqkx2Cb2cpWaxy8Y9UMppqSB8ryNVAtNrapQ==";

    // 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArPNbmc5cZvUnymtBMVJXaP7i5KOhpOUfl061oerGY3L8+wiJFwmvhaZ8KAEmqr0u79DZbCJW+vhuPucOA+LPTiUK/yIVaWtRbcV2l6MFOn+zfqyf9DQ5BU3w6nSrErSYMUuWsMai6tEqIM9HfEC0mn+CuWV3OWjwcYVe4WGvksluXICuqVS+mK8wU0Pputlu1AZYWJdvB5NLSmq/bJxtM9pGPYhYY6FcFSdqeLozNzQ4xXW6KCVc3bpSocQEwYYaICWCz4xpfGd0dxCTE9+325Uv02PfJ3qkfRU1iSIX/TfDb8DTUSNV7Jf4dzlnFc15YsZFkh8O409kLyiqe9oGKQIDAQAB";

    // 服务器异步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://88vxzv.natappfree.cc/getNotify";

    // 页面跳转同步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，在测试时要访问到本机，就只能是使用 natapp 内网穿透了
    public static String return_url = "http://88vxzv.natappfree.cc/getReturn";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关,注意这些使用的是沙箱的支付宝网关，与正常网关的区别是多了dev
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关，日志路径
    public static String log_path = "D:\\";

    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" +
                    System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
