import ch19.CardType
import ch19.Crust
import ch19.PizzaShop
import ch19.Size

def getPizza(closure) {
    PizzaShop pizzaShop = new PizzaShop()
    closure.delegate = pizzaShop // 여기가 핵심
    closure()
}

time = getPizza {
    setSize Size.LARGE
    setCrust Crust.THIN
    setTopping "Olives", "Onions", "Bell Pepper"
    setAddress "101 Main St., ..."
    setCard(CardType.VISA, "1234-1234-1234-1234")
}

printf "Pizza will arrive in %d minutes\n", time
