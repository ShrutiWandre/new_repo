package com.example.manytoonedemo.Service;

import com.example.manytoonedemo.Exception.ResourceNotFoundException;
import com.example.manytoonedemo.Model.ManyToOneDemo;

import java.util.List;

public interface ManyToOneDemoService {

    ManyToOneDemo saveRecord(ManyToOneDemo record);

    ManyToOneDemo getRecordById(int recordId) throws ResourceNotFoundException;

    List<ManyToOneDemo> getRecords();

    ManyToOneDemo updateRecord(int recordId, ManyToOneDemo recordUpdates) throws ResourceNotFoundException;

    void deleteRecord(int RecordId) throws ResourceNotFoundException;

}
