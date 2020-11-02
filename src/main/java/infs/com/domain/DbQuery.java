package infs.com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DbQuery {
    @Id
    String id;
    String body;

    public DbQuery() {
    }

    public DbQuery(String id, String body) {
        this.id = id;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
