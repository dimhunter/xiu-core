package com.shen.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenge on 15/11/30.
 *
 * Class.getResource和ClassLoader.getResource 区别
 *
 * 首先，Class和ClassLoader都有一个getResource(String path)和 getResourceAsStream(String path)方法
 *      其实他们的最终路径选择是一样的。
 *      getResource返回的是url，然后getPath可以获取路径
 *      getResourceAsStream返回的是InputStream，它相当于你用getResource()取得File文件后，再new InputStream(file)一样的结果。
 *
 * 所以，getResource 和 getResourceAsStream的路径是一样的，只不过是返回值不一样，用哪个自己选择。以下只讨论Class和ClassLoader的区别即可。
 *
 *  1.Class.getResource(String path)
 *      path 不以’/'开头时，默认是从此类所在的包下取资源；
 *      path 以’/'开头时，则是从ClassPath根下获取；
 *
 *  2.ClassLoader.getResource(path)
 *      path 不能以 ’/' 开头，返回是null ！！！
 *      path 不以’/'开头时，则是从ClassPath根下获取
 *      Class.getResource("/") 和 ClassLoader.getResource("") 取得路径是一样的，效果一样。
 */
public class PathUtils {

    private static Logger logger = LoggerFactory.getLogger(PathUtils.class);

    public void getPath(){
        String p1 = PathUtils.class.getResource("").getPath();
        String p11 = PathUtils.class.getResource("/").getPath();

        String p2 = PathUtils.class.getClassLoader().getResource("").getPath();
        String p22 = PathUtils.class.getClassLoader().getResource("/")+"";

        //如果没有文件，返回都是null
//        String p3 = Thread.currentThread().getContextClassLoader().getResource("log4j.propertiesddd").getPath();

        logger.debug(p1);
        logger.debug(p11);
        logger.debug(p2);
        logger.debug(p22);
//        logger.debug(p3);
    }


    public static void main(String[] args) {
        PathUtils pu = new PathUtils();
        pu.getPath();
    }

}
