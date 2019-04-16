package upcnews.bean;

import upcnews.service.UserService;

public class test{

    public static void main(String[] argv) {
        Article a = new Article();
        System.out.println(a.tran("简体"));
        System.out.println(a.toString());
       User user=new User("t111111","111111");
        UserService userService=new UserService();
        userService.addUser(user);

    }}

