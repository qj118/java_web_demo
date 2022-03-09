package org.demon.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.demon.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    @Test
    public void testBean(){
        Person person = new Person(7,"毛毛球");
        Gson gson = new Gson();

        //Bean to jsonString
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // jsonString to Bean
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    @Test
    public void testList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "毛球"));
        personList.add(new Person(2, "蛇团"));

        Gson gson = new Gson();
        // list to jsonString
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);

        // jsonString to list
        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list.get(0));
    }

    @Test
    public void testMap(){
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "毛球"));
        personMap.put(2, new Person(2, "蛇团"));

        Gson gson = new Gson();
        // Map to Json
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        // Json to Map
        //Map<Integer, Person> map = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer, Person> map = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());

        System.out.println(map.get(1));
    }
}
