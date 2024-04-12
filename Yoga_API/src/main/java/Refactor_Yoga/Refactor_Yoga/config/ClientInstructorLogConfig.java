package Refactor_Yoga.Refactor_Yoga.config;

import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientInstructorLogConfig implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository ;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName , Password ;
        List<GrantedAuthority> authorities;
        Client client = clientRepository.findByEmail(username) ;
        if(client == null )
            throw new UsernameNotFoundException("User details not found for the user : " + username) ;
        else{
            userName = client.getEmail() ;
            Password = client.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(userName,Password,authorities);
    }




}




