package ml.vitekbatek.rest.service;

import ml.vitekbatek.rest.model.Transaction;
import java.util.List;

public interface TransactionService {
        /**
         * Создает новую оказанную услугу
         * @param transaction - оказанная услуга
         */
        void create(Transaction transaction);

        /**
         * Возвращает список всех оказанных услуг
         * @return список оказанных услуг
         */
        List<Transaction> readAll();

        /**
         * Возвращает оказанную услугу по её ID
         * @param id - ID оказанной услуги
         * @return - оказанную услугу с заданным ID
         */
        Transaction readOne(int id);


        /**
         * Удаляет оказанную услугу с заданным ID
         * @param id - id оказанной услуги, которую нужно удалить
         * @return - true если оказанная услуга была удалена, иначе false
         */
        boolean delete(int id);
}
