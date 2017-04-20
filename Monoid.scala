/**
 * A Monoid is some type A that defines the following laws:
 * 1. A combinator operator which satisfies assosiativity
 * 2. A identity operator
 */
 trait Monoid[A] {
   def combine(a1: A, a2: A): A
   def identity: A
 }
 
 // With the Monoid definition, we can now write specific Monoids for
 
 val intMonoid = new Monoid[Int] {
   def combine(a1: Int, a2: Int) = a1 + a2
   def identity = 0
 }
 
 val stringMonoid = new Monoid[String] {
   def combine(a1: String, a2: String) = a1 + a2
   def identity = ""
 }
 
 val listMonoid = new Monoid[List[A]] {
   def combine(a1: List[A], a2: List[A]) = a1 ++ a2
   def identity = List[A].empty
 }

 val optionMonoid1 = new Monoid[Option[A]] {
   def combine(a1: Option[A], a2: Option[A2]) a1 orElse a2
   def identity = None
 }

 // a much better version of the OptionMonoid, using a Semigroup from cats
 import cats._
 def optionMonoid2[A: Semigroup]: Monoid[Option[A]] = new Monoid[Option[A]] {
    def combine(a1: Option[A], a2: => Option[A]) = (a1, a2) match {
      case (Some(a), Some(b)) => Some(Semigroup[A].append(a, b))
      case (Some(a), None)    => a
      case (None, Some(b))    => b
      case (None, None)       => None
    }

    def identity: Option[A] = None
  }
