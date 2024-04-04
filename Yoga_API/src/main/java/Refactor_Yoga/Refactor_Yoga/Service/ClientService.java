package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.entitymapper.ClientMapper;
import Refactor_Yoga.Refactor_Yoga.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService implements BaseService<ClientDTO , Client> {

    private  Client client ;
    private ClientRepository clientRepository ;
    private ClientMapper  clientMapper ;

    public ClientService() {
    }

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDTO getById(String id) {
        UUID uuid = UUID.fromString(id) ;

         client = clientRepository.getById(uuid) ;

        return clientMapper.ClientToClientDTO(client) ;
    }

    @Override
    public List<ClientDTO> getAll() {

        List<Client> clientList = clientRepository.findAll() ;

        return clientList.stream()
                .map(clientMapper :: ClientToClientDTO)
                .collect(Collectors.toList());

    }



    public void delete(String id) {

        UUID uuid = UUID.fromString(id) ;
        if(clientRepository.existsById(uuid))
            clientRepository.deleteById(uuid);
        else
            throw new NoSuchElementException();



    }

    @Override
    public void save( ClientDTO object)
    {
        client = clientMapper.ClientDTOToClient(object);
        clientRepository.save(client);
    }



}
