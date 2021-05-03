package Problem2

trait HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int])
}
