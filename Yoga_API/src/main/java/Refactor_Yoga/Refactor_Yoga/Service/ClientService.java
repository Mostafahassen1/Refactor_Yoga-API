package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.config.JwtService;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.entitymapper.ClientMapper;
import Refactor_Yoga.Refactor_Yoga.repository.ClientRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService implements BaseService<ClientDTO , Client> {

    PasswordEncoder passwordEncoder  ;
    private ClientRepository clientRepository ;
    private ClientMapper  clientMapper ;


    //
    private JwtService  jwtService ;
    private AuthenticationManager  authenticationManager ;


    public ClientService(PasswordEncoder passwordEncoder, ClientRepository clientRepository, ClientMapper clientMapper, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ClientDTO getById(String id) {
        UUID uuid = UUID.fromString(id) ;

        Client client = clientRepository.getById(uuid) ;

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
            throw new NoSuchElementException("this Element is not found ");



    }

    @Override
    public void save( Client object)
    {


        String hashPassword = passwordEncoder.encode(object.getPassword()) ;
      object.setPassword(hashPassword);

        clientRepository.save(object);

    }


    public String authentication (Client client) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        client.getEmail() ,
                        client.getPassword()
                )
        ) ;
        Client user = clientRepository.findByEmail(client.getEmail());
        String jwt = jwtService.generateToken(user);
        return jwt ;
    }




}





