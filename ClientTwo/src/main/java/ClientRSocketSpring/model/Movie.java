package ClientRSocketSpring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
//@Document(collection = "movies")
public class Movie {
//    @Id
    private String id;
    private String name;
    private String price;

}
