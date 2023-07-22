package scala.gwent.cards


import munit.FunSuite

class IUnityCardTest extends FunSuite {
  // For a simple card
  val classification: Classification = Classification.Asedio
  val strength = 12
  val name: String = "Card1"
  val effect: String = "effect1"
  var unityCard: UnityCard = _

  // What is repeated before each test, to work on equal terms
  val classification2: Classification = Classification.Distance
  val strength2 = 20
  val name2: String = "Card2"
  val effect2: String = "effect2"
  var unityCard2: UnityCard = _

  // What is repeated before each test, to work on equal terms
  override def beforeEach(context: BeforeEach): Unit = {
    unityCard = new UnityCard(name, effect, classification, strength)
    unityCard2 = new UnityCard(name2, effect2, classification2, strength2)
  }

  /**
   * USUALLY it holds that if inst1 == inst2 ==> inst1.hashCode() == inst2.hashCode()
   * On the other way, the conversation is not necessarily fulfilled, i.e.
   * inst1.hashCode() == inst2.hashCode() =/=> inst1 == inst2
   */
  test("The hash code do not work.") {
    // it will be verified that two instances with different fields have different hashCode
    assertNotEquals(unityCard.hashCode(), unityCard2.hashCode())

    // Testing in the event that it has the same name and effect, with the other different fields
    val otherUnityCard = new UnityCard(name, effect, classification2, strength2)
    assertNotEquals(unityCard.hashCode(), otherUnityCard.hashCode())

    // Testing the case in which there is an instance with the same fields
    val similarUnityCard = new UnityCard(name, effect, classification, strength)
    assertEquals(unityCard.hashCode(), similarUnityCard.hashCode())
  }

  test("The equals method do not work.") {
    // it will be verified that two instances with different fields have different hashCode
    assertNotEquals(unityCard, unityCard2)

    // Testing in the event that it has the same name and effect, with the other different fields
    val otherUnityCard = new UnityCard(name, effect, classification2, strength2)
    assertNotEquals(unityCard, otherUnityCard)

    // Testing the case in which there is an instance with the same fields
    val similarUnityCard = new UnityCard(name, effect, classification, strength)
    assertEquals(unityCard, similarUnityCard)
    
    // Comparison test between two different cards
    val weatherCard = new WeatherCard(name, effect)
    // assertNotEquals(unityCard, weatherCard)
  }
}
