package com.itheima;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
       //设置响应状态码
        response.setStatus(401);
       //设置响应头
        response.setHeader("name","cdd");
        //设置响应体
        response.getWriter().write("<h1>get response</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> responseEntity(){
        return ResponseEntity
                .status(200)
                .header("name","cdd")
                .body("<h1>responseEntity</h1>");
    }
}
