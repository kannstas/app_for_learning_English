package ru.nastya.App_for_learning_English.dao;

import org.springframework.stereotype.Component;
import ru.nastya.App_for_learning_English.model.Settings;
import ru.nastya.App_for_learning_English.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UsersDAO {
    private List<Settings> usersSettingsList = new ArrayList<>();
    {

    }


    public void saveSettingsForUser(Settings settings) {
        usersSettingsList.add(settings);
        System.out.println(settings);
        System.out.println(usersSettingsList);
    }
}
