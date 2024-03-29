// In Kotlin, the job of multiple constructors can be done using default parameter values
class Player (val name : String, val level : Int = 1) {
    var lives = 3
    val score = 0

    var weapon : Weapon = Weapon("Fist", 1)

    private val inventory = ArrayList<Loot>()

    // We can also explicitly create secondary constructors if we want
    constructor(name : String, level: Int, lives : Int) : this(name, level) {
        this.lives = lives
    }

    fun showWeaponInfo() {
        println("Current Weapon: ${weapon.name}. Damage Inflicted: ${weapon.damageInflicted}.")
    }

    fun showInventory() {
        println("==========")
        println("Inventory if ${this.name}")

        for (item in inventory) {
            println(item)
        }

        println("==========")
    }

    fun getLoot(item : Loot) {
        inventory.add(item)
    }

    fun dropItem(item : Loot) : Boolean {
        return if (inventory.contains(item)) {
            inventory.remove(item)
            true
        } else {
            false
        }
    }

    fun dropItem(itemName : String) : Boolean {
        println("Dropping $itemName...")

        return inventory.removeIf { it.name == itemName }
    }

    override fun toString(): String {
        return "Player(name='$name', level=$level, lives=$lives, score=$score)"
    }
}