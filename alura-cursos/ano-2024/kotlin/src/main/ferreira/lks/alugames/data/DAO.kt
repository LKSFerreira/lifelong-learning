package lks.alugames.data

import jakarta.persistence.EntityManager

sealed class DAO<TModel, TEntityDTO>(
    private val entityManager: EntityManager,
    private val entityDTO: Class<TEntityDTO>
) {
    abstract fun toEntityDTO(model: TModel): TEntityDTO
    abstract fun toModel(entityDTO: TEntityDTO): TModel

    fun getAll(): List<TModel> {
        val query = entityManager.createQuery("FROM ${entityDTO.simpleName}", entityDTO)
        return query.resultList.map { entityDTO -> toModel(entityDTO) }
    }

    fun create(model: TModel): Boolean {
        val entityDTO = toEntityDTO(model)
        return try {
            entityManager.transaction.begin()
            entityManager.persist(entityDTO)
            entityManager.transaction.commit()
            println("Insert realizado com sucesso")
            true
        } catch (e: Exception) {
            entityManager.transaction.rollback()
            false
        }
    }

    fun getById(id: Int): TModel? {
        val entityDTO = entityManager.find(entityDTO, id)
        return entityDTO?.let { toModel(it) }
    }

    fun update(model: TModel): Boolean {
        val entityDTO = toEntityDTO(model)
        return try {
            entityManager.transaction.begin()
            entityManager.merge(entityDTO)
            entityManager.transaction.commit()
            println("Update realizado com sucesso")
            true
        } catch (e: Exception) {
            entityManager.transaction.rollback()
            false
        }
    }

    fun delete(id: Int): Boolean {
        val entityDTO = entityManager.find(entityDTO, id)
        return try {
            entityManager.transaction.begin()
            entityManager.remove(entityDTO)
            entityManager.transaction.commit()
            println("Delete realizado com sucesso")
            true
        } catch (e: Exception) {
            entityManager.transaction.rollback()
            false
        }
    }


}