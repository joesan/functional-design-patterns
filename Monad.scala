/**
 *
 *
 *
 */
 trait Monad[A] {
   def map[B](f: A => B): F[B]
   def flatMap[B](f: A => Monad[B]): Monad[B]
 }
