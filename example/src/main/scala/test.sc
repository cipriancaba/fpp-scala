def sum(xs: List[Int]): Int = {
  if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
}

sum(List(1,3,4, 9))


def max(xs: List[Int]): Int =  {
  def maxVal(xs: List[Int]): Int =
    if (xs.length == 1) xs.head
    else  if (xs.head > maxVal(xs.tail)) xs.head
          else maxVal(xs.tail)

  if (xs.isEmpty) throw new NoSuchElementException() else maxVal(xs)

}

max(List(9,4,202,6))