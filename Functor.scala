/**
 * A functor is a higher kinded type that takes in
 * a type constructor as its argument and provides
 * a map function!
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
}
