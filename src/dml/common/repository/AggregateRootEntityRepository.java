package dml.common.repository;

/**
 * 聚合根实体的仓库，只用于聚合根对象。仓库负责存取实体，删除实体，不负责实体状态的持久化，这是repo和dao的区别，使用起来请不要混淆
 * 
 * @author neo
 *
 * @param <E>
 *            定义E类型的实体为聚合根
 * @param <I>
 *            实体的id类型
 */
public interface AggregateRootEntityRepository<E, I> {
	/**
	 * 只有仓库原来没有该实体才会放入
	 * 
	 * @param entity
	 */
	void putEntity(E entity);

	E getEntity(I id);

	void removeEntity(I id);

}
