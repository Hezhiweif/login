package com.yjxxt;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSQLSession {
    //加载核心配置文件
    static  InputStream in=null;
    static SqlSessionFactory fac=null;
    static {
        try {
            in= Resources.getResourceAsStream("mybatis.xml");
            fac=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //构建会话工厂获取会话
    public static SqlSession Session(){
        //获取会话
       SqlSession ses=null;
       if(fac!=null) {
           ses = fac.openSession(true);
       }
        return ses;
    }



}
