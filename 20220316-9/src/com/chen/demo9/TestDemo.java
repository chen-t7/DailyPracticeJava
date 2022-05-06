package com.chen.demo9;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -05
 * Time: 16:37
 *
 * 创建对象的方法：
 * 1、new
 * 2.clone
 */
class Money implements Cloneable{
    public double m = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    public Money money = new Money();

    public void eat() {
        System.out.println("eat()");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person)super.clone();
        tmp.money = (Money)this.money.clone();
        return tmp;
        //return super.clone();
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person) person.clone();
        System.out.println(person.money.m);
        System.out.println(person2.money.m);

        person.money.m = 99.0;
        System.out.println(person.money.m);
        System.out.println(person2.money.m);

    }


    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.age = 99;

        Person person2 = (Person) person.clone();
        System.out.println(person2);
        System.out.println("==================");
        person2.age = 199;
        System.out.println(person);
        System.out.println(person2);
    }
}
