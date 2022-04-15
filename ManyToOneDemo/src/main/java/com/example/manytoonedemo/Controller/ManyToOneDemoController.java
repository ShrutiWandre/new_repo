package com.example.manytoonedemo.Controller;

import com.example.manytoonedemo.Exception.ResourceNotFoundException;
import com.example.manytoonedemo.Model.ManyToOneDemo;
import com.example.manytoonedemo.Service.ManyToOneDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demoapi")
public class ManyToOneDemoController {

    @Autowired
    private ManyToOneDemoService manyToOneDemoService;

    @GetMapping("manytoone")
    public List<ManyToOneDemo> getRecords(){
        return this.manyToOneDemoService.getRecords();
    }

    @GetMapping("manytoone/{id}")
    public ResponseEntity<ManyToOneDemo> getRecordById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return new  ResponseEntity<ManyToOneDemo>(manyToOneDemoService.getRecordById(id), HttpStatus.OK) ;
    }

    @PostMapping("manytoone")
    public ResponseEntity<ManyToOneDemo> saveRecord(@RequestBody ManyToOneDemo manyToOneDemo){
        return new ResponseEntity<ManyToOneDemo>(manyToOneDemoService.saveRecord(manyToOneDemo),HttpStatus.CREATED);
    }

    @PutMapping("manytoone/{id}")
    public ResponseEntity<ManyToOneDemo> updateRecord(@PathVariable (value = "id") int id, @Valid @RequestBody
            ManyToOneDemo RecordDetails) throws ResourceNotFoundException {
        return new ResponseEntity<ManyToOneDemo>(manyToOneDemoService.updateRecord(id, RecordDetails),HttpStatus.OK);
    }

    @DeleteMapping("manytoone/{id}")
    public Map<String, Boolean> deleteRecord(@PathVariable (value = "id") int id) throws ResourceNotFoundException{
        manyToOneDemoService.deleteRecord(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("1 row deleted", Boolean.TRUE);
        return response;
    }
}
