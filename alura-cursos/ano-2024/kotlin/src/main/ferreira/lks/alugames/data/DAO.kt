package lks.alugames.data

import jakarta.persistence.EntityManager

sealed class DAO<TModel, TEntity>(
    private val entityManager: EntityManager,
    private val entity: Class<TEntity>
) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    fun getAll(): List<TModel> {
        val query = entityManager.createQuery("FROM ${entity.simpleName}", entity)
        return query.resultList.map { entityDTO -> toModel(entityDTO) }
    }

    fun create(model: TModel): Boolean {
        val entity = toEntity(model)
        return try {
            entityManager.transaction.begin()
            entityManager.persist(entity)
            entityManager.transaction.commit()
            println("Insert realizado com sucesso")
            true
        } catch (e: Exception) {
            println("Falha ao realizar insert")
            entityManager.transaction.rollback()
            false
        }
    }

    fun getById(id: Int): TModel? {
        val entity = entityManager.find(entity, id)
        return entity?.let { toModel(it) }
    }

    fun update(model: TModel): Boolean {
        val entity = toEntity(model)
        return try {
            entityManager.transaction.begin()
            entityManager.merge(entity)
            entityManager.transaction.commit()
            println("Update realizado com sucesso")
            true
        } catch (e: Exception) {
            println("Falha ao realizar update")
            entityManager.transaction.rollback()
            false
        }
    }

    fun delete(id: Int): Boolean {
        val entity = entityManager.find(entity, id)
        return try {
            entityManager.transaction.begin()
            entityManager.remove(entity)
            entityManager.transaction.commit()
            println("Delete realizado com sucesso")
            true
        } catch (e: Exception) {
            println("Falha ao realizar delete")
            entityManager.transaction.rollback()
            false
        }
    }


}