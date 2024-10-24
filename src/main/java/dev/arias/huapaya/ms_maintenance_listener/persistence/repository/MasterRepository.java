package dev.arias.huapaya.ms_maintenance_listener.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.arias.huapaya.ms_maintenance_listener.model.Master;

public interface MasterRepository extends MongoRepository<Master, String> {

}
