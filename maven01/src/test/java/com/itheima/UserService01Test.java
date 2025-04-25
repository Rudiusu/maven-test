package com.itheima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@DisplayName("测试用户信息类")
public class UserService01Test {
    UserService us = new UserService();
//    @BeforeAll
//    public static void beforeAll(){
//        System.out.println("beforeAll");
//    }
//    @AfterAll
//    public static void afterAll(){
//        System.out.println("afterAll");
//    }
//    @BeforeEach
//    public void beforeEach(){
//        System.out.println("beforeEach");
//    }
//    @AfterEach
//    public void afterEach(){
//        System.out.println("afterEach");
//    }
//    @Test
//    public  void testGetAge() {
//
//      int age = us.getAge("339005199811106616");
//        System.out.println(age);
//    }

    @Test
    public void testGetGender(){
       String gender = us.getGender("339005199811106616");
        System.out.println(gender);
    }
    /*
    断言
    */
    @Test
    public void testGetGenderWithAssert(){
        String gender = us.getGender("339005199811106616");
        System.out.println(gender);
        Assertions.assertEquals("男",gender);
    }

    @Test
    public void testGetGenderException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            String gender = us.getGender("");
        });
    }

    /*
    参数化测试
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"339005199811106616","339005199811106636"})

    public void testGetGenderWithValues(String idCard){
        String gender = us.getGender(idCard);
        System.out.println(gender);
        Assertions.assertEquals("男",gender);
    }
}
