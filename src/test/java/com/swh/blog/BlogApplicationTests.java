package com.swh.blog;

import com.swh.blog.dao.TypeRepository;
import com.swh.blog.dao.UserRepository;
import com.swh.blog.po.Type;
import com.swh.blog.po.User;
import com.swh.blog.service.BlogService;
import com.swh.blog.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    TypeService typeService;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogService blogService;

    @Test
    void test1(){
        Optional<Type> a = typeRepository.findById(1l);
        System.out.println("【typeRepository.findById(1l)】"+a);
        System.out.println("【a == null?】"+(a==null));

        Optional<User> b = userRepository.findById(1l);
        System.out.println("【userRepository.findById(1l)】"+b);
        System.out.println("【userRepository.findById(1l).get()】"+b.get());
    }

    @Test
    void testMD5() throws NoSuchAlgorithmException {
        String source = "123456789";

        //1.获取MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("md5");
        //2.执行加密操作
        byte[] bytes = source.getBytes();
        System.out.println(bytes);

        //在MD5算法这，得到的目标字节数组的特点：长度固定为16
        byte[] targetBytes = digest.digest(bytes);

        //3.声明字符数组
        char [] characters = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        //4.遍历targetBytes
        StringBuilder builder = new StringBuilder();
        for (byte b : targetBytes) {

            //5.取出b的高四位的值 (先把高四位通过右移操作拽到低四位)
            int high = (b >> 4) & 15;

            //6.取出b的低四位的值
            int low = b & 15;

            //7.以high为下标从characters中取出对应的十六进制字符
            char highChar = characters[high];

            //8.以low为下标从characters中取出对应的十六进制字符
            char lowChar = characters[low];

            builder.append(highChar).append(lowChar);
        }

        System.out.println(builder.toString()); // 25F9E794323B453885F5181F1B624D0B (32位)
    }


}
