package com.xxxx._005_mybatisspringboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by HMF on 2021/05/27 17:59
 */

@Data
@NoArgsConstructor   // 添加构造函数，因为在 添加 和 修改 用户 的时候要用到
@AllArgsConstructor
public class User {
    private int id;
    private String userName;
    private String userPwd;
}
