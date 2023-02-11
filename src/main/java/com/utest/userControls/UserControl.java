package com.utest.userControls;

import com.utest.userModels.UserModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserControl {
    private Properties properties = new Properties();
    private UserModel userEntity;

    public UserControl(){
        userEntity = new UserModel();
    }

    public UserModel userGenerator() {
        try {
            this.properties.load(new FileInputStream(new File("C:\\Users\\usuario\\IdeaProjects\\PruebaTecnicaLiteThinking\\src\\main\\resources\\utilities\\testData.properties")));

            userEntity.setFirst_name(this.properties.get("FIRST_NAME").toString());
            userEntity.setLast_name(this.properties.get("LAST_NAME").toString());
            userEntity.setEmail(this.properties.get("EMAIL").toString());
            userEntity.setAge(Integer.parseInt(this.properties.get("AGE").toString()));
            userEntity.setSalary(Integer.parseInt(this.properties.get("SALARY").toString()));
            userEntity.setDepartment(this.properties.get("DEPARTMENT").toString());


            return userEntity;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userEntity;
    }


}
