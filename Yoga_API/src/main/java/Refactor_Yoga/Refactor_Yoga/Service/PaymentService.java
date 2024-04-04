package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.PaymentDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Payment;
import Refactor_Yoga.Refactor_Yoga.entitymapper.PaymentMapper;
import Refactor_Yoga.Refactor_Yoga.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentService implements BaseService<PaymentDTO, Payment> {
    private Payment payment ;
    private PaymentMapper paymentMapper ;
    private PaymentRepository paymentRepository ;

    public PaymentService() {
    }

    public PaymentService(PaymentMapper paymentMapper, PaymentRepository paymentRepository) {
        this.paymentMapper = paymentMapper;
        this.paymentRepository = paymentRepository;
    }



    @Override
    public PaymentDTO getById(String id) {

        UUID uuid = UUID.fromString(id) ;
        payment = paymentRepository.getById(uuid) ;
        return paymentMapper.PAYMENT_TO_DTO(payment) ;

    }

    @Override
    public List<PaymentDTO> getAll() {

        List<Payment> paymentList = paymentRepository.findAll() ;
        return paymentList.stream()
                .map( paymentMapper :: PAYMENT_TO_DTO)
                .collect(Collectors.toList());
    }


    public void delete(String id) {


        UUID uuid = UUID.fromString(id);
        if( paymentRepository.existsById(uuid))
            paymentRepository.deleteById(uuid);
        else
            throw new NoSuchElementException();

    }

    @Override
    public void save(PaymentDTO object) {

         payment = paymentMapper.DTO_TO_PAYMENT(object) ;
        paymentRepository.save(payment) ;

    }
}
