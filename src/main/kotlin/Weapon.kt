class Weapon(val name : String, var damageInflicted : Int) {
    override fun toString(): String {
        return "Weapon(name='$name', damageInflicted=$damageInflicted)"
    }
}