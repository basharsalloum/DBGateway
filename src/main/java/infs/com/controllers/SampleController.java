package infs.com.controllers;
import infs.com.domain.SQLServices.DbQuery;
import infs.com.domain.SQLServices.DbQueryService;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SampleController {

    Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private DbQueryService dbQueryService;

    @RequestMapping("/testControllers")
    public String sampleFunction(){
        return "Controllers OK";
    }

    @RequestMapping("/queries")
    public List<DbQuery> listAllQueries(){
        log.info("Displaying all queries");
        return dbQueryService.getAll();
    }

    //@RequestMapping("/queries/{id_in_arg}")
    //public DbQuery getDbQuery(@PathVariable("id_in_arg") String id) {
     @RequestMapping("/queries/{id}")
     public DbQuery getDbQuery(@PathVariable String id) {
         return dbQueryService.getDbQuery(id);
    }

    @RequestMapping("/DBGateway")
    public String runAgainstDb(){
        log.info("Sending message to DB");
        return "Sending message to DB";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/queries")
    public void addQuery(@RequestBody DbQuery query){
        dbQueryService.addQuery(query);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/queries/{id}")
    public void updateQuery(@RequestBody DbQuery query, @PathVariable("id") String id ){
        dbQueryService.updateQuery(id, query);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/queries/{id}")
    public void deleteQuery(@PathVariable String id ){
        dbQueryService.deleteQuery(id);
    }
}
