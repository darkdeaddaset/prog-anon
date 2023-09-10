package anon.ddd.prorammer.service.crud;

/**
 * Базовые CRUD операции.
 *
 * @param <U> - ДТО для обновления.
 * @param <D> - ДТО.
 */
public interface CrudBasic<U, D> {

    /**
     * Получение по идентификатору.
     *
     * @param id - идентификатор.
     * @return D - ДТО.
     */
    D get(long id);

    /**
     * Сохранение.
     *
     * @param dto - Полученые данные для создания.
     * @return D - ДТО.
     */
    D save(D dto);

    /**
     * Обновление.
     * @param dtoUpdate - Полученые данные для обновления.
     * @return D - ДТО.
     */
    D update(U dtoUpdate);

    /**
     * Закрытие по идентификатору.
     *
     * @param id - идентификатор.
     */
    void closed(long id);
}
