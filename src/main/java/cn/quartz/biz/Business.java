package cn.quartz.biz;

import org.springframework.stereotype.Service;

/**
 * @author wenqi
 */
@Service("business")
public class Business {

    public void doIt(){
        System.out.println("business run result");
    }
}
