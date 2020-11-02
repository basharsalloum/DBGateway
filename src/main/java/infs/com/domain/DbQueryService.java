package infs.com.domain;

import com.sun.deploy.ui.AboutDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DbQueryService {

    @Autowired
    private DbQueryRepository dbQueryRepository;

    private List<DbQuery> savedQueries = new ArrayList<>(Arrays.asList(
            new DbQuery("first", "Select * FROM ..... 1"),
            new DbQuery("second", "Select * FROM ..... 1"),
            new DbQuery("third", "Select * FROM ..... 1"))
    );


    public List<DbQuery> getAll(){
        //return savedQueries;
        List<DbQuery> dbQueries = new ArrayList<>();
        dbQueryRepository.findAll().forEach(dbQueries::add);
        return dbQueries;
    }

    public DbQuery getDbQuery(String id){
        return savedQueries.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addQuery(DbQuery query) {
        dbQueryRepository.save(query);
    }

    public void updateQuery(String id, DbQuery query) {
        for (int i =0 ; i < savedQueries.size(); i++) {
            DbQuery q = savedQueries.get(i);
            if (q.getId().equals(id)) {
                savedQueries.set(i,query);
                return;
            }
        }
    }

    public void deleteQuery(String id) {
        savedQueries.removeIf(q -> q.getId().equals(id));
    }
}
