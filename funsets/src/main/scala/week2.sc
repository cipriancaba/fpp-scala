/**
  * We represent a set by its characteristic function, i.e.
  * its `contains` predicate.
  */
type Set = Int => Boolean

/**
  * Indicates whether a set contains a given element.
  */
def contains(s: Set, elem: Int): Boolean = s(elem)

/**
  * Returns the set of the one given element.
  */
def singletonSet(elem: Int): Set = (x: Int) => x == elem

/**
  * Returns the union of the two given sets,
  * the sets of all elements that are in either `s` or `t`.
  */
def union(s: Set, t: Set): Set = (x: Int) => s(x) || t(x)

/**
  * Returns the intersection of the two given sets,
  * the set of all elements that are both in `s` and `t`.
  */
def intersect(s: Set, t: Set): Set = (x: Int) => s(x) && t(x)

/**
  * Returns the difference of the two given sets,
  * the set of all elements of `s` that are not in `t`.
  */
def diff(s: Set, t: Set): Set = (x: Int) => s(x) && !t(x)

/**
  * Returns the subset of `s` for which `p` holds.
  */
def filter(s: Set, p: Int => Boolean): Set = (x: Int) => p(x)


/**
  * The bounds for `forall` and `exists` are +/- 1000.
  */
val bound = 1000

/**
  * Returns whether all bounded integers within `s` satisfy `p`.
  */
def forall(s: Set, p: Int => Boolean): Boolean = {
  def iter(a: Int): Boolean = {
    if (a == bound) p(a)
    else if (s(a)) p(a) && iter(a+1)
    else iter(a+1)
  }
  iter(-bound)
}

/**
  * Returns whether there exists a bounded integer within `s`
  * that satisfies `p`.
  */
def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, (x: Int) => !p(x))

/**
  * Returns a set transformed by applying `f` to each element of `s`.
  */
def map(s: Set, f: Int => Int): Set = {
  var acc = singletonSet(-3000)
  for (i <- -bound to bound if contains(s, i)) acc = union(acc, singletonSet(f(i)))

  return acc
}


/**
  * Displays the contents of a set
  */
def toString(s: Set): String = {
  val xs = for (i <- -bound to bound if contains(s, i)) yield i
  xs.mkString("{", ",", "}")
}

val s1 = singletonSet(1)
val s2 = singletonSet(2)
val s3 = singletonSet(3)

contains(s1, 1)
!contains(s1, 2)
contains(s2, 2)
contains(s3, 3)

val su = union(s1, s2)

contains(su, 1)
contains(su, 2)
!contains(su, 3)

val si1 = union(s1, s2)
val si2 = union(s1, s3)

contains(intersect(si1, si2), 1)
!contains(intersect(si1, si2), 2)

val sd1 = union(s1, s2)
val sd2 = union(s1, s3)

!contains(diff(sd1, sd2), 1)
contains(diff(sd1, sd2), 2)
!contains(diff(sd1, sd2), 3)


val sf1 = union(union(s1, s2), s3)

contains(filter(sf1, (x) => x > 2), 3)
!contains(filter(sf1, (x) => x > 2), 2)
!contains(filter(sf1, (x) => x > 2), 1)

forall((x: Int) => x > 1000, (y: Int) => y > 0)
forall((x: Int) => x > 1000, (y: Int) => y == -3)
forall((x: Int) => x > 1000, (y: Int) => y < 5)

exists((x: Int) => x >= 0, (y: Int) => y > 2)

println(toString(sf1))

print(toString(map(sf1, (x: Int) => x * 2)))