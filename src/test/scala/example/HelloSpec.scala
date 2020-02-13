package example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    RPSLS.greeting shouldEqual "hello"
  }
}
