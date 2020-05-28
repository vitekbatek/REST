package ml.vitekbatek.rest.service;

import ml.vitekbatek.rest.model.Limservice;
import ml.vitekbatek.rest.repository.LimserviceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LimserviceServiceImpl implements LimserviceService {

        private LimserviceRepository limserviceRepository;

        public LimserviceServiceImpl(LimserviceRepository limserviceRepository) {
            this.limserviceRepository = limserviceRepository;
        }

        @Override
        public void create(Limservice limservice) {
            limserviceRepository.save(limservice);
        }

        @Override
        public List<Limservice> readAll() {
            return limserviceRepository.findAll();
        }

        @Override
        public Limservice readOne(int id) {
            return limserviceRepository.getOne(id);
        }


        @Override
        public boolean delete(int id) {
            if (limserviceRepository.existsById(id)) {
                limserviceRepository.deleteById(id);
                return true;
            }
            return false;
        }
}
