package com.example.kotlinapp
interface A{
    fun printMe() {
        println(" method of interface A")
    }
}
interface B{
    fun printMeToo() {
        println("I am another Method from interface B")
    }
}


class InterfaceImp:A,B{
fun main(args:Array<String>){
    val obj=InterfaceImp()
    obj.printMe()
    obj.printMeToo()
}
}