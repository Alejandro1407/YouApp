package sv.com.udb.services.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sv.com.udb.services.commons.enums.IRole;
import sv.com.udb.services.commons.enums.IOAuthRegistrationType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public interface Principal extends UserDetails {
   String getId();

   String getEmail();

   String getNombres();

   String getApellidos();

   String getUsername();

   String getPhoto();

   LocalDate getBirthday();

   default String getFullName() {
      return String.format("%s %s", getNombres(), getApellidos());
   }

   default LocalDate getRegistration() {
      return LocalDate.now(ZoneId.of("GMT-06:00"));
   }

   default IOAuthRegistrationType getOAuthRegistrationType() {
      return IOAuthRegistrationType.YOUAPP;
   }

   default IRole getRol() {
      return IRole.ROLE_USER;
   }

   @JsonIgnore
   default Map<String, Object> getSummary() {
      var map = new HashMap<String, Object>();
      map.putAll(Map.of("id", getId(), "nombres", getNombres(), "apellidos",
            getApellidos(), "fullname", getFullName(), "email", getEmail(),
            "username", getUsername(), "birthday", getBirthday(), "photo",
            getPhoto() == null ? "" : getPhoto()));
      return map;
   }

   @Override
   default Collection<? extends GrantedAuthority> getAuthorities() {
      return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
   }

   @Override
   default boolean isEnabled() {
      return false;
   }

   @Override
   default boolean isAccountNonExpired() {
      return true;
   }

   @Override
   default boolean isAccountNonLocked() {
      return true;
   }

   @Override
   default boolean isCredentialsNonExpired() {
      return true;
   }
}
