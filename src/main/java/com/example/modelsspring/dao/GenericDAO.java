package com.example.modelsspring.dao;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class GenericDAO<T> {
    private static int ENTITY_COUNT = 0;
    private final List<T> entities = new ArrayList<>();
    public List<T> index() {
        return entities;
    }

    public T show(int id) {
        for (T entity : entities) {
            try {
                Field idField = entity.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                int entityId = (int) idField.get(entity);
                if (entityId == id) {
                    return entity;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void save(T entity) {
        try {
            Field idField = entity.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, ++ENTITY_COUNT);
            entities.add(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, T updatedEntity) {
        for (int i = 0; i < entities.size(); i++) {
            T entity = entities.get(i);
            try {
                Field idField = entity.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                int entityId = (int) idField.get(entity);
                if (entityId == id) {
                    entities.set(i, updatedEntity);
                    return;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        entities.removeIf(entity -> {
            try {
                Field idField = entity.getClass().getDeclaredField("id");
                idField.setAccessible(true);
                int entityId = (int) idField.get(entity);
                return entityId == id;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}
