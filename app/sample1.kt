package com.example.yesable

fun main(){ // main()에서 함수를 호출해줘야 실행됨
    checkNum(2)
    helloworld()
    println(add(2,5))
    hi()
    // 3. String 템플릿
    val name = "EJ"
    val lastName = "K"
    println("My name is $lastName $name")
    println("My name is ${lastName + name}")
}

// 1. 함수
fun helloworld() : Unit { // void랑 비슷, 아무것도 리턴할 것 없을 때
    println("hello world !")
}

// 특이한게 변수 먼저, 타입 나중에
fun add(a : Int, b : Int) : Int { // Int로 반환 (대문자)
    return a + b
}

// 2. val과 var의 차이
// val은 value: 변하지 않는 값
// var은 variable: 변할 수 있는 수
fun hi(){
    val a : Int = 10 // 변할 수 없어!
    var b : Int = 9 // 변할 수 있어!
    b = 100
    println(b)

    var e : String
    var name = "name"
    println(name)
}

// 4. 조건식
fun maxBy(a : Int, b: Int) : Int {
    if (a>b){
        return a
    } else{
        return b
    }
}

// 위랑 같은 식은
fun maxBy2(a : Int, b : Int) : Int = if (a>b) a else b

fun checkNum(score : Int){
    // when은 switch문과 같다
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }

    var b : Int = when(score){
        1->1
        2->2 // return 개념
        // else를 꼭 써줘야 에러 안남
        else->3
    }

    print("b: ${b}\n")

    when(score){
        in 90..100->println("You are genius")
        in 10..80->println("not bad")
        else->println("okay")
    }
}

// 표현식과 조건문
// Expression vs Statement
// 표현식: 무언가를 만들어서 값을 만들어내는 것
// 조건문: 값을 만들어내지 않음
// 코틀린의 모든 함수는 표현식이다!!
// checkNum은 아무리 return 값이 없더라도 Unit이란것을 return하므로

// 6. 배열과 리스트 (Array vs List)
// array는 값을 바꿀 수 있다.
// list는 List, MutableList로 나뉘는데,
// List는 값을 변경 불가 (읽기 전용)
// MutableList는 값을 변경 가능 (읽기, 쓰기 모두 가능)
fun array(){
    // array, list 초기화
    var array = arrayOf(1,2,3)
    var list = listOf(1,2,3)
}