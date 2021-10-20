package sv.com.udb.services.authentication.models;

import io.undertow.util.Methods;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sv.com.udb.services.authentication.enums.IOAuthRegistrationType;
import sv.com.udb.services.authentication.enums.IRole;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Principal extends UserDetails {
   String getId();

   String getEmail();

   String getNombres();

   String getApellidos();

   String getFullName();

   String getUsername();

   String getPhoto();

   LocalDate getBirthday();

   default LocalDate getRegistration() {
      return LocalDate.now(ZoneId.of("GMT-06:00"));
   }

   default IOAuthRegistrationType getOAuthRegistrationType() {
      return IOAuthRegistrationType.YOUAPP;
   }

   default IRole getRol() {
      return IRole.ROLE_USER;
   }

   default Map<String, Object> fields() {
      Map<String, Object> cFields = new HashMap<>();
      List<Method> methods = Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(m -> m.getName().startsWith("get"))
            .collect(Collectors.toList());
      methods.forEach(m -> {
         String name = m.getName().substring(3);
         try {
            Object value = m.invoke(this);
            cFields.put(name, value);
         }
         catch (Exception e) {
            cFields.put(name, null);
         }
      });
      return cFields;
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