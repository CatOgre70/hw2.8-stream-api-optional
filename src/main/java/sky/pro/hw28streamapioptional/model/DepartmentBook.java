package sky.pro.hw28streamapioptional.model;

import java.util.HashMap;
import java.util.Map;

public class DepartmentBook {

    private final Map<String, Integer> depMap;

    public DepartmentBook() {
        this.depMap = new HashMap<>();
    }

    public void add(String name){
        int counter;
        if(depMap.isEmpty())
            counter = 0;
        else
            counter = depMap.size();
        if(!depMap.containsKey(name))
            depMap.put(name, counter);
    }

    public void remove(String name){
        if(depMap.containsKey(name))
            depMap.remove(name);
        else
            throw new RuntimeException("There is no such department in the Department Book");
    }

    public int findId(String name){
        if(depMap.containsKey(name))
            return depMap.get(name);
        else
            throw new RuntimeException("There is no such department in the Department Book");
    }

    public boolean checkName(String name){
        return depMap.containsKey(name);
    }

    public boolean checkId(int id){
        if(depMap.isEmpty()) {
            return false;
        }
        else {
            return depMap.keySet().stream()
                    .anyMatch(e -> depMap.get(e) == id);
        }
    }


    public String findName(int id){

        return depMap.keySet().stream()
                .filter(e -> depMap.get(e) == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no department with such id"));

    }

    public int size(){
        return depMap.size();
    }

}
