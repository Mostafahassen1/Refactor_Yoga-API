package Refactor_Yoga.Refactor_Yoga.config;

import Refactor_Yoga.Refactor_Yoga.Enum.Role;
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
        String userName = null  ;
        String Password  = null ;
        List<GrantedAuthority> authorities = new ArrayList<>();;
        Client client = clientRepository.findByEmail(username) ;

         if(client != null){
            userName = client.getEmail() ;
            Password = client.getPassword();
            Role role = client.getRole() ;
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        }

        if( userName == null  || Password == null )
            throw new UsernameNotFoundException("User details not found for the user : " + username) ;


        return new User(userName,Password,authorities);
    }


}




