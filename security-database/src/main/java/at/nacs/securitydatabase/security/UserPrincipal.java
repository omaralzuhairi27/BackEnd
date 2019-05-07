package at.nacs.securitydatabase.security;

import at.nacs.securitydatabase.domain.model.User;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
@Value
public class UserPrincipal implements UserDetails {
  private User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<String> authorities=user.getAuthorities();
    return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
