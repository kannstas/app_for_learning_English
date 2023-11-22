package ru.nastya.App_for_learning_English.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nastya.App_for_learning_English.dao.UsersDAO;
import ru.nastya.App_for_learning_English.enumeration.LearnMode;
import ru.nastya.App_for_learning_English.model.Settings;


@Controller
@RequestMapping("/learn")
public class AppController {

    private UsersDAO usersDAO;

    public AppController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping("/settings")
    public String askSettings(@ModelAttribute("settings") Settings settings) {
        return "application/settings";
    }

    @PostMapping()
    public String saveSettings(
            @ModelAttribute("wordsToLearn") String wordsToLearn,
            @ModelAttribute("mode") LearnMode mode
    ) {

        usersDAO.saveSettingsForUser(new Settings(wordsToLearn, mode));
        return "application/good";
    }
}



        /*
        @GetMapping("/learn")
        public String choice() throws IOException {
         model.addAttribute("choice", modes.choice());
            return "/application/choiceMode";

        }

         */





