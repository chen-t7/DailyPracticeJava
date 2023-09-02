package com.chen.demo8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -11
 * Time: 23:52
 */
/*
class Student implements Comparable<Student>{
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        if (this.age > o.age) {
            return 1;
        } else if (this.age == o.age) {
            return 0;
        } else {
            return -1;
        }

        //return o.age- this.age;
        //return (int)(this.score - o.score);
        return this.name.compareTo(o.name);
    }
}
*/

class Student {
    public int age;
    public String name;
    public double score;

    public Student(int age, String name, double score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class TestDemo {
    public static void main3(String[] args) {
        Student student1 = new Student(15,"hhhh", 99.9);
        Student student2 = new Student(15,"cccc", 66.6);
        /*
        if (student1.compareTo(student2) > 0) {

        }
         */
        //System.out.println(student1.compareTo(student2));
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));
    }

    public static void main2(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(14,"hhhh", 99.9);
        students[1] = new Student(15,"cccc", 66.6);
        students[2] = new Student(13,"yyyy", 88.8);
        System.out.println(Arrays.toString(students));

        AgeComparator ageComparator = new AgeComparator();
        Arrays.sort(students, ageComparator);
        System.out.println(Arrays.toString(students));

        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(students, scoreComparator);
        System.out.println(Arrays.toString(students));

        NameComparator nameComparator = new NameComparator();
        Arrays.sort(students, nameComparator);
        System.out.println(Arrays.toString(students));

    }

    public static void main1(String[] args) {
        int[] array = {4,88,9,0,13,11};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
