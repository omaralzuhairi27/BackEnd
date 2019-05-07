package at.nacs.securitydatabase.security;

import at.nacs.securitydatabase.domain.model.Participant;
import at.nacs.securitydatabase.domain.model.User;
import at.nacs.securitydatabase.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
  private final UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<User> user = userRepository.findOneByUsername(username);
    if(user.isEmpty()){
      throw new UsernameNotFoundException(username);
    }
    return new UserPrincipal(user.get());
  }
}
