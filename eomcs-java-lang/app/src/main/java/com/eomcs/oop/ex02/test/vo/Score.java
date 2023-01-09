package com.eomcs.oop.ex02.test.vo;

//0) 낱개 변수 사용
//1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
//2) 리팩토링: 메서드 추출(extract method), static nested class
//3) 리팩토링: 메서드 추출(extract method) = 한 개의 메서드는 한 개의 기능을 수행해야 한다.
//4) GRASP(General Responsibility Assignment Software Patterns) 패턴
//5) 인스턴스 메서드: 인스턴스 주소를 받는 더 쉬운 문법
//6) 패키지 멤버 클래스:
//7) 클래스를 역할에 따라 패키지로 분류
//8) 생성자 도입: 인스턴스를 생성할 때 값을 초기화시키는 특별한 메서드

public class Score {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public Score(String n, int k, int e, int m) {
    this.name = n;
    this.kor = k;
    this.eng = e;
    this.math = m;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
