/**
 * A Monoid is a type that defines the following laws:
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
