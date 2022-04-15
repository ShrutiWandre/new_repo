package com.example.manytoonedemo.Service;

import com.example.manytoonedemo.Exception.ResourceNotFoundException;
import com.example.manytoonedemo.Model.ManyToOneDemo;
import com.example.manytoonedemo.Repository.ManyToOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToOneServiceImpl implements ManyToOneDemoService{

    @Autowired
    ManyToOneRepository manyToOneRepository;

    @Override
    public ManyToOneDemo saveRecord(ManyToOneDemo record) {
        return manyToOneRepository.save(record);
    }

    @Override
    public ManyToOneDemo getRecordById(int recordId) throws ResourceNotFoundException {
        return manyToOneRepository.findById(recordId).orElseThrow(() -> new ResourceNotFoundException(
                "Record not found for this Number :-> " + recordId));
    }

    @Override
    public List<ManyToOneDemo> getRecords() {
        return manyToOneRepository.findAll();
    }

    @Override
    public ManyToOneDemo updateRecord(int recordId, ManyToOneDemo recordUpdates) throws ResourceNotFoundException {
        ManyToOneDemo manyToOneDemo = manyToOneRepository.findById(recordId).orElseThrow(() -> new ResourceNotFoundException(
                "Record not found for this Number :-> " + recordId));

        manyToOneDemo.setCust_no(recordUpdates.getCust_no());
        manyToOneDemo.setCust_name(recordUpdates.getCust_name());
        manyToOneDemo.setCurrency(recordUpdates.getCurrency());
        manyToOneRepository.save(manyToOneDemo);
        return manyToOneDemo;

    }

    @Override
    public void deleteRecord(int RecordId) throws ResourceNotFoundException {
        manyToOneRepository.findById(RecordId).orElseThrow(() -> new ResourceNotFoundException(
                "Record not found for this Number :-> " + RecordId));
        manyToOneRepository.deleteById(RecordId);
    }
}
