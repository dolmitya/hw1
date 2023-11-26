package edu.hw7.task3;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class PersonDatabaseImpl {
    private static final Map<Integer, Person> ID_MAP = new HashMap<>();
    private static final Map<String, Person> NAME_MAP = new HashMap<>();
    private static final Map<String, Person> ADDRESS_MAP = new HashMap<>();
    private static final Map<String, Person> PHONE_MAP = new HashMap<>();

    public int size() {
        return ID_MAP.size();
    }

    public synchronized void add(Person person) {
        ID_MAP.put(person.id(), person);
        if (person.name() != null) {
            NAME_MAP.put(person.name(), person);
        }
        if (person.address() != null) {
            ADDRESS_MAP.put(person.address(), person);
        }
        if (person.phoneNumber() != null) {
            PHONE_MAP.put(person.phoneNumber(), person);
        }
    }

    public synchronized void delete(int id) {
        if (ID_MAP.containsKey(id)) {
            Person person = ID_MAP.remove(id);
            NAME_MAP.remove(person.name());
            ADDRESS_MAP.remove(person.address());
            PHONE_MAP.remove(person.phoneNumber());
        }
    }

    public synchronized @Nullable Person findByName(String name) {
        if (NAME_MAP.containsKey(name)
            && NAME_MAP.get(name).address() != null
            && NAME_MAP.get(name).phoneNumber() != null) {
            return NAME_MAP.get(name);
        }
        return null;
    }

    public synchronized @Nullable Person findByAddress(String address) {
        if (ADDRESS_MAP.containsKey(address)
            && ADDRESS_MAP.get(address).phoneNumber() != null
            && ADDRESS_MAP.get(address).name() != null) {
            return ADDRESS_MAP.get(address);
        }
        return null;
    }

    public synchronized @Nullable Person findByPhone(String phone) {
        if (PHONE_MAP.containsKey(phone)
            && PHONE_MAP.get(phone).name() != null
            && PHONE_MAP.get(phone).address() != null) {
            return PHONE_MAP.get(phone);
        }
        return null;
    }
}
