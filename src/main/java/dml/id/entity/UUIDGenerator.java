package dml.id.entity;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator<String> {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

}
