package ml.vitekbatek.rest.service;

import ml.vitekbatek.rest.model.Transaction;
import ml.vitekbatek.rest.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

        private TransactionRepository transactionRepository;

        public TransactionServiceImpl(TransactionRepository transactionRepository) {
            this.transactionRepository = transactionRepository;
        }

        @Override
        public void create(Transaction transaction) {
            transactionRepository.save(transaction);
        }

        @Override
        public List<Transaction> readAll() {
            return transactionRepository.findAll();
        }

        @Override
        public Transaction readOne(int id) {
            return transactionRepository.getOne(id);
        }


        @Override
        public boolean delete(int id) {
            if (transactionRepository.existsById(id)) {
                transactionRepository.deleteById(id);
                return true;
            }
            return false;
        }
}
