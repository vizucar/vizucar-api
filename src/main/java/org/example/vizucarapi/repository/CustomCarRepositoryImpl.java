package org.example.vizucarapi.repository;

import org.example.vizucarapi.api.model.Car;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomCarRepositoryImpl implements CustomCarRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Car> searchByKeyword(String keyword) {

        String[] keywords = keyword.split("\\s+");


        Query query = new Query();


        List<Criteria> criteriaList = new ArrayList<>();


        for (String word : keywords) {

            List<Criteria> wordCriteriaList = new ArrayList<>();
            wordCriteriaList.add(Criteria.where("make").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("model").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("gearbox").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("transmission").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("cylinders").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("color").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("class").regex(word, "i"));
            wordCriteriaList.add(Criteria.where("fueltype").regex(word, "i"));


            if (word.matches("\\d+")) {
                wordCriteriaList.add(Criteria.where("year").is(Integer.parseInt(word)));
            }

            // Combine criteria for this word with OR logic within fields
            criteriaList.add(new Criteria().orOperator(wordCriteriaList.toArray(new Criteria[0])));
        }

        // If there are criteria to apply, combine them using AND operator
        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        // Execute the query and return the results
        return mongoTemplate.find(query, Car.class);
    }
}
