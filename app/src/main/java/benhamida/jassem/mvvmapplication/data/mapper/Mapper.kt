package benhamida.jassem.mvvmapplication.data.mapper

interface Mapper<Entity, Domain> {
    fun map(data: Entity): Domain
}