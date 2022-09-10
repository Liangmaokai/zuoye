package geektime.spring.springbucks.zuoye01.controller;

import geektime.spring.springbucks.zuoye01.entity.Fraction;
import geektime.spring.springbucks.zuoye01.entity.Student;
import geektime.spring.springbucks.zuoye01.service.IFractionService;
import geektime.spring.springbucks.zuoye01.service.IStudentService;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;

public class RestfulController {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IFractionService iFractionService;

    /*
    * return json
    */

    @GetMapping("/query/{id}")

    public Student selectOne(@PathVariable Long id){
        Student student =iStudentService.selectById(id);
        return student;
    }

    /*
    * return xml
    * */

    @GetMapping(path = "/query/xml/{id}",produces = MediaType.APPLICATION_XML_VALUE)
    public Fraction selectOneXml(@PathVariable long Id){
        Fraction fraction = iFractionService.selectById(Id);
        return fraction;
    }

}
