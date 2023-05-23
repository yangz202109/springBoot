package com.study.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 配置自定义的国家和语言(当有自定义的就会取代系统的)
 * @author yangz
 * @create 2021-11-04-14:09
 */
public class MyLocaleResolver implements LocaleResolver{
    /**
     * 解析请求
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求参数
        String language = request.getParameter("l");

        //获取默认的
        Locale locale = Locale.getDefault();
        
        //如果默认的是空
        if (StringUtils.hasLength(language)){
            String[] split = language.split("_");
           return new Locale(split[0],split[1]);
        }else {
            return locale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
