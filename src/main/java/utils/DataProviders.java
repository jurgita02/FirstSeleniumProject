package utils;

import nat.demowebshop.models.NewUser;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> newUserRegistrationWithCSVFile() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userRegistration.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new NewUser().setName(split[0])
                    .setSurname(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setRepeat_password(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
