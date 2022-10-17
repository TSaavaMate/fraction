fun main() {
    val f1=Fraction(2,3)
    val f2=Fraction(8,18)
    val f3=Fraction(3,9)
    val f4=Fraction(7,9)
    val f5=Fraction(13,34)
    val f6=Fraction(28,58)
    val f7=Fraction(70,78)
    println(f1.toString())  //გამოტანა სტრინგად

    println(f2==f1)      //შედარება

    f2.simplify()
    println("შეკვეცილი=$f2")       //შეკვეცა

    f1.add(f2)
    f1.simplify()
    println("ჯამი=$f1")   // შეკრება

    f2.multiply(f3)
    f2.simplify()
    println("ნამრავლი=$f2")   //გამრავლება


    f4.divide(f5)
    f4.simplify()
    println("განაყოფი=$f4")   //გაყოფა

    f6.substract(f7)
    f6.simplify()
    println("სხვაობა=$f6")    //გამოკლება
}
interface fractionActions{
    fun tostring() //გამოტანა
    fun equals()//შედარება
    fun simplify()//შეკვეცა
    fun add() //შეკრება
    fun substract()//გამოკლება
    fun multiply()//გამრავლება
    fun divide()//გაყოფა

}
open class Fraction(public var numerator:Int,public var denominator:Int){
    override fun toString():String{
        return "$numerator / $denominator"
    }
    override fun equals(other:Any?):Boolean{    //შედარება
        if (other is Fraction){
            if (numerator*other.denominator==other.numerator*denominator){
                return true
            }
        }
        return false
    }
     fun simplify(): String {      //შეკვეცა
        var gcd0=gcd(numerator,denominator)
        numerator=numerator/gcd0
        denominator=denominator/gcd0
        return "$numerator / $denominator"
    }
     fun add(other: Any?){     //შეკრება
        if (other is Fraction){
            var gcd0=gcd(denominator,other.denominator)
            val newdenominator=(denominator*other.denominator)/gcd0
            val newnumerator=numerator*(newdenominator/denominator)+other.numerator*(newdenominator/other.denominator)
            numerator=newnumerator
            denominator=newdenominator
        }
    }
     fun multiply(other:Any?){    //გამრავლება
        if (other is Fraction){
            val newnumerator=numerator*other.numerator
            val newdenominator=denominator*other.denominator
            numerator=newnumerator
            denominator=newdenominator
        }
    }
     fun divide(other:Any?) {     //გაყოფა
        if (other is Fraction) {
            val newnumerator=denominator*other.numerator
            val newdenominator=numerator*other.denominator
            numerator=newdenominator
            denominator=newnumerator
        }
    }
     fun substract(other: Any?){     //გამოკლება
        if (other is Fraction){
            var gcd0=gcd(denominator,other.denominator)
            val newdenominator=(denominator*other.denominator)/gcd0
            val newnumerator=((numerator)*(newdenominator/denominator)-(other.numerator)*(newdenominator/other.denominator))
            numerator=newnumerator
            denominator=newdenominator
        }
    }




}
public fun gcd(numerator: Int, denominator: Int): Int {
    if (numerator == 0) {
        return denominator
    }
    return gcd(denominator%numerator, numerator)
}
