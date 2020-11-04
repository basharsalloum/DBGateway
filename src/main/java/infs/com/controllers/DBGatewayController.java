package infs.com.controllers;

import infs.com.domain.SQLServices.DbQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

@RestController
public class DBGatewayController {
    String SQL_FILE_STORE = "C:\\SQL_FILE_STORE\\";
    Logger log = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/DBGateway/{file_id}")
    public String DBGatewayRunSql(@PathVariable String file_id) throws SQLException, ClassNotFoundException {
        log.info("DBGatewayRunSql receives statement from from end");
        /*
        1- Fetch the sql statement from the suitable file.
        2- Run statement.
        3- Return query.
         */

        // 1- Fetch the sql statement from the suitable file.
        // 1-1. Check the file exist.
        File sqlStat = new File(SQL_FILE_STORE + file_id );
        String sqlText="";
        try {
            Scanner sqlReader = new Scanner(sqlStat);
            while (sqlReader.hasNextLine()){
                String data = sqlReader.nextLine();
                sqlText = sqlText + " \n" + data;
                log.info(data);
            }
            sqlReader.close();
        } catch (FileNotFoundException e) {
            log.error("File not found {}", file_id);
            // e.printStackTrace();
        }

        //1-2. Check valid sql syntax.
        DbQuery dbQuery = new DbQuery(sqlText);

        //1-3. Load file
        return sqlText;

    }
}
