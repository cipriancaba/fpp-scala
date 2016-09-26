

//def test() {
//  println("Pascal's Triangle")
//  for (row <- 0 to 10) {
//    for (col <- 0 to row)
//      print(pascal(col, row) + " ")
//    println()
//  }
//}
//
///**
//  * Exercise 1
//  */
//def pascal(c: Int, r: Int): Int = {
//  if (c == 0 || c == r) 1
//  else pascal(c - 1, r - 1) + pascal(c, r - 1)
//}
//
///**
//  * Exercise 2
//  */
//def balance(chars: List[Char]): Boolean = {
//  true
//}
//
///**
//  * Exercise 3
//  */
//def countChange(money: Int, coins: List[Int]): Int = {
//  1
//}
//
//pascal(0,2)
//pascal(1,2)
//pascal(1,3)
//
//test()

//def balance(chars: List[Char]): Boolean = {
//  def findClosingMatches(countOfOpeningMatches: Int, chars: List[Char]): Boolean = {
//    if (chars.isEmpty || countOfOpeningMatches < 0) countOfOpeningMatches == 0
//    else
//      if (chars.head == '(') findClosingMatches(countOfOpeningMatches + 1, chars.tail)
//      else if (chars.head == ')') findClosingMatches(countOfOpeningMatches - 1, chars.tail)
//      else findClosingMatches(countOfOpeningMatches, chars.tail)
//  }
//
//  findClosingMatches(0, chars)
//}

//  def hasClosingCharacter(chars: List[Char]): Boolean = {
//    if (chars.isEmpty) false
//    else if (chars.head == ')') true else hasClosingCharacter(chars.tail)
//  }
//  if (chars.isEmpty) true
//  else
//    if (chars.head == '(') hasClosingCharacter(chars.tail.reverse)
//    else if (chars.head == ')') false else balance(chars.tail)


//  def hasClosingCharacter(chars: List[Char]): Boolean = {
//
//    if (chars.isEmpty) false
//    else
//    if (chars.head == ')') true else hasClosingCharacter(chars.tail)
//  }
//
//  if (chars.isEmpty) true
//  else
//    if (chars.head == '(') balance(chars.tail) && hasClosingCharacter(chars.tail)
//    else if (chars.head == ')') false else balance(chars.tail)
//}


//balance("".toList)
//!balance("(".toList)
//!balance(")".toList)
//balance("()".toList)
//balance("(if (zero? x) max (/ 1 x))".toList)
//balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)
//!balance(":-)".toList)
//!balance("())(".toList)

def countChange(money: Int, coins: List[Int]): Int = {
//  def canSubstract(differentCounts: Int, moneyAmount: Int, coins: List[Int]): Int = {
//    if (coins.isEmpty) differentCounts
//    else if (moneyAmount == 0) differentCounts + 1
//    else if (moneyAmount < 0) differentCounts
//    else canSubstract(differentCounts, moneyAmount - coins.head, coins) + canSubstract(differentCounts, moneyAmount - coins.head, coins.tail)
//  }
//  canSubstract(0, money, coins)

  if (money < 0 || coins.isEmpty) 0 else
    if (money == 0) 1 else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)


//  def sum(xs: List[Int]): Int = if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
//
//  def split(currentDenominations: List[Int], differentCounts: Int, availableCoinsLeft: List[Int]): Int = {
//    println(currentDenominations)
//    if (availableCoinsLeft.isEmpty) differentCounts else
//      if (sum(currentDenominations) == money) split(currentDenominations.tail, differentCounts + 1, availableCoinsLeft.tail)
//      else if (sum(currentDenominations) < money) split(currentDenominations :+ availableCoinsLeft.head, differentCounts, availableCoinsLeft)
//      else split(currentDenominations.tail, differentCounts, availableCoinsLeft)

//    if (moneyAmount == 0) differentCounts + 1
//    else if (moneyAmount < 0) differentCounts
//    else canSubstract(differentCounts, moneyAmount - coins.head, coins) + canSubstract(differentCounts, moneyAmount - coins.head, coins.tail)
}

countChange(4,List(1,2))
countChange(300,List(5,10,20,50,100,200,500))
countChange(301,List(5,10,20,50,100,200,500))
countChange(300,List(500,5,50,100,20,200,10))