package traits

/**
 * Traits
 * - Composition of behaviors
 * - Runtime implementation of interfaces
 * - Compatibility with static type checking/compilation
 * - traits can implement interfaces with implements
 * - traits can extend another traits with extends
 * - traits can define properties
 */
trait Marks {
    int marks1

    void displayMarks() {
        println("Display Marks " + marks1)
    }
}