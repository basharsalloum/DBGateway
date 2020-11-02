package infs.com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DbQueryService {

    @Autowired
    private DbQueryRepository dbQueryRepository;

//    private List<DbQuery> savedQueries = new ArrayList<>(Arrays.asList(
//            new DbQuery("first", "Select * FROM ..... 1"),
//            new DbQuery("second", "Select * FROM ..... 1"),
//            new DbQuery("third", "Select * FROM ..... 1"))
//    );


    public List<DbQuery> getAll(){
        //return savedQueries;
        List<DbQuery> dbQueries = new ArrayList<>();
        dbQueryRepository.findAll().forEach(dbQueries::add);
        return dbQueries;
    }

    public DbQuery getDbQuery(String id){
        return this.getAll().stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addQuery(DbQuery query) {
        dbQueryRepository.save(query);
    }

    public void updateQuery(String id, DbQuery query) {
//        for (int i =0 ; i < savedQueries.size(); i++) {
//            DbQuery q = savedQueries.get(i);
//            if (q.getId().equals(id)) {
//                savedQueries.set(i,query);
//                return;
//            }
//        }
        dbQueryRepository.save(query);
    }

    public void deleteQuery(String id) {
        // savedQueries.removeIf(q -> q.getId().equals(id));
        dbQueryRepository.deleteById(id);
    }
}