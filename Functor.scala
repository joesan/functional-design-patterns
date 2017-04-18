/**
 * A functor is a higher kinded type that takes in
 * a type constructor as its argument and provides
 * a map function!
 * In simple terms, a Functor is just a mapping 
 * between categories, i.e., given two categories
 * A and B a Functor F maps the category A to category B 
 */
trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object Functor {
  // Let's now implement a OptionFunctor (as a type class)
  implicit val OptionFunctor = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa match {
      case Some(a) => Some(f(a))
      case None    => None
    }
  }

  // A ListFunctor
  implicit val ListFunctor = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa map f  
  }
  
  // Or any random Functor
  case class User[A](param1: A, param2: A)
  implicit val UserFunctor = new Functor[User] {
    def map[A, B](fa: User[A])(f: A => B): User[B] = User(f(fa.param1), f(fa.param2)) 
  }
  
  // Hmmm... a Function Functor... why not!
}
