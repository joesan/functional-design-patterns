/**
 *
 *
 *
 */
trait Monad[M[_]] {
  def identity[A](a: A): M[A]
  def flatMap[A, B](a: M[A])(fn: A => M[B]): M[B]
}
