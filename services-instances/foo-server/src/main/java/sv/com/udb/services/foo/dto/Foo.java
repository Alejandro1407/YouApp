package sv.com.udb.services.foo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {
   private long   id;
   private String name;
   // constructor, getters and setters
}