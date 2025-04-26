package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用户服务测试")
public class UserServiceTest {
    UserService us;
     /*
      初始化实例
     */
     @BeforeEach
     public void setup(){
         us = new UserService();
     }
     /*
       测试性别用例
      */
     @DisplayName("测试性别-身份证号为null")
     @Test
     public void testGetGenderIfNull(){
         Assertions.assertThrows(IllegalArgumentException.class,()->{
             String gender = us.getGender(null);
         });
     }

     @DisplayName("测试性别-传入身份证号为空字符串")
     @Test
     public void testGetGenderIfBlankString(){
         Assertions.assertThrows(IllegalArgumentException.class,()->{
             String gender = us.getGender("");
         });
     }
     @DisplayName("测试性别-传入身份证号长度不足18位")
     @Test
     public void testGetGenderIfLessLength(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            String gender = us.getGender("33900");
        });
     }
     @DisplayName("测试性别-传入身份证号长度超出18位")
     @Test
     public void testGetGenderIfExceedLength(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            String gender = us.getGender("3390051998111066164");
        });
     }
     @DisplayName("测试性别-传入身份证号为女性")
     @Test
     public void testGetGenderIfFemale(){
        String gender = us.getGender("339005199811106626");
        Assertions.assertEquals("女",gender);
     }
     @DisplayName("测试性别-传入身份证号为男性")
     @Test
     public void testGetGenderIfMale(){
        String gender = us.getGender("339005199811106616");
        Assertions.assertEquals("男",gender);
     }

     /*
       测试年龄用例
      */
     @DisplayName("测试年龄-传入身份证号为null")
     @Test
     public void testGetAgeIfNull(){
         Assertions.assertThrows(IllegalArgumentException.class,()->{
             int age = us.getAge(null);
         });
     }

    @DisplayName("测试年龄-传入身份证号为空字符串")
    @Test
    public void testGetAgeIfBlankString(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            int age = us.getAge("");
        });
    }
    @DisplayName("测试年龄-传入身份证号长度不足18位")
    @Test
    public void testGetAgeIfLessLength(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            int age = us.getAge("33900");
        });
    }
    @DisplayName("测试年龄-传入身份证号长度超出18位")
    @Test
    public void testGetAgeIfExceedLength(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            int age = us.getAge("3390051998111066164");
        });
    }
//    @DisplayName("测试年龄-传入身份证号年龄小于0")
//    @Test
//    public void testGetAgeLessZero() throws Exception {
//
//             int age = us.getAge("339005202504266616");
//        System.out.println(age);
//
//        Assertions.assertEquals(-1,age);
//    }
    @DisplayName("测试年龄-传入正常身份证号")
    @Test
    public void testGetAge() throws Exception {
          int age = us.getAge("339005199811106616");
          Assertions.assertEquals(26,age);
    }
}
