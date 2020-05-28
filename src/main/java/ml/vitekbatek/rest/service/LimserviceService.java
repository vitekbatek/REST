package ml.vitekbatek.rest.service;

import ml.vitekbatek.rest.model.Limservice;
import java.util.List;

public interface LimserviceService {
        /**
         * Создает новую услугу
         * @param limservice - услуга для создания
         */
        void create(Limservice limservice);

        /**
         * Возвращает список всех имеющихся услуг
         * @return список услуг
         */
        List<Limservice> readAll();

        /**
         * Возвращает услугу по её ID
         * @param id - ID услуги
         * @return - объект услуги с заданным ID
         */
        Limservice readOne(int id);


        /**
         * Удаляет услугу с заданным ID
         * @param id - id услуги, которую нужно удалить
         * @return - true если услуга была удалена, иначе false
         */
        boolean delete(int id);
}
