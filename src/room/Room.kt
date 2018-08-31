package room

data class SlotAvailability(val free: Int, val total: Int, val occupied: Int = free - total)

data class Room(val name: String, val slots: SlotAvailability)