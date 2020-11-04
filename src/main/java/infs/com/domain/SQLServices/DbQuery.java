package infs.com.domain.SQLServices;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class DbQuery {
    @Id
    String id;
    String body;
    boolean valid;
    List<String> cols;
    List<String> colsAliases;
    List<String> colsCalcFormulas;
    List<String> whereStatements;

    /*
    Will try to contrcut a query object from a string line

    input: Any String
    output: an object from this class  with (valid = True)

    pSql = Potentential sql statement
     */
    public DbQuery(String sqlText) {
        this.id = null;
        this.body = sqlText;



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
