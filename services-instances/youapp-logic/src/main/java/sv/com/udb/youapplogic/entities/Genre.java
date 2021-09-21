package sv.com.udb.youapplogic.entities;

import lombok.Data;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("title", this.title);
        return jsonObject;
    }
}
